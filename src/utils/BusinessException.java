package utils;

public class BusinessException extends Exception {
    private final StatusCode code;

    public BusinessException(StatusCode code, String message) {
        super(message);
        this.code = code;
    }

    public StatusCode getCode() { return code; }
}