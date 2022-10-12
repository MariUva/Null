package co.uniquindio.programacion3.consulta.modell;


import java.util.ArrayList;

public class Productos {

	private String nombre;
	private String codigo;
	private double precio;

	private ArrayList<Productos> productos;

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

	public ArrayList<Productos> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Productos> productos) {
		this.productos = productos;
	}

}
