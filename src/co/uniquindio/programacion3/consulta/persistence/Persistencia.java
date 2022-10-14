
package co.uniquindio.programacion3.consulta.persistence;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.util.ArrayList;

import co.uniquindio.programacion3.consulta.modell.Empleado;
import co.uniquindio.programacion3.consulta.modell.Empresa;
import co.uniquindio.programacion3.consulta.modell.Producto;

public class Persistencia {

	public static final String RUTA_ARCHIVO_EMPLEADOS = "src/resources/archivoEmpleados.txt";
	public static final String RUTA_ARCHIVO_PRODUCTO = "src/resources/archivoProductos.txt";

	public static void cargarDatosArchivos(Empresa empresa) throws FileNotFoundException, IOException {

		// cargar archivo de empleados
		ArrayList<Empleado> empleadosCargados = cargarEmpleados();

		if (empleadosCargados.size() > 0)
			empresa.getListaEmpleados().addAll(empleadosCargados);

		// cargar archivos productos
		ArrayList<Producto> productosCargados = cargarProductos();

		if (productosCargados.size() > 0)
			empresa.getListaProductos().addAll(productosCargados);

	}

	/**
	 * Guarda en un archivo de texto todos la información de las personas
	 * almacenadas en el ArrayList
	 *
	 * @param objetos
	 * @param ruta
	 * @throws IOException
	 */

	public static void guardarEmpleados(ArrayList<Empleado> listaEmpleados) throws IOException {

		// TODO Auto-generated method stub
		String contenido = "";

		for (Empleado empleados : listaEmpleados) {
			contenido += empleados.getNombre() + "," + empleados.getCodigo() + "," + empleados.getSueldo() + "\n";

		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_EMPLEADOS, contenido, false);
	}

	public static void guardarProductos(ArrayList<Producto> listaProductos) throws IOException {
		// TODO Auto-generated method stub
		String contenido = "";

		for (Producto productos : listaProductos) {
			contenido += productos.getNombre() + "," + productos.getCodigo() + "," + productos.getPrecio() + "\n";

		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PRODUCTO, contenido, false);

	}

	// ----------------------LOADS------------------------

	/**
	 *
	 * @param tipoPersona
	 * @param ruta
	 * @return un Arraylist de personas con los datos obtenidos del archivo de
	 *         texto indicado
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static ArrayList<Empleado> cargarEmpleados() throws IOException {

		ArrayList<Empleado> empleados = new ArrayList<Empleado>();

		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_EMPLEADOS);
		String linea = "";

		for (int i = 0; i < contenido.size(); i++) {
			linea = contenido.get(i);
			Empleado empleado = new Empleado();
			empleado.setNombre(linea.split(",")[0]);
			empleado.setCodigo(linea.split(",")[1]);
			empleado.setSueldo(Double.parseDouble(linea.split(",")[2]));
			empleados.add(empleado);

		}
		return empleados;
	}

	public static ArrayList<Producto> cargarProductos() throws FileNotFoundException, IOException {
		ArrayList<Producto> productos = new ArrayList<Producto>();

		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PRODUCTO);
		String linea = "";

		for (int i = 0; i < contenido.size(); i++) {
			linea = contenido.get(i);
			Producto producto = new Producto();
			producto.setNombre(linea.split(",")[0]);
			producto.setCodigo(linea.split(",")[1]);
			producto.setPrecio(Double.parseDouble(linea.split(",")[2]));
			productos.add(producto);
		}
		return productos;
	}

	// ----------------------SAVES------------------------

	/**
	 * Guarda en un archivo de texto todos la información de las personas
	 * almacenadas en el ArrayList
	 *
	 * @param objetos
	 * @param ruta
	 * @throws IOException
	 */

	public static void guardarObjetos(ArrayList<Empleado> listaEmpleados, String ruta) throws IOException {
		String contenido = "";

		for (Empleado empleadosAux : listaEmpleados) {

			contenido += empleadosAux.getNombre() + "," + empleadosAux.getCodigo() + "," + empleadosAux.getSueldo()
					+ "\n";
		}
		ArchivoUtil.guardarArchivo(ruta, contenido, true);
	}

}