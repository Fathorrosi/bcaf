package co.id.bcaf.dto;

import co.id.bcaf.constant.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public class GlobalResponseEntity {
    private Date timestamp;
    private String statusCode;
    private String statusDescription;
    private Object data;

    public static ResponseEntity<GlobalResponseEntity> ok(Object data) {
        return ResponseEntity.ok(new GlobalResponseEntity(new Date(), StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), data));
    }

    public static ResponseEntity<GlobalResponseEntity> ok(String description) {
        return ResponseEntity.ok(new GlobalResponseEntity(new Date(), StatusCode.SUCCESS.getCode(), description, (Object)null));
    }

    public static ResponseEntity<GlobalResponseEntity> ok(String description, Object data) {
        return ResponseEntity.ok(new GlobalResponseEntity(new Date(), StatusCode.SUCCESS.getCode(), description, data));
    }

    public static ResponseEntity<GlobalResponseEntity> badRequest(String description, Object data) {
        return ResponseEntity.ok(new GlobalResponseEntity(new Date(), StatusCode.BAD_REQUEST.getCode(), description, data));
    }

    public static ResponseEntity<GlobalResponseEntity> error(String statusCode, String description, String data, HttpStatus httpStatus) {
        return new ResponseEntity(new GlobalResponseEntity(new Date(), statusCode, description, data), httpStatus);
    }

    public static ResponseEntity<GlobalResponseEntity> error(String statusCode, String description, Object data, HttpStatus httpStatus) {
        return new ResponseEntity(new GlobalResponseEntity(new Date(), statusCode, description, data), httpStatus);
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public String getStatusDescription() {
        return this.statusDescription;
    }

    public Object getData() {
        return this.data;
    }

    public GlobalResponseEntity(Date timestamp, String statusCode, String statusDescription, Object data) {
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
        this.data = data;
    }

    public GlobalResponseEntity() {
    }
}
