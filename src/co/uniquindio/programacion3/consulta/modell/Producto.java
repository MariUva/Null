package co.uniquindio.programacion3.consulta.modell;

import java.util.ArrayList;

public class Producto {

	private String nombre;
	private String codigo;
	private double precio;

	private ArrayList<Producto> productos;

	// Metodo constructor
	public Producto(String nombre, String codigo, double precio, ArrayList<Producto> productos) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.productos = productos;
	}

	// Metodo constructor vacio
	public Producto() {
		super();
	}

	// Metodo toString
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", codigo=" + codigo + ", precio=" + precio + "]";
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

}
