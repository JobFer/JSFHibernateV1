package com.mitocode.model;

public class Empleado implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int codEmpleado;
	private String nombres;
	private String apellidos;
	private char sexo;
//	private Usuario usuario;

	public Empleado() {
	}

	public Empleado(Usuario usuario, String nombres, String apellidos, char sexo) {
//		this.usuario = usuario;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.sexo = sexo;
	}

	public int getCodEmpleado() {
		return this.codEmpleado;
	}

	public void setCodEmpleado(int codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public char getSexo() {
		return this.sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}

}
