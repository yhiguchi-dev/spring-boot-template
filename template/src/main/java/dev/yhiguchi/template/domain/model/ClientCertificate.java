package dev.yhiguchi.template.domain.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Collection;

/** クライアント証明書 */
public class ClientCertificate {
  String value;

  public ClientCertificate(String value) {
    this.value = value;
  }

  Certificate[] getCertificates() {
    try (InputStream inputStream =
        new ByteArrayInputStream(value.getBytes(StandardCharsets.UTF_8))) {
      CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
      Collection<? extends Certificate> certificates =
          certificateFactory.generateCertificates(inputStream);
      return certificates.toArray(new Certificate[0]);
    } catch (IOException | CertificateException e) {
      throw new RuntimeException(e);
    }
  }
}
