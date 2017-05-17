package com.ych.util;

import sun.security.x509.CertAndKeyGen;
import sun.security.x509.X500Name;

import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.X509Certificate;

/**
 * Created by Administrator on 2017/5/12.
 */
public class KeyStoreTest {
  public static final char[] KEY_PASSWORD = "password".toCharArray();

  public static final String ALIAS = "root_alias";
  public static void main(String[] args) {
    try{
      KeyStore keyStore = KeyStore.getInstance("PKCS12");
      keyStore.load(null, null);
      String filePath = "outout.p12";
      FileOutputStream fout = new FileOutputStream(filePath);
      CertAndKeyGen gen = new CertAndKeyGen("RSA","SHA1WithRSA");
      gen.generate(1024);
      X509Certificate cert=gen.getSelfCertificate(new X500Name("CN=ROOT"), (long)365*24*3600);
      Key key = gen.getPrivateKey();
      X509Certificate[] chain = new X509Certificate[1];
      chain[0] = cert;
      keyStore.setKeyEntry(ALIAS, key, KEY_PASSWORD, chain);
      keyStore.store(fout, "password".toCharArray());
      fout.close();
    } catch (Exception ex){
      ex.printStackTrace();
    }
  }
}
