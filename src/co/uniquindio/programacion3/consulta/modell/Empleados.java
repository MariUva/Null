package co.uniquindio.programacion3.consulta.modell;

import java.util.ArrayList;

public class Empleados {

	private String nombre;
	private String codigo;
	private double sueldo;

	private ArrayList<Empleados> empleados;

	@Override
	public String toString() {
		return "Empleados [nombre=" + nombre + ", codigo=" + codigo + ", sueldo=" + sueldo + "]";
	}

	// Metodos getters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public ArrayList<Empleados> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleados> empleados) {
		this.empleados = empleados;
	}

	public ArrayList<Empleados> getListaEmpleados() {
		// TODO Auto-generated method stub
		return null;
	}

}
