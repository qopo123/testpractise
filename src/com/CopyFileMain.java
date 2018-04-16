package com;

import org.apache.poi.util.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class CopyFileMain {
  @SuppressWarnings({"resource", "unused"})
  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(System.in);
    System.out.println("请输入需要生成的文件数量");
    int sumnum = scan.nextInt();
    Scanner scan2 = new Scanner(System.in);
    System.out.println("请输入原xml文件地址:");
//    // "C:\\Users\\Administrator\\Desktop\\ZIP_999_201412\\ZIP_999_201412\\ZZ_999_201412.xml";
    String xmlfilepath = scan2.nextLine();
//    // "D:\\数据\\text.xml"
    Scanner scan3 = new Scanner(System.in);
    System.out.println("请输入生成的xml文件存放位置:");
    String desxmlfilepath = scan3.nextLine();
//    // 生成xml数据
    System.out.println("开始生成xml数据");
    makexmldata(xmlfilepath, sumnum, desxmlfilepath);
    System.out.println("xml数据成功生成");
    //StringBuffer sb = new StringBuffer();
    //Scanner scan4 = new Scanner(System.in);
//    while (true) {
//      System.out.println("请输入原凭证附件位置,结束输入:0");
//      String info = scan4.nextLine();
//      if (String.valueOf(info).equals("0")) {
//        break;
//      } else {
//        sb.append(info+";");
//      }
//    }
    //String[] filearr = sb.toString().split(";");
//    File[] files = new File[filearr.length];
//    for (int i = 0; i < files.length; i++) {
//      files[i] = new File(filearr[i]);
//    }
    //Scanner scan5 = new Scanner(System.in);
    //System.out.println("请输入生成凭证附件存放目录");
    //String attdir = scan5.nextLine();
    System.out.println("请输入原凭证pdf位置:");
    Scanner scan6 = new Scanner(System.in);
    String pdfurl = scan6.nextLine();
    File pdffile = new File(pdfurl);
    System.out.println("请输入生成的pdf存放目录");
    Scanner scan7 = new Scanner(System.in);
    String desfile = scan7.nextLine();
    System.out.println("开始生成凭证和凭证附件");
    for (int i = 1; i <= sumnum; i++) {
      // 生成pdf文件
      makePdfFiles(pdffile, i, desfile);
      // 生成附件
      //makeAttachFiles(files, i, attdir);
    }
    System.out.println("凭证和凭证附件成功生成");

  }

  // 读取本地xml文件生成xml文件
  private static void makexmldata(String xmlfilepath, int sum, String desxmlfilepath)
      throws Exception {
    // 读xml文件，创建document文档对象
    File f = new File(xmlfilepath);
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    // 解析
    Document doc = builder.parse(f);
    // 写
    DocumentBuilderFactory factorywrite = DocumentBuilderFactory.newInstance();
    DocumentBuilder builderwrite = factorywrite.newDocumentBuilder();
    Document docwrite = builderwrite.newDocument();
    Element root = docwrite.createElement("总账");
    docwrite.appendChild(root);
    for (int n = 1; n <= sum; n++) {
      // 获取名称为记账凭证的所有标签的数量
      NodeList nl = doc.getElementsByTagName("记账凭证");
      for (int i = 0; i < 2; i++) {
        // 查询要复制的内容
        Element element = docwrite.createElement("记账凭证");
        element.setTextContent("\n");
        if (doc.getElementsByTagName("记账凭证编号").item(i).getFirstChild().getNodeValue()
            .equals("记-0001")) {
          NodeList childlist = nl.item(i).getChildNodes();
          for (int j = 0; j < childlist.getLength(); j++) {
            if (childlist.item(j) instanceof Element) {
              root.appendChild(element);
              Element nameElement = docwrite.createElement(childlist.item(j).getNodeName());
              Text nameValue = docwrite.createTextNode(childlist.item(j).getTextContent());
              element.appendChild(nameElement);
              if (childlist.item(j).getNodeName().equals("记账凭证编号")) {
                String vouchernum =
                    doc.getElementsByTagName("记账凭证编号").item(i).getFirstChild().getNodeValue();
                String[] value = vouchernum.split("-");
                nameElement.setTextContent(
                    value[0] + "-" + String.format("%04d",Integer.parseInt(value[1]) + n));
              } else {
                nameElement.appendChild(nameValue);
              }
              // 处理换行
              if (j == (childlist.getLength() - childlist.getLength() / 2)) {
                nameElement.setTextContent("\n");
              }
            }
          }
        }
      }
    }
    Transformer t = TransformerFactory.newInstance().newTransformer();
    //设置输出文件xml文件内容的编码方式为gbk,不设置会乱码
    t.setOutputProperty(OutputKeys.ENCODING, "GBK");
    //生成新的xml文件到指定位置
    t.transform(new DOMSource(docwrite),
        new StreamResult(new FileOutputStream(new File(desxmlfilepath))));
  }

  // 读取本地附件生成附件
  private static void makeAttachFiles(File[] files, int addnum, String attdir) throws Exception {
    for (int i = 0; i < files.length; i++) {
      File file = files[i];
      // 处理文附件名
      String desname = makeattachname(file, addnum);
      FileInputStream fispdf = new FileInputStream(file);
      FileOutputStream fospdf = new FileOutputStream(new File(attdir + desname));
      fospdf.write(IOUtils.toByteArray(fispdf));
      fospdf.close();
    }
  }

  // 处理附件名称
  private static String makeattachname(File attachfile, int addnum) {
    String sourcename = attachfile.getName();
    String[] name = sourcename.split("_");
    String[] namepdf = name[4].split("-");
    int numpdf = Integer.parseInt(namepdf[1]);
    int num = Integer.parseInt(name[5]);
    if (String.valueOf(num).length() == 1) {
      String desnametemp = sourcename.replace(name[5], "00" + String.valueOf(num));
      String desname =
          desnametemp.replace(name[4], namepdf[0] + "-" + String.valueOf(numpdf + addnum));
      return desname;
    } else if (String.valueOf(num).length() == 2) {
      String desnametemp = sourcename.replace(name[5], "0" + String.valueOf(num));
      String desname =
          desnametemp.replace(name[4], namepdf[0] + "-" + String.valueOf(numpdf + addnum));
      return desname;
    } else {
      String desnametemp = sourcename.replace(name[5], String.valueOf(num));
      String desname =
          desnametemp.replace(name[4], namepdf[0] + "-" + String.valueOf(numpdf + addnum));
      return desname;
    }

  }

  // 生成pdf文件
  private static void makePdfFiles(File pdffile, int addnum, String desfile) throws Exception {
    // 处理文件名
    String desname = makepdfname(pdffile, addnum);
    FileInputStream fispdf = new FileInputStream(pdffile);
    FileOutputStream fospdf = new FileOutputStream(new File(desfile + desname));
    fospdf.write(IOUtils.toByteArray(fispdf));
    fospdf.close();
  }

  // 处理pdf文件名
  private static String makepdfname(File pdffile, int addnum) {
    String sourcename = pdffile.getName();
    String[] name = sourcename.split("_");
    String[] namenum = name[name.length - 1].split("-");
    int index = namenum[1].indexOf(".");
    String numnum = namenum[1].substring(0, index);
    int num = Integer.parseInt(numnum);
//    String desname = sourcename.replace(name[4], namenum[0] + "-" + String.valueOf(num + addnum) + ".pdf");
    String desname = sourcename.replace(name[4], namenum[0] + "-" + String.format("%04d", num + addnum) + ".pdf");
    return desname;
  }

}
