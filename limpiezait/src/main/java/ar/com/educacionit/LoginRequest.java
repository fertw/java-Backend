package ar.com.educacionit;

//Esto es un DTO (Data Transfer Object) simple para manejar las solicitudes de login

public record LoginRequest(String username, String password) {}
