package co.uniquindio.programacion3.consulta.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Aplicacion;
import co.uniquindio.programacion3.consulta.modell.Empleados;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class GestionEmpleadoController {

	private Aplicacion aplicacion;
	private ModelFactoryController modelFactoryController;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtSueldo;

	@FXML
	private Button btnAtras;

	@FXML
	private TableView<Empleados> tableviewEmpleados;

	@FXML
	private TableColumn<String, Empleados> columNombre;

	@FXML
	private TableColumn<String, Empleados> columCodigo;

	@FXML
	private TableColumn<String, Empleados> columSueldo;

	@FXML
	private TextField txtNombre;

	@FXML
	private Button btnLimpiar;

	@FXML
	private Button btnEliminar;

	@FXML
	private TextField txtCodigo;

	@FXML
	private Button btnAgregar;

	@FXML
	void limpiarEmpleado(ActionEvent event) {

		txtNombre.clear();
		txtCodigo.clear();
		txtSueldo.clear();

	}

	@FXML
	void agregarEmpleado(ActionEvent event) {

		// Empleados empleadito = new Empleados();

		String nombre = txtNombre.getText();
		String codigo = txtCodigo.getText();
		String sueldo = this.txtSueldo.getText();


		try {

			if (datosValidos(nombre, codigo, sueldo)) {
				double sueldoAux = sueldoADouble(sueldo);
				crearEmpleado(nombre, codigo, sueldoAux);
				actualizarTabla();
			}

		} catch (Exception e) {

			mostrarMensaje("Notificacin Empleado", "Empleado no guardado",
					"El empleado " + nombre + " no ha sido guardado", AlertType.WARNING);
		}

		// empleadito.guardarEmpleado(empleadito.getNombre(),
		// empleadito.getCodigo(), empleadito.getSueldo());

	}

	private double sueldoADouble(String sueldo) {
		double sueldoAux = 0;
		try {
			sueldoAux = Double.parseDouble(sueldo);
		}catch (Exception e){
			mostrarMensaje("Advertencia", "Informaci�n del empleado invalida", "Ingrese un valor numerico en el sueldo", AlertType.WARNING);
		}
		return sueldoAux;
	}

	private void crearEmpleado(String nombre, String codigo, double sueldo) {
		Empleados empleado = aplicacion.crearEmpleados(nombre, codigo, sueldo);

		// Notificar que el empleado fue guardado
		if (empleado != null) {
			listadoEmpleados.add(0, empleado);
			listadoEmpleados.add(empleado);
			mostrarMensaje("Notificaci�n Empleado", "Empleado guardado",
					"El empleado " + empleado.getNombre() + " ha sido guardado", AlertType.INFORMATION);
		} else {
			mostrarMensaje("Notificaci�n Empleado", "Empleado no guardado",
					"El empleado " + nombre + " no ha sido guardado", AlertType.WARNING);
		}

	}

	/**
	 * Este metodo muestra un mensaje al usuario
	 *
	 * @param titulo
	 * @param header
	 * @param contenido
	 * @param alertType
	 */
	public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

		Alert alerta = new Alert(alertType);
		alerta.setTitle(titulo);
		alerta.setHeaderText(header);
		alerta.setContentText(contenido);
		alerta.showAndWait();

	}

	/*
	 * Metodo que permite verificar si todos los campos han sido dilingeciados
	 */
	private boolean datosValidos(String nombre, String codigo, String sueldo) {

		boolean flag = true;
		String notificacion = "";

		if (nombre == null || nombre.equals("")) {
			notificacion += "Nombre no tiene informaci�n\n";

		}
		if (codigo == null || codigo.equals("")) {
			notificacion += "Codigo no tiene informaci�n\n";

		}

		 if (sueldo.equals("")) {
			 flag = false;
		 	notificacion += "Sueldo no tiene informaci�n\n";

		 }
		if(flag){
			try {
				double sueldoAux = Double.parseDouble(sueldo);
			}catch (Exception e){
				notificacion += "El sueldo debe contener valores numericos";
			}

		}

		if (notificacion.equals("")) {
			return true;

		}

		mostrarMensaje("Advertencia", "Informaci�n del empleado invalida", notificacion, AlertType.WARNING);
		return false;
	}

//	public Boolean verificarConvertirSueldo(String sueldo) {
//
//		try {
//
//			double sueldoOut = Double.parseDouble(sueldo);
//			return true;
//
//		} catch (Exception e) {
//
//			return false;
//		}

//	}

	@FXML
	void eliminarEmpleado(ActionEvent event) {

		if (empleadoSeleccion != null) {
			if (aplicacion.eliminarEmpleados(empleadoSeleccion.getCodigo())) {
				mostrarMensaje("Informaci�n", "Empleado  eliminado", "El empleado ha sido eliminado", AlertType.ERROR);
			} else {

				mostrarMensaje("Informaci�n", "Empleado selecci�n", "No se ha realizado la selecci�n de un empleado",
						AlertType.INFORMATION);

			}

			listadoEmpleados.remove(empleadoSeleccion);
		} else {
			mostrarMensaje("Advertencia", "Empleado selecci�n", "No se ha realizado una seleccion de un empleado",
					AlertType.ERROR);

		}

	}

	// ------------------TABLA-------------------------

	ObservableList<Empleados> listadoEmpleados = FXCollections.observableArrayList();

	private Empleados empleadoSeleccion;

	private void mostrarInformacion() {

		if (empleadoSeleccion != null) {

			txtNombre.setText(empleadoSeleccion.getNombre());
			txtCodigo.setText(empleadoSeleccion.getCodigo());
			txtSueldo.setText(empleadoSeleccion.getSueldo() + "");
		}

	}

	public void actualizarTabla() {

		tableviewEmpleados.getItems().clear();
		listadoEmpleados.clear();

		listadoEmpleados.addAll(modelFactoryController.getListaEmpleados());
		tableviewEmpleados.getItems().addAll(listadoEmpleados);
		tableviewEmpleados.refresh();
	}

	@FXML
	void mostrarVentanaPrincipal(ActionEvent event) {
		aplicacion.mostrarVentanaPrincipal();
	}

	@FXML
	void initialize() {

		this.columNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		this.columSueldo.setCellValueFactory(new PropertyValueFactory<>("sueldo"));

		tableviewEmpleados.getSelectionModel().selectedItemProperty().addListener((obs, olSelection, newSelection) -> {

			if (newSelection != null) {
				empleadoSeleccion = newSelection;
				mostrarInformacion();

			}

		});

	}

	public void setAplicacion(Aplicacion aplicacion) {

		this.aplicacion = aplicacion;
		this.modelFactoryController = aplicacion.getModelFactoryController();

		tableviewEmpleados.getItems().clear();
		tableviewEmpleados.setItems(getEmpleados());

	}

	private ObservableList<Empleados> getEmpleados() {
		listadoEmpleados.addAll(modelFactoryController.getListaEmpleados());
		return listadoEmpleados;
	}

	public void setAplicacion(ModelFactoryController modelFactoryController) {
	}

}
