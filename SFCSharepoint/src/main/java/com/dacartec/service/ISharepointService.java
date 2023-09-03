package com.dacartec.service;

public interface ISharepointService {
	
	/**
	 * 
	 * @param nombreArchivo
	 * @return
	 */
	String cargarArchivo(String nombreArchivo);
	
	/**
	 * 
	 * @param nombreCarpeta
	 * @param ruta
	 * @return
	 */
	String crearCarpeta(String nombreCarpeta, String ruta);
	
	/**
	 * 
	 * @return
	 */
	String asignarPermisos();
}