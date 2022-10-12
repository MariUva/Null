package co.uniquindio.programacion3.consulta.service;

import java.util.ArrayList;

import co.uniquindio.programacion3.consulta.modell.Empleados;

public interface IEmpresaService {



	public boolean actualizarEmpleado(String nombre, String codigo, double sueldo);
	public Boolean eliminarEmpleado(String codigo);
	Empleados crearEmpleado(String nombre, String codigo, double sueldo);
	Empleados obtenerEmpleado(String codigo);
	ArrayList<Empleados> obtenerEmpleados();


}
