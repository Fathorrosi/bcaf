package co.id.bcaf.exception;

import lombok.Getter;

@Getter
public class DataNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private String statusCode;

  public DataNotFoundException(String statusCode) {
    this.statusCode = statusCode;
  }

  public DataNotFoundException(String message, String statusCode) {
    super(message);
    this.statusCode = statusCode;
  }
}
