package dev.yhiguchi.template.domain.model;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

/** 秘密鍵 */
public class PrivateKey {
  String value;

  public PrivateKey(String value) {
    this.value = value;
  }

  public Key getKey() {
    try {
      PKCS8EncodedKeySpec pkcs8EncodedKeySpec =
          new PKCS8EncodedKeySpec(value.getBytes(StandardCharsets.UTF_8));
      return KeyFactory.getInstance("RSA").generatePrivate(pkcs8EncodedKeySpec);
    } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }
}
