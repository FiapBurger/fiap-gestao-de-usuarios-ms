package com.fiap.gestaoUsuarios.core.domains.exception;

public enum ExceptionsMessageEnum {
	
	USUARIO_NAO_ENCONTRADO("Usuário não encontrado!");
	
	private String value;
	
	private ExceptionsMessageEnum(String value) {
		this.value = value;
	}
	
	public String value() {
		return this.value;
	}

}
