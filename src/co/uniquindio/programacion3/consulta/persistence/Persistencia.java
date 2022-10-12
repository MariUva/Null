
package co.uniquindio.programacion3.consulta.persistence;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.util.ArrayList;

import co.uniquindio.programacion3.consulta.modell.Empleados;
import co.uniquindio.programacion3.consulta.modell.Empresa;
import co.uniquindio.programacion3.consulta.modell.Productos;

public class Persistencia {

	public static final String RUTA_ARCHIVO_EMPLEADOS = "src/resources/archivoEmpleados.txt";
	public static final String RUTA_ARCHIVO_PRODUCTO = "src/resources/archivoProductos.txt";

	public static void cargarDatosArchivos(Empresa empresa) throws FileNotFoundException, IOException {

		// cargar archivo de empleados
		ArrayList<Empleados> empleadosCargados = cargarEmpleados();

		if (empleadosCargados.size() > 0)
			empresa.getListaEmpleados().addAll(empleadosCargados);

		// cargar archivos productos
		ArrayList<Productos> productosCargados = cargarProductos();

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

	public static void guardarEmpleados(ArrayList<Empleados> listaEmpleados) throws IOException {

		// TODO Auto-generated method stub
		String contenido = "";

		for (Empleados empleados : listaEmpleados) {
			contenido += empleados.getNombre() + "," + empleados.getCodigo() + "," + empleados.getSueldo() + "\n";

		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_EMPLEADOS, contenido, false);
	}

	public static void guardarProductos(ArrayList<Productos> listaProductos) throws IOException {
		// TODO Auto-generated method stub
		String contenido = "";

		for (Productos productos : listaProductos) {
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
	private static ArrayList<Empleados> cargarEmpleados() throws IOException {

		ArrayList<Empleados> empleados = new ArrayList<Empleados>();

		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_EMPLEADOS);
		String linea = "";

		for (int i = 0; i < contenido.size(); i++) {
			linea = contenido.get(i);
			Empleados empleado = new Empleados();
			empleado.setNombre(linea.split(",")[0]);
			empleado.setCodigo(linea.split(",")[1]);
			empleado.setSueldo(Double.parseDouble(linea.split(",")[2]));
			empleados.add(empleado);

		}
		return empleados;
	}

	public static ArrayList<Productos> cargarProductos() throws FileNotFoundException, IOException {
		ArrayList<Productos> productos = new ArrayList<Productos>();

		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PRODUCTO);
		String linea = "";

		for (int i = 0; i < contenido.size(); i++) {
			linea = contenido.get(i);
			Productos producto = new Productos();
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

	public static void guardarObjetos(ArrayList<Empleados> listEmpleados, String ruta) throws IOException {
		String contenido = "";

		for (Empleados empleadosAux : listEmpleados) {

			contenido += empleadosAux.getNombre() + "," + empleadosAux.getCodigo() + "," + empleadosAux.getSueldo()
					+ "\n";
		}
		ArchivoUtil.guardarArchivo(ruta, contenido, true);
	}

}