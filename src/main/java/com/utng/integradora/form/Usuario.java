package com.utng.integradora.form;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 4377648509352540715L;

	@Email(message="Formato de correo no valido")
	@Size(min = 1, max = 254, message="Rango permitido de 1 a 254 caracteres")	
	private String correo;
	
	@Size(min = 5, max = 15, message="Rango permitido de 5 a 15 caracteres")
	private String password;

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [correo=" + correo + ", password=" + password + "]";
	}
	
	
	
}
