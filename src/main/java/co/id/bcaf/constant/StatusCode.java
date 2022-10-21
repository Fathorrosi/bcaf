package co.id.bcaf.constant;

import java.util.Objects;

public enum StatusCode {
    SUCCESS("00", "Success"),
    BAD_REQUEST("01", "Bad Request"),

    NOT_FOUND("02", "Data Not Found");

    private final String code;
    private final String description;

    private StatusCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String findDescByCode(String code) {
        return StatusCode.valueOf(code).getDescription();
    }

    public static String getDescByCode(String code) {
        for (var response : StatusCode.values()) {
            if (Objects.equals(response.code, code)) {
                return response.getDescription();
            }
        }

        throw new IllegalArgumentException("Unsupported Status code: " + code);
    }
}
