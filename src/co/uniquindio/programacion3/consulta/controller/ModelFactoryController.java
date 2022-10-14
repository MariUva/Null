package co.uniquindio.programacion3.consulta.controller;

import java.io.IOException;
import java.util.ArrayList;

import co.uniquindio.programacion3.consulta.modell.Empleado;
import co.uniquindio.programacion3.consulta.modell.Empresa;
import co.uniquindio.programacion3.consulta.modell.Producto;
import co.uniquindio.programacion3.consulta.persistence.Persistencia;

public class ModelFactoryController {

	Empresa empresa;

	// ------------------------------ Singleton
	// ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aquí al ser
		// protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// Método para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	ArrayList<Producto> listaProductos = new ArrayList<>();
	ArrayList<Empleado> listaEmpleados = new ArrayList<>();

	public ModelFactoryController() {

		// 1. inicializar datos y luego guardarlo en archivos
		// iniciarSalvarDatosPrueba();

		// 2. Cargar los datos de los archivos
		// cargarDatosDesdeArchivos();

		// 3. Guardar y Cargar el recurso serializable binario
		// guardarResourceBinario();
		// cargarResourceBinario();

		// 4. Guardar y Cargar el recurso serializable XML
		// guardarResourceXML();

		// Siempre se debe verificar si la raiz del recurso es null
		if (empresa == null) {
			System.out.println("es null");
			inicializarDatos();
			// guardarResourceSerializable();
		}

	}

	private void inicializarDatos() {

		empresa = new Empresa();

		Empleado empleado = new Empleado();
		empleado.setNombre("Alicia");
		empleado.setCodigo("12345");
		empleado.setSueldo(350000.0);

		empresa.getListaEmpleados().add(empleado);
		getListaEmpleados().add(empleado);

		Empleado empleado1 = new Empleado();
		empleado1.setNombre("Carlos");
		empleado1.setCodigo("678910");
		empleado1.setSueldo(5000000);

		empresa.getListaEmpleados().add(empleado1);
		getListaEmpleados().add(empleado1);

		Empleado empleado2 = new Empleado();
		empleado2.setNombre("Pedro");
		empleado2.setCodigo("101112");
		empleado2.setSueldo(1600000);
		empresa.getListaEmpleados().add(empleado2);
		getListaEmpleados().add(empleado2);

		Producto producto = new Producto();
		producto.setNombre("Lampara");
		producto.setCodigo("323435");
		producto.setPrecio(16.500);
		empresa.getListaProductos().add(producto);
		getListaProductos().add(producto);

		Producto producto2 = new Producto();
		producto2.setNombre("Bolso");
		producto2.setCodigo("3344442");
		producto2.setPrecio(100.0000);
		empresa.getListaProductos().add(producto2);
		getListaProductos().add(producto2);

		try {
			Persistencia.guardarEmpleados(empresa.getListaEmpleados());
			Persistencia.guardarProductos(empresa.getListaProductos());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// --------------- GETTERS AND SETTERS---------------

	public Empresa getEmpresa() {
		return empresa;
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	// ---------------------PRODUCTO---------------------------------

	public Producto agregarProducto(String nombre, String codigo, double precio) {
		if (existeProducto(codigo)) {
			return null;
		} else {
			Producto nuevoProducto = new Producto();
			nuevoProducto.setNombre(nombre);
			nuevoProducto.setCodigo(codigo);
			nuevoProducto.setPrecio(precio);
			getListaProductos().add(nuevoProducto);
			return nuevoProducto;
		}
	}

	private boolean existeProducto(String codigo) {

		boolean existe = false;
		for (Producto productos : listaProductos) {
			if (productos.getCodigo().equals(codigo)) {
				existe = true;
				return existe;
			}

		}
		return existe;

	}

	public Boolean eliminarProducto(String codigo) {
		Boolean flagEliminado = false;
		Producto productos = obtenerProducto(codigo);

		if (productos != null) {
			getListaProductos().remove(productos);
			flagEliminado = true;
		}
		return flagEliminado;
	}

	public Producto obtenerProducto(String codigoProducto) {

		Producto productoEncontrado = null;

		for (Producto productos : listaProductos) {
			if (productos.getCodigo().equals(codigoProducto)) {
				productoEncontrado = productos;
				break;

			}
		}
		return productoEncontrado;

	}

	// ---------------------EMPLEADOS---------------------------------

	public Empleado agregarEmpleado(String nombre, String codigo, double sueldo) {
		if (existeEmpleado(codigo)) {
			return null;
		} else {
			Empleado nuevoEmpleado = new Empleado();
			nuevoEmpleado.setNombre(nombre);
			nuevoEmpleado.setCodigo(codigo);
			nuevoEmpleado.setSueldo(sueldo);
			getListaEmpleados().add(nuevoEmpleado);
			return nuevoEmpleado;
		}
	}

	private boolean existeEmpleado(String codigo) {

		boolean existe = false;
		for (Empleado empleados : listaEmpleados) {
			if (empleados.getCodigo().equals(codigo)) {
				existe = true;
				return existe;
			}

		}
		return existe;

	}

	public Boolean eliminarEmpleado(String codigo) {

		Boolean flagEliminado = false;
		Empleado empleados = obtenerEmpleado(codigo);

		if (empleados != null) {
			getListaEmpleados().remove(empleados);
			flagEliminado = true;
		}
		return flagEliminado;
	}

	public Empleado obtenerEmpleado(String codigoEmpleado) {

		Empleado empleadoEncontrado = null;

		for (Empleado empleados : listaEmpleados) {
			if (empleados.getCodigo().equals(codigoEmpleado)) {
				empleadoEncontrado = empleados;
				break;

			}
		}
		return empleadoEncontrado;

	}


}