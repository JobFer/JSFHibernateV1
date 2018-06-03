package com.mitocode.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.mitocode.dao.EmpleadoDAO;
import com.mitocode.model.Empleado;

@ManagedBean
@SessionScoped
public class EmpleadoBean {

	private Empleado empleado = new Empleado();
	private EmpleadoDAO empleadoDAO = new EmpleadoDAO();
	private List<Empleado> lstEmpleados;

//	Esto para que se vea el listado de empleados sin tener que pinchar en "listar"
	public EmpleadoBean() throws Exception {
		this.lstEmpleados = empleadoDAO.Listar();
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Empleado> getLstEmpleados() {
		return lstEmpleados;
	}

	public void setLstEmpleados(List<Empleado> lstEmpleados) {
		this.lstEmpleados = lstEmpleados;
	}

	public void registrar() { //throws Exception {
		try {
			System.out.println("empleadoDAO: " + empleadoDAO);
			System.out.println("this.empleado.getNombres(): " + this.empleado.getNombres());
			
			empleadoDAO.Registrar(this.empleado);
			// Incluyo estas 2 líneas, para que refresque el listado y borre el
			// formulario.
			this.listar();
			this.empleado = new Empleado();
		} catch (Exception e) {
			System.err.println("EXCEPCIÓN EN REGISTRAR: " + e.getMessage());
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se ha podido registrar", "...detalles...");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void eliminar(Empleado emp) throws Exception {
		try {
			empleadoDAO.Eliminar(emp);
			this.listar();
		} catch (Exception e) {
			System.err.println("EXCEPCIÓN EN ELIMINAR: " + e.getMessage());
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se ha podido eliminar", "...detalles...");
	        FacesContext.getCurrentInstance().addMessage(null, msg);			
		}
	}

	public String leer(Empleado emp) {
		this.empleado = emp;
		return "editar";
	}

	/*
	 * Luego de cargar los datos del objeto con el metodo leer, puedo modificar
	 * con nuevos datos
	 */
	public String modificar() throws Exception {
		try {
			empleadoDAO.Modificar(this.empleado);
			this.empleado = new Empleado();
		} catch (Exception e) {
			System.err.println("EXCEPCIÓN EN MODIFICAR: " + e.getMessage());
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se ha podido modificar", "...detalles...");
	        FacesContext.getCurrentInstance().addMessage(null, msg);			
		}
		return "exito";
	}

	public String cancelar() throws Exception {
		System.out.println("Cancelar");
		this.empleado = new Empleado();
		return "exito";
	}
	
	public void listar() throws Exception {
		this.lstEmpleados = empleadoDAO.Listar();
	}

}
