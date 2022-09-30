package dev.yhiguchi.template.domain.model;

/** SSLContext作成例外 */
public class SSLContextCreationException extends RuntimeException {
  public SSLContextCreationException(String message, Throwable cause) {
    super(message, cause);
  }
}
