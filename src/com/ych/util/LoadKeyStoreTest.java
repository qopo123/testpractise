package com.ych.util;

import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;

/**
 * Created by Administrator on 2017/5/13.
 */
public class LoadKeyStoreTest {

  public static void main(String[] args) {
    try {
      KeyStore keyStore = KeyStore.getInstance("PKCS12");
      FileInputStream finput = new FileInputStream("outout.p12");
      keyStore.load(finput, KeyStoreTest.KEY_PASSWORD);
      Key pvsKey = keyStore.getKey(KeyStoreTest.ALIAS, KeyStoreTest.KEY_PASSWORD);
      Certificate certificate = keyStore.getCertificate(KeyStoreTest.ALIAS);
      Certificate[] chain = keyStore.getCertificateChain(KeyStoreTest.ALIAS);
      for(Certificate cert : chain){
        System.out.println(cert);
      }
      System.out.println(certificate);
      System.out.println(pvsKey.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
