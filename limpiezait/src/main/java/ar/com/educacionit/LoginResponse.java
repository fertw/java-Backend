package ar.com.educacionit;

public record LoginResponse(String token, long expiresInSeconds) {}
