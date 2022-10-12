package co.uniquindio.programacion3.consulta.controller;

import java.net.URL;
import java.util.ResourceBundle;
import application.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class GestionVentanaPrincipalController implements Initializable {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnProductos;

	@FXML
	private Button btnEmpleados;

	@FXML
	void IrEmpleados(ActionEvent event) {

		aplicacion.llamarEmpleado();

	}

	@FXML
	void IrProductos(ActionEvent event) {

		aplicacion.llamarProductos();

	}

	private Aplicacion aplicacion;
	private ModelFactoryController modelFactoryController;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	@FXML
	public void initialize() {

	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
		this.modelFactoryController = aplicacion.getModelFactoryController();
	}

}
