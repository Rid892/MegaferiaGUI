package model;

public record Response<T>(T data, String message, StatusCode status) {}