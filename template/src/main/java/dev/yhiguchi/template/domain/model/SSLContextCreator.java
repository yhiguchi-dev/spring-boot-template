package dev.yhiguchi.template.domain.model;

import java.io.*;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;

/** SSLContext 作成者 */
public class SSLContextCreator {

  ClientCertificate clientCertificate;
  PrivateKey privateKey;

  public SSLContextCreator(ClientCertificate clientCertificate, PrivateKey privateKey) {
    this.clientCertificate = clientCertificate;
    this.privateKey = privateKey;
  }

  SSLContext create(String keystorePassword) {
    try {
      KeyStore keyStore = KeyStore.getInstance("jks");
      keyStore.load(null, null);

      Certificate[] certificates = clientCertificate.getCertificates();
      Key key = privateKey.getKey();

      keyStore.setKeyEntry("test", key, keystorePassword.toCharArray(), certificates);
      KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
      keyManagerFactory.init(keyStore, keystorePassword.toCharArray());

      SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
      sslContext.init(keyManagerFactory.getKeyManagers(), null, null);
      return sslContext;
    } catch (KeyStoreException
        | NoSuchAlgorithmException
        | KeyManagementException
        | UnrecoverableKeyException
        | CertificateException
        | IOException e) {
      throw new SSLContextCreationException("Fail to create SSLContext", e);
    }
  }
}
