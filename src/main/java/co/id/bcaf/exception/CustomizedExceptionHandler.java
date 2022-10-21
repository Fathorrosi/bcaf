package co.id.bcaf.exception;

import co.id.bcaf.constant.StatusCode;
import co.id.bcaf.dto.GlobalResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
@RestController
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {


  public String handleErrorDesc(String statusCode, String message) {
    String errorDesc = message == null ? StatusCode.getDescByCode(statusCode)
            : message;

    return errorDesc;
  }

  @ExceptionHandler(DataNotFoundException.class)
  public ResponseEntity<GlobalResponseEntity> handleNotFoundException(
    DataNotFoundException ex,
    WebRequest request
  ) {
    String errorDesc = handleErrorDesc(ex.getStatusCode(), ex.getMessage());
    return GlobalResponseEntity.error(
      ex.getStatusCode(),
      errorDesc,
      "",
      HttpStatus.NOT_FOUND
    );
  }

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<GlobalResponseEntity> badRequestException(
          BadRequestException ex,
          WebRequest request
  ) {
    String errorDesc = handleErrorDesc(ex.getStatusCode(), ex.getMessage());
    return GlobalResponseEntity.error(
            ex.getStatusCode(),
            errorDesc,
            "",
            HttpStatus.BAD_REQUEST
    );
  }

}
