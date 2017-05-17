package com.ych.util;

/**
 * Created by yangchuanhua on 2017/5/12.
 * 签名配置文件生成类
 */
public class SignConfigGenerate {

//  Logger logger = LoggerFactory.getLogger(SignConfigGenerate.class);
//  private static final int VALIDITY_PERIOD = 7 * 24 * 60 * 60 * 1000; // one week
//  public static final String ROOT_ALIAS = "root_alias";
//  public static final char[] KEY_PASSWD = "passWord".toCharArray();
//  static {
//    Security.addProvider(new BouncyCastleProvider());
//  }
//  @Async
//  public String generateKeyStoreFile() throws IOException {
//    String fileId = null;
//    ByteArrayOutputStream outputStream = null;
//    try {
//
//      KeyStore keyStore = getKeyStore();
//
//      X500PrivateCredential credential = createCredential();
//
//      keyStore.setCertificateEntry(credential.getAlias(), credential.getCertificate());
//      keyStore.setKeyEntry(credential.getAlias(), credential.getPrivateKey(), KEY_PASSWD,
//          new Certificate[]{credential.getCertificate()});
//      outputStream = new ByteArrayOutputStream();
//      keyStore.store(outputStream, KEY_PASSWD);
//      fileId = FdfsPoolClient.getInstance().upload(outputStream.toByteArray(), ".p12");
//    } catch (Exception e) {
//      e.printStackTrace();
//    }finally {
//      if(outputStream != null){
//        outputStream.close();
//      }
//    }
//    return fileId;
//
//  }
//
//  private final KeyStore getKeyStore() {
//    KeyStore keyStore = null;
//    try {
//      keyStore = KeyStore.getInstance("PKCS12");
//      keyStore.load(null, null);
//    } catch (KeyStoreException e) {
////      logger.error("获取keystore");
//      e.printStackTrace();
//    } catch (CertificateException e) {
//      e.printStackTrace();
//    } catch (NoSuchAlgorithmException e) {
//      e.printStackTrace();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    return keyStore;
//  }
//
//  public X500PrivateCredential createCredential() throws Exception {
//
//    KeyPair keyPair = generateRSAKeyPair();
//    X509Certificate interCert = buildCert(keyPair);
//
//    return new X500PrivateCredential(interCert, keyPair.getPrivate(), ROOT_ALIAS);
//  }
//
//  public KeyPair generateRSAKeyPair() throws Exception {
//    KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA", "BC");
//
//    kpGen.initialize(2048, new SecureRandom());
//
//    return kpGen.generateKeyPair();
//  }
//
//  public X509Certificate buildCert(KeyPair keyPair) throws Exception {
//    X509v1CertificateBuilder certBldr = new JcaX509v1CertificateBuilder(
//        new X500Name("CN=某公司"),
//        BigInteger.valueOf(1),
//        new Date(System.currentTimeMillis()),
//        new Date(System.currentTimeMillis() + VALIDITY_PERIOD),
//        new X500Name("CN=某机构"),
//        keyPair.getPublic());
//
//    ContentSigner signer = new JcaContentSignerBuilder("SHA1withRSA").setProvider("BC").build(keyPair.getPrivate());
//
//    return new JcaX509CertificateConverter().setProvider("BC").getCertificate(certBldr.build(signer));
//  }
}
