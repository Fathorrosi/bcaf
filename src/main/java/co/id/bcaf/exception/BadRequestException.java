package co.id.bcaf.exception;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private String statusCode;

  public BadRequestException(String statusCode) {
    this.statusCode = statusCode;
  }

  public BadRequestException(String message, String statusCode) {
    super(message);
    this.statusCode = statusCode;
  }
}
