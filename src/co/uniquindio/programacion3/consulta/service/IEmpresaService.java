package co.uniquindio.programacion3.consulta.service;

import java.util.ArrayList;

import co.uniquindio.programacion3.consulta.modell.Empleado;

public interface IEmpresaService {



	public boolean actualizarEmpleado(String nombre, String codigo, double sueldo);
	public Boolean eliminarEmpleado(String codigo);
	Empleado crearEmpleado(String nombre, String codigo, double sueldo);
	Empleado obtenerEmpleado(String codigo);
	ArrayList<Empleado> obtenerEmpleados();


}
