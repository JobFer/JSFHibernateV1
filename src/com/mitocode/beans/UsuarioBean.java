package com.mitocode.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.codec.digest.DigestUtils;

import com.mitocode.dao.UsuarioDAO;
import com.mitocode.dao.auto.UsuarioHome;
import com.mitocode.model.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String verificarDatos() throws Exception{
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario us;
		String resultado;

		try {
			// Enviando la encriptacion
//			String encript = DigestUtils.md5Hex(this.usuario.getNombre());
			String encript = DigestUtils.sha1Hex(this.usuario.getClave());
			this.usuario.setClave(encript);

			us = usuDAO.verificarDatos(this.usuario);
			if (us != null) {

				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
//				resultado = "exito"; 
				resultado = "exito?faces-redirect=true";
				
			} else {
				resultado = "error";
			}
		} catch (Exception e) {
			throw e;
		}
		return resultado;
	}
	
	public boolean verificarSesion() {
		boolean estado;

		if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario") == null) {
			estado = false;
		} else {
			estado = true;
		}
		return estado;
	}

	public String cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index?faces-redirect=true"; //Con esto muestra la url a donde va
//		return "index";
	}
	
//	public boolean per() {
//		UsuarioHome u = new UsuarioHome();
//		u.persist(new Usuario(3,"aa","bb"));
//		return true;
//	}
	
}
