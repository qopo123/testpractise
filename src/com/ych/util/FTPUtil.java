
package com.ych.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;

/**
 * Created by yangchuanhua on 2017/5/23.
 */
public final class FTPUtil {

  public static void downFile(FTPConfig config){
    FTPClient ftpClient = new FTPClient();
    try {
      ftpClient.connect(config.getAddress(), config.getPort());
      ftpClient.login(config.getUserName(), config.getPassWord());
      FTPFile[] ftpDirs = ftpClient.listDirectories();
//      String remotePathName = "nihao" + "/" + "nihao";
//      boolean isChanged = ftpClient.changeWorkingDirectory(remotePathName);
      boolean isChanged = ftpClient.changeWorkingDirectory( "DEMO001" + "/" + "201702");
      System.out.println(isChanged);
//      FTPFile[] ftpFiles = ftpClient.listFiles();
//      if(!isChanged){
//        System.out.println("没有切换成功");
//      }
//
//      if(ftpFiles != null && ftpFiles.length > 0){
//        for(FTPFile fp : ftpFiles){
//          System.out.println(fp.getName());
//        }
//      }
//      if(ftpDirs != null && ftpDirs.length > 0){
//        for(FTPFile fp : ftpDirs){
//          System.out.println(fp.getName());
//        }
//      }
//      OutputStream outputStream = null;
//      if(ftpFiles != null && ftpFiles.length > 0){
//        String pathName = "/home/cloudrecord/scan" + "/1" + "/2" + File.separator;
//        File file = new File(pathName);
//        if(!file.exists()){
//          file.mkdirs();
//        }
//        for(FTPFile ftpFile : ftpFiles){
////          String fileName = pathName + ftpFile.getName();
////          File files = new File(fileName);
////          outputStream = new FileOutputStream(files);
////          ftpClient.retrieveFile(ftpFile.getName(), outputStream);
////          outputStream.close();
//          boolean success = ftpClient.deleteFile(ftpFile.getName());
//          System.out.println(success);
//        }
//      }
      ftpClient.logout();
      ftpClient.disconnect();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    FTPConfig config = new FTPConfig("vsftpd", "Edoc123", "192.168.52.80");
    downFile(config);
  }
}

class FTPConfig{
  private String userName;

  private String passWord;

  private String address;

  private int port = 21;

  public FTPConfig(String userName, String passWord, String address) {
    this.userName = userName;
    this.passWord = passWord;
    this.address = address;
  }

  public FTPConfig(String userName, String passWord, String address, int port) {
    this.userName = userName;
    this.passWord = passWord;
    this.address = address;
    this.port = port;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassWord() {
    return passWord;
  }

  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }
}
