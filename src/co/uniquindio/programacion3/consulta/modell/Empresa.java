package co.uniquindio.programacion3.consulta.modell;

import java.util.ArrayList;

public class Empresa {

	private String nombre;

	ArrayList<Empleados> listaEmpleados = new ArrayList<Empleados>();
	ArrayList<Productos> listaProductos = new ArrayList<Productos>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Empleados> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(ArrayList<Empleados> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public ArrayList<Productos> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Productos> listaProductos) {
		this.listaProductos = listaProductos;
	}

	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", listaEmpleados=" + listaEmpleados + ", listaProductos=" + listaProductos
				+ "]";
	}

	public Empresa(String nombre, ArrayList<Empleados> listaEmpleados, ArrayList<Productos> listaProductos) {
		super();
		this.nombre = nombre;
		this.listaEmpleados = listaEmpleados;
		this.listaProductos = listaProductos;
	}

	public Empresa() {
		super();
	}

}
