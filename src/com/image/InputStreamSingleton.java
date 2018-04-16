package com.image;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;

/**
 * Created by yangchuanhua on 2017/6/29.
 */
public class InputStreamSingleton {

  private volatile static ByteArrayInputStream inputstream = null;

  private InputStreamSingleton(){

  }

  public static ByteArrayInputStream getSingleton() throws Exception {
    if (inputstream == null) {
      synchronized (InputStreamSingleton.class) {
        if (inputstream == null) {
          String svgUrl = System.getProperty("user.dir") + File.separator + "svg.svg";
          File file = new File(svgUrl);
          String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
          DOMImplementation impl = SVGDOMImplementation.getDOMImplementation();
          Document document = impl.createDocument(svgNS, "svg", null);
          Element svgRoot = document.getDocumentElement();
          svgRoot.setAttributeNS(null, "width", "458");
          svgRoot.setAttributeNS(null, "height", "168");
          Element element = document.createElementNS(svgNS, "rect");
          element.setAttributeNS(null, "x", "4");
          element.setAttributeNS(null, "y", "4");
          element.setAttributeNS(null, "width", "450");
          element.setAttributeNS(null, "height", "160");
          element.setAttributeNS(null, "style",  "stroke:#FF0000;stroke-width:8;fill: none;");
          Element line = document.createElementNS(svgNS, "line");
          line.setAttributeNS(null, "x1", "4");
          line.setAttributeNS(null, "y1", "84");
          line.setAttributeNS(null, "x2", "454");
          line.setAttributeNS(null, "y2", "84");
          line.setAttributeNS(null, "style", "stroke:#FF0000;stroke-width:8");
          Element line1 = document.createElementNS(svgNS, "line");
          line1.setAttributeNS(null, "x1", "154");
          line1.setAttributeNS(null, "y1", "4");
          line1.setAttributeNS(null, "x2", "154");
          line1.setAttributeNS(null, "y2", "164");
          line1.setAttributeNS(null, "style", "stroke:#FF0000;stroke-width:8");
          Element line2 = document.createElementNS(svgNS, "line");
          line2.setAttributeNS(null, "x1", "304");
          line2.setAttributeNS(null, "y1", "4");
          line2.setAttributeNS(null, "x2", "304");
          line2.setAttributeNS(null, "y2", "164");
          line2.setAttributeNS(null, "style", "stroke:#FF0000;stroke-width:8");
          svgRoot.appendChild(element);
          svgRoot.appendChild(line);
          svgRoot.appendChild(line1);
          svgRoot.appendChild(line2);
          TransformerFactory transformerFactory = TransformerFactory.newInstance();
          Transformer transformer = transformerFactory.newTransformer();
          DOMSource source = new DOMSource(document);
          StreamResult streamResult =  new StreamResult(file);
          transformer.transform(source, streamResult);
          inputstream = new ByteArrayInputStream(Files.readAllBytes(file.toPath()));
        }
      }
    }
    return inputstream;
  }

}
