package co.uniquindio.programacion3.consulta.controller;

import java.io.IOException;
import java.util.ArrayList;

import co.uniquindio.programacion3.consulta.modell.Empleados;
import co.uniquindio.programacion3.consulta.modell.Empresa;
import co.uniquindio.programacion3.consulta.modell.Productos;
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

	ArrayList<Productos> listaProductos = new ArrayList<>();
	ArrayList<Empleados> listaEmpleados = new ArrayList<>();

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

		Empleados empleado = new Empleados();
		empleado.setNombre("Alicia");
		empleado.setCodigo("12345");
		empleado.setSueldo(350000.0);

		empresa.getListaEmpleados().add(empleado);
		getListaEmpleados().add(empleado);

		Empleados empleado1 = new Empleados();
		empleado1.setNombre("Carlos");
		empleado1.setCodigo("678910");
		empleado1.setSueldo(5000000);

		empresa.getListaEmpleados().add(empleado1);
		getListaEmpleados().add(empleado1);

		Empleados empleado2 = new Empleados();
		empleado2.setNombre("Pedro");
		empleado2.setCodigo("101112");
		empleado2.setSueldo(1600000);
		empresa.getListaEmpleados().add(empleado2);
		getListaEmpleados().add(empleado2);

		Productos producto = new Productos();
		producto.setNombre("Lampara");
		producto.setCodigo("323435");
		producto.setPrecio(16.500);
		empresa.getListaProductos().add(producto);
		getListaProductos().add(producto);

		Productos producto2 = new Productos();
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

	public ArrayList<Productos> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Productos> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public ArrayList<Empleados> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(ArrayList<Empleados> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	// ---------------------PRODUCTO---------------------------------

	public Productos agregarProducto(String nombre, String codigo, double precio) {
		if (existeProducto(codigo)) {
			return null;
		} else {
			Productos nuevoProducto = new Productos();
			nuevoProducto.setNombre(nombre);
			nuevoProducto.setCodigo(codigo);
			nuevoProducto.setPrecio(precio);
			getListaProductos().add(nuevoProducto);
			return nuevoProducto;
		}
	}

	private boolean existeProducto(String codigo) {

		boolean existe = false;
		for (Productos productos : listaProductos) {
			if (productos.getCodigo().equals(codigo)) {
				existe = true;
				return existe;
			}

		}
		return existe;

	}

	public Boolean eliminarProducto(String codigo) {
		Boolean flagEliminado = false;
		Productos productos = obtenerProducto(codigo);

		if (productos != null) {
			getListaProductos().remove(productos);
			flagEliminado = true;
		}
		return flagEliminado;
	}

	public Productos obtenerProducto(String codigoProducto) {

		Productos productoEncontrado = null;

		for (Productos productos : listaProductos) {
			if (productos.getCodigo().equals(codigoProducto)) {
				productoEncontrado = productos;
				break;

			}
		}
		return productoEncontrado;

	}

	// ---------------------EMPLEADOS---------------------------------

	public Empleados agregarEmpleado(String nombre, String codigo, double sueldo) {
		if (existeEmpleado(codigo)) {
			return null;
		} else {
			Empleados nuevoEmpleado = new Empleados();
			nuevoEmpleado.setNombre(nombre);
			nuevoEmpleado.setCodigo(codigo);
			nuevoEmpleado.setSueldo(sueldo);
			getListaEmpleados().add(nuevoEmpleado);
			return nuevoEmpleado;
		}
	}

	private boolean existeEmpleado(String codigo) {

		boolean existe = false;
		for (Empleados empleados : listaEmpleados) {
			if (empleados.getCodigo().equals(codigo)) {
				existe = true;
				return existe;
			}

		}
		return existe;

	}

	public Boolean eliminarEmpleado(String codigo) {

		Boolean flagEliminado = false;
		Empleados empleados = obtenerEmpleado(codigo);

		if (empleados != null) {
			getListaEmpleados().remove(empleados);
			flagEliminado = true;
		}
		return flagEliminado;
	}

	public Empleados obtenerEmpleado(String codigoEmpleado) {

		Empleados empleadoEncontrado = null;

		for (Empleados empleados : listaEmpleados) {
			if (empleados.getCodigo().equals(codigoEmpleado)) {
				empleadoEncontrado = empleados;
				break;

			}
		}
		return empleadoEncontrado;

	}


}