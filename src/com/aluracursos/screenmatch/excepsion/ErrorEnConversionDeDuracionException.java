package com.aluracursos.screenmatch.excepsion;

public class ErrorEnConversionDeDuracionException extends RuntimeException {
    private String mansaje;
    public ErrorEnConversionDeDuracionException(String mensaje) {
        this.mansaje = mensaje;
    }

    public String getMansaje() {
        return this.mansaje;
    }
}
