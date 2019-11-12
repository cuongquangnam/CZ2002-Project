package model;

public class Cinema {

	private Cineplex cineplex;
	private boolean is3D;
	private boolean isPlatinum;
	private String code;

	public Cinema() {}
	public Cinema(Cineplex cineplex, boolean is3D, boolean isPlatinum, String code) {
		this.cineplex = cineplex;
		this.is3D = is3D;
		this.isPlatinum = isPlatinum;
		this.code = code;
	}

	public Cineplex getCineplex() {
		return cineplex;
	}
	public void setCineplex(Cineplex cineplex) {
		this.cineplex = cineplex;
	}
	public boolean is3D() {
		return is3D;
	}
	public void setIs3D(boolean is3d) {
		is3D = is3d;
	}
	public boolean isPlatinum() {
		return isPlatinum;
	}
	public void setPlatinum(boolean isPlatinum) {
		this.isPlatinum = isPlatinum;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
