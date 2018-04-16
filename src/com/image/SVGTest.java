package com.image;

import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.ByteArrayOutputStream;

/**
 * Created by yangchuanhua on 2017/6/28.
 */
public class SVGTest {
  public static void main(String[] args) throws Exception{
    convertToPNG();
  }

  public static void convertToPNG() throws Exception {
    PNGTranscoder pngTranscoder = new PNGTranscoder();
    TranscoderInput input = new TranscoderInput(createDocument());
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    TranscoderOutput output = new TranscoderOutput(outputStream);
    pngTranscoder.transcode(input, output);
    outputStream.toByteArray();
    outputStream.flush();
    outputStream.close();
  }

  public static Document createDocument() throws Exception{
    String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
    String parser = XMLResourceDescriptor.getXMLParserClassName();
    SAXSVGDocumentFactory factory = new SAXSVGDocumentFactory(parser);
    Document doc = factory.createDocument(null, InputStreamSingleton.getSingleton());
    Element text = doc.createElementNS(svgNS, "text");
    text.setAttributeNS(null, "x", "75");
    text.setAttributeNS(null, "y", "55");
    text.setAttributeNS(null, "style", "font-family: 宋体; font-size : 30; fill : #FF0000;text-anchor: middle");
    text.setTextContent("你好");
    Element text2 = doc.createElementNS(svgNS, "text");
    text2.setAttributeNS(null, "x", "225");
    text2.setAttributeNS(null, "y", "55");
    text2.setAttributeNS(null, "style", "font-family: 宋体; font-size : 30; fill : #FF0000;text-anchor: middle");
    text2.setTextContent("你好");
    Element text3 = doc.createElementNS(svgNS, "text");
    text3.setAttributeNS(null, "x", "375");
    text3.setAttributeNS(null, "y", "55");
    text3.setAttributeNS(null, "style", "font-family: 宋体; font-size : 30; fill : #FF0000;text-anchor: middle");
    text3.setTextContent("你好");
    Element text4 = doc.createElementNS(svgNS, "text");
    text4.setAttributeNS(null, "x", "75");
    text4.setAttributeNS(null, "y", "135");
    text4.setAttributeNS(null, "style", "font-family: 宋体; font-size : 30; fill : #FF0000;text-anchor: middle");
    text4.setTextContent("你好");
    Element text5 = doc.createElementNS(svgNS, "text");
    text5.setAttributeNS(null, "x", "225");
    text5.setAttributeNS(null, "y", "135");
    text5.setAttributeNS(null, "style", "font-family: 宋体; font-size : 30; fill : #FF0000;text-anchor: middle");
    text5.setTextContent("你好");
    Element text6 = doc.createElementNS(svgNS, "text");
    text6.setAttributeNS(null, "x", "375");
    text6.setAttributeNS(null, "y", "135");
    text6.setAttributeNS(null, "style", "font-family: 宋体; font-size : 30; fill : #FF0000;text-anchor: middle");
    text6.setTextContent("你好");
    Element svgRoot = doc.getDocumentElement();
    svgRoot.appendChild(text);
    svgRoot.appendChild(text2);
    svgRoot.appendChild(text3);
    svgRoot.appendChild(text4);
    svgRoot.appendChild(text5);
    svgRoot.appendChild(text6);
    return doc;
  }

}


