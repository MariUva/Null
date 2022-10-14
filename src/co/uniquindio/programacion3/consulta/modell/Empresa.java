package co.uniquindio.programacion3.consulta.modell;

import java.util.ArrayList;

public class Empresa {

	// Atributos de la clase
	private String nombre;

	ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
	ArrayList<Producto> listaProductos = new ArrayList<Producto>();

	// Metodo constructor
	public Empresa(String nombre, ArrayList<Empleado> listaEmpleados, ArrayList<Producto> listaProductos) {
		super();
		this.nombre = nombre;
		this.listaEmpleados = listaEmpleados;
		this.listaProductos = listaProductos;
	}

	// Metodo constructor vacio
	public Empresa() {
		super();
	}

	// Metodo toString
	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", listaEmpleados=" + listaEmpleados + ", listaProductos=" + listaProductos
				+ "]";
	}

	// Metodos getters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

}
