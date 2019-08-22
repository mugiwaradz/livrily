package com.zinou.Livrily.model;

public class Adress {
	
	private int Adress_ID;
	private int GPS_Infos_ID;
	private int CodePostale;
	private String Carte;
	private String Commune;
	private String wilaya;
	
	public int getAdress_ID() {
		return Adress_ID;
	}
	public void setAdress_ID(int adress_ID) {
		Adress_ID = adress_ID;
	}
	public int getGPS_Infos_ID() {
		return GPS_Infos_ID;
	}
	public void setGPS_Infos_ID(int gPS_Infos_ID) {
		GPS_Infos_ID = gPS_Infos_ID;
	}
	public int getCodePostale() {
		return CodePostale;
	}
	public void setCodePostale(int codePostale) {
		CodePostale = codePostale;
	}
	public String getCarte() {
		return Carte;
	}
	public void setCarte(String carte) {
		Carte = carte;
	}
	public String getCommune() {
		return Commune;
	}
	public void setCommune(String commune) {
		Commune = commune;
	}
	public String getWilaya() {
		return wilaya;
	}
	public void setWilaya(String wilaya) {
		this.wilaya = wilaya;
	}
	
	


}
