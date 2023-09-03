package com.dacartec.dto;

public class CarpetaRequestDTO {
	private String nombreCarpeta;
	private String ruta;
	
	public CarpetaRequestDTO() {
	}
	
	/**
	 * @param nombreCarpeta
	 * @param ruta
	 */
	public CarpetaRequestDTO(String nombreCarpeta, String ruta) {
		this.nombreCarpeta = nombreCarpeta;
		this.ruta = ruta;
	}
	/**
	 * @return the nombreCarpeta
	 */
	public String getNombreCarpeta() {
		return nombreCarpeta;
	}
	/**
	 * @param nombreCarpeta the nombreCarpeta to set
	 */
	public void setNombreCarpeta(String nombreCarpeta) {
		this.nombreCarpeta = nombreCarpeta;
	}
	/**
	 * @return the ruta
	 */
	public String getRuta() {
		return ruta;
	}
	/**
	 * @param ruta the ruta to set
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	

}
