package co.uniquindio.programacion3.consulta.modell;

import java.util.ArrayList;

public class Empleado {

	//Atributos de la clase
	private String nombre;
	private String codigo;
	private double sueldo;

	private ArrayList<Empleado> empleados;

	// Metodo constructor
	public Empleado(String nombre, String codigo, double sueldo, ArrayList<Empleado> empleados) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.sueldo = sueldo;
		this.empleados = empleados;
	}

	// Metodo contructor vacio
	public Empleado() {
		super();
	}

	// Metodo toString
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

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}

	public ArrayList<Empleado> getListaEmpleados() {
		// TODO Auto-generated method stub
		return null;
	}

}
