package com.evaluation.user.responses;

public class ErrorMessage {
	
	private final String mensaje;

    public ErrorMessage(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

}
