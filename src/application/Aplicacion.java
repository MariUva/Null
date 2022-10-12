package application;


import co.uniquindio.programacion3.consulta.controller.GestionEmpleadoController;
import co.uniquindio.programacion3.consulta.controller.GestionProductoController;
import co.uniquindio.programacion3.consulta.controller.GestionVentanaPrincipalController;
import co.uniquindio.programacion3.consulta.controller.ModelFactoryController;
import co.uniquindio.programacion3.consulta.modell.Empleados;
import co.uniquindio.programacion3.consulta.modell.Productos;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Aplicacion extends Application {

	private Stage primaryStage;
	private ModelFactoryController modelFactoryController;

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		this.modelFactoryController = new ModelFactoryController();

		mostrarVentanaPrincipal();

	}

	public void mostrarVentanaPrincipal() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class
					.getResource("/co/uniquindio/programacion3/consulta/view/VentanaPrincipalView.fxml"));

			AnchorPane anchorPane = (AnchorPane) loader.load();
			GestionVentanaPrincipalController gestionVentanaPrincipalController = loader.getController();
			gestionVentanaPrincipalController.setAplicacion(this);

			// primaryStage.setX(400);
			// primaryStage.setY(150);

			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();
			this.primaryStage.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void llamarEmpleado() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Aplicacion.class.getResource("/co/uniquindio/programacion3/consulta/view/EmpleadosView.fxml"));

			AnchorPane anchorPane = (AnchorPane) loader.load();

			GestionEmpleadoController gestionEmpleadoController = loader.getController();
			gestionEmpleadoController.setAplicacion(this);

			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void llamarProductos() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Aplicacion.class.getResource("/co/uniquindio/programacion3/consulta/view/ProductoView.fxml"));

			AnchorPane anchorPane = (AnchorPane) loader.load();

			GestionProductoController gestionProductoController = loader.getController();
			gestionProductoController.setAplicacion(this);

			this.primaryStage.setResizable(false);
			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public ModelFactoryController getModelFactoryController() {
		return modelFactoryController;
	}

	public void setModelFactoryController(ModelFactoryController modelFactoryController) {
		this.modelFactoryController = modelFactoryController;
	}

	public static void main(String[] args) {
		launch(args);
	}

	// ---------------------------PRODUCTOS----------------------------------

	public Productos crearProductos(String nombre, String codigo, double precio) {
		Productos productos = modelFactoryController.agregarProducto(nombre, codigo, precio);
		return productos;
	}

	public boolean eliminarProductos(String codigo) {
		boolean eliminarProductos = modelFactoryController.eliminarProducto(codigo);
		return eliminarProductos;
	}

	// ----------------------------EMPLEADOS----------------------------------

	public Empleados crearEmpleados(String nombre, String codigo, double sueldo) {
		Empleados empleados = modelFactoryController.agregarEmpleado(nombre, codigo, sueldo);
		return empleados;

	}

	public boolean eliminarEmpleados(String codigo) {

		boolean eliminarEmpleado = modelFactoryController.eliminarEmpleado(codigo);
		return eliminarEmpleado;
	}

}
