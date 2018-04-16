package com.ych.util;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangchuanhua on 2017/5/27.
 */
public class XMLParseTest {
  List<Map<String,String>> parseList = new ArrayList<>();
  public static void main(String[] args) {
    FileInputStream fis = null;
    XMLStreamReader reader = null;
    try {
      File xmlFile = new File("D:\\\\ZZ_yy-0001_201601.xml");
      XMLInputFactory factory = XMLInputFactory.newFactory();
      fis = new FileInputStream(xmlFile);
      reader = factory.createXMLStreamReader(fis);
      while(reader.hasNext()){
        int type = reader.next();
        if(type == XMLStreamReader.START_ELEMENT){
          if(reader.getLocalName().equals("记账凭证")){
            System.out.println(reader.getLocalName());
          }
        }
      }
} catch (Exception e) {
    e.printStackTrace();
    }
  }

  public static void parseEntity(XMLStreamReader reader, List<Map<String,String>> parseList){
    try {
      Map<String, String> map = new HashMap<>();
      while(reader.hasNext()){
        int type = reader.next();
        if(type == XMLStreamReader.END_ELEMENT && reader.getLocalName().equals("记账凭证")){
          break;
        }
        if(type == XMLStreamReader.START_ELEMENT){

        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
