package model;

public enum StatusCode {
    SUCCESS(200, "Operación exitosa"),
    BAD_REQUEST(400, "Datos inválidos o incompletos"),
    CONFLICT(409, "Ya existe (duplicado)"),
    NOT_FOUND(404, "No encontrado"),
    INTERNAL_ERROR(500, "Error interno");

    private final int code;
    private final String description;

    StatusCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() { return code; }
    public String getDescription() { return description; }
}