package com.ych.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Administrator on 2017/5/10.
 */
public class DrawImageUtil {
  private static final int canvasWidth = 3 * 15 * 10;
  private static final int canvasHeight = 2 * 8 * 10;
  private static final float BASICSTROKEWIDTH = 8; // 画笔的粗度

  public static void drawImage(){
    BufferedImage bi = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = bi.createGraphics();
    // 增加下面代码使得背景透明
    bi = g2d.getDeviceConfiguration().createCompatibleImage(canvasWidth, canvasHeight,
        Transparency.TRANSLUCENT);
    g2d.dispose();
    g2d = bi.createGraphics();
    // 背景透明代码结束
    g2d.setColor(new Color(255, 0, 0));
    g2d.setStroke(new BasicStroke(BASICSTROKEWIDTH));// 设置画笔的粗度
    //不先画大的矩形
//    Shape rectangle = new Rectangle2D.Double(0, 0, canvasWidth, canvasHeight);
//    g2d.draw(rectangle);
    double coordinateX = 0;
    double coordinateY = 0;
    double shapeWidth = canvasWidth / 3;
    double shapeHeight = canvasHeight / 2;
    Shape rectangle = new Rectangle2D.Double(coordinateX, coordinateY, shapeWidth, shapeHeight);
    g2d.draw(rectangle);
//    int fontSize = 8;
//    Font f = new Font("宋体", Font.BOLD, fontSize);
//    g2d.setFont(f);
//    g2d.drawString("C", 0, 8);
    coordinateX = coordinateX + shapeWidth;
    rectangle = new Rectangle2D.Double(coordinateX, coordinateY, shapeWidth, shapeHeight);
    g2d.draw(rectangle);
    coordinateX = coordinateX + shapeWidth;
    rectangle = new Rectangle2D.Double(coordinateX, coordinateY, shapeWidth, shapeHeight);
    g2d.draw(rectangle);
    coordinateX = 0;
    coordinateY = 80;
    rectangle = new Rectangle2D.Double(coordinateX, coordinateY, shapeWidth, shapeHeight);
    g2d.draw(rectangle);
    coordinateX = shapeWidth + coordinateX;
    rectangle = new Rectangle2D.Double(coordinateX, coordinateY, shapeWidth, shapeHeight);
    g2d.draw(rectangle);
    coordinateX = shapeWidth + coordinateX;
    rectangle = new Rectangle2D.Double(coordinateX, coordinateY, shapeWidth, shapeHeight);
    g2d.draw(rectangle);
//    g2d.setStroke(new BasicStroke(2));
//    g2d.drawLine(canvasWidth, 0, canvasWidth, canvasHeight);
//    g2d.drawLine(0, canvasHeight, canvasWidth, canvasHeight);
    // g2d.drawLine(10, canvasHeight / 2, canvasWidth - 10, canvasHeight /
    // 2);//

//    int fontSize = 11;
//    Font f = new Font("宋体", Font.PLAIN, fontSize);
//    g2d.setFont(f);
//    g2d.drawString("666", 0, 15);
    // g2d.setPaint(Color.GRAY);
    // g2d.drawLine(40, (canvasHeight / 2) - 30, canvasWidth - 40,
    // (canvasHeight / 2) - 30);
    // g2d.drawLine(40, (canvasHeight / 2) - 30, 40, (canvasHeight / 2) -
    // 5);
    // g2d.drawLine(40, (canvasHeight / 2) - 5, canvasWidth - 40,
    // (canvasHeight / 2) - 5);
    // g2d.drawLine(canvasWidth - 40, (canvasHeight / 2) - 30, canvasWidth -
    // 40, (canvasHeight / 2) - 5);
    // g2d.setPaint(Color.red);
    /**
     // 把content分成两行，第一行8个字符，第二行放剩余的全部
     if (content.length() <= 8) {
     g2d.drawString(content, 142, (canvasHeight / 2) - 12);
     } else {
     g2d.drawString(content.substring(0, 8), 142, (canvasHeight / 2) - 12);
     g2d.drawString(content.substring(8, content.length()), 0, (canvasHeight / 2) + 2);
     }*/
    g2d.dispose();// 销毁资源
    StringBuffer stringBuffer = new StringBuffer(System.getProperty("user.dir"));
    stringBuffer.append(File.separator);
    stringBuffer.append("seal.png");
    try {
      ImageIO.write(bi, "PNG", new File(stringBuffer.toString()));
    } catch (Exception e) {
    }
  }

  public static void main(String[] args) {
    drawImage();
  }
}
