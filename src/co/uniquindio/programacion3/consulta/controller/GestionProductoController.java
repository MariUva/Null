package co.uniquindio.programacion3.consulta.controller;

import application.Aplicacion;
import co.uniquindio.programacion3.consulta.modell.Productos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class GestionProductoController {

	private Aplicacion aplicacion;
	private ModelFactoryController modelFactoryController;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableView<Productos> tableviewProductos;

	@FXML
	private TableColumn<String, Productos> columNombre;

	@FXML
	private TableColumn<String, Productos> columCodigo;

	@FXML
	private TableColumn<String, Productos> columPrecio;

	@FXML
	private TextField txtPrecio;

	@FXML
	private Button btnAtras;

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
	void limpiarProductos(ActionEvent event) {

		txtNombre.clear();
		txtCodigo.clear();
		txtPrecio.clear();

	}

	@FXML
	void agregarProductos(ActionEvent event) {

		String nombre = txtNombre.getText();
		String codigo = txtCodigo.getText();
		double precio = Double.parseDouble(this.txtPrecio.getText());

		if (datosValidos(nombre, codigo, precio)) {
			crearProducto(nombre, codigo, precio);

			actualizarTabla();
		}

	}

	private void crearProducto(String nombre, String codigo, double precio) {

		// Notificar al usuario que el cliente fue registrado
		Productos producto = aplicacion.crearProductos(nombre, codigo, precio);

		if (producto != null) {
			listadoProductos.add(0, producto);
			listadoProductos.add(producto);
			mostrarMensaje("Notificacción Producto", "Producto almacenado",
					"El producto " + producto.getNombre() + "ha sido almacenado", AlertType.INFORMATION);
		} else {
			mostrarMensaje("Notificación Producto", "Producto no almacenado",
					"El producto " + nombre + " no ha sido almacenado", AlertType.WARNING);
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
	private boolean datosValidos(String nombre, String codigo, double precio) {

		String notificacion = "";
		// double emptyString = Double.parseDouble("");

		if (nombre == null || nombre.equals("")) {
			notificacion += "Nombre no tiene información\n";

		}
		if (codigo == null || codigo.equals("")) {
			notificacion += "Codigo no tiene información\n";

		}

		// if (precio == Double.parseDouble(null)) {

		// notificacion += "Precio no tiene información\n";

		// }

		if (notificacion.equals("")) {
			return true;

		}

		mostrarMensaje("Advertencia", "Información del producto invalida", notificacion, AlertType.WARNING);
		return false;
	}

	@FXML
	void eliminarProductos(ActionEvent event) {

		if (productoSeleccion != null) {
			if (aplicacion.eliminarProductos(productoSeleccion.getCodigo())) {
				mostrarMensaje("Información", "Producto  eliminado", "El producto ha sido eliminado", AlertType.ERROR);
			} else {

				mostrarMensaje("Información", "Producto selección", "No se ha realizado la selección de un producto",
						AlertType.INFORMATION);

			}

			listadoProductos.remove(productoSeleccion);
		} else {
			mostrarMensaje("Advertencia", "Producto selección", "No se ha realizado una seleccion de un producto",
					AlertType.ERROR);

		}

	}

	// --------------TABLA-------------------------

	ObservableList<Productos> listadoProductos = FXCollections.observableArrayList();

	private Productos productoSeleccion;

	private void mostrarInformacion() {

		if (productoSeleccion != null) {

			txtNombre.setText(productoSeleccion.getNombre());
			txtCodigo.setText(productoSeleccion.getCodigo());
			txtPrecio.setText(productoSeleccion.getPrecio() + "");

		}

	}

	public void actualizarTabla() {

		tableviewProductos.getItems().clear();
		listadoProductos.clear();

		listadoProductos.addAll(modelFactoryController.getListaProductos());
		tableviewProductos.getItems().addAll(listadoProductos);
		tableviewProductos.refresh();
	}

	@FXML
	void mostrarVentanaPrincipal(ActionEvent event) {
		aplicacion.mostrarVentanaPrincipal();
	}

	@FXML
	void initialize() {

		this.columNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		this.columPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

		tableviewProductos.getSelectionModel().selectedItemProperty().addListener((obs, olSelection, newSelection) -> {

			if (newSelection != null) {
				productoSeleccion = newSelection;
				mostrarInformacion();

			}

		});

	}

	public void setAplicacion(Aplicacion aplicacion) {

		this.aplicacion = aplicacion;
		this.modelFactoryController = aplicacion.getModelFactoryController();

		tableviewProductos.getItems().clear();
		tableviewProductos.setItems(getProductos());

	}

	private ObservableList<Productos> getProductos() {
		listadoProductos.addAll(modelFactoryController.getListaProductos());
		return listadoProductos;
	}

	public void setAplicacion(ModelFactoryController modelFactoryController) {
	}

}
