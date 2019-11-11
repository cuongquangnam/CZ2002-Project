package model;

public class Cinema {

	private Cineplex cineplex;
	private boolean is3D;
	private boolean isPlatinum;

	public Cinema(Cineplex cineplex, boolean is3D, boolean isPlatinum) {
		this.cineplex = cineplex;
		this.is3D = is3D;
		this.isPlatinum = isPlatinum;
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


}
