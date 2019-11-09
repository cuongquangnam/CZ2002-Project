package models;
import java.util.*;

enum Type{
	COUPLE,ELITE, ULTIMA, NORMAL 
}
public class Seat {
	private Cinema cinema;
	private Type type;
	private Seat accompanied;
	private Map<showTime, Boolean> selected;
	
	public Seat(Cinema cinema, Type type, Seat accompanied) {
		this.cinema = cinema;
		this.type = type;
		this.accompanied = accompanied;
		this.selected = new HashMap<showTime,Boolean>();
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type, Seat accompanied) {
		this.type = type;
		this.accompanied = accompanied;
	}
	public void setAccompanied(Seat accompanied) {
		this.accompanied = accompanied;
	}
	public Seat getAccompanied() {
		return accompanied;
	}
	public Cinema getCinema(Cinema cinema) {
		return cinema;
	}
	public void addShowTime(showTime show, boolean bool) {
		this.addShowTime(show,Boolean.valueOf(bool));
	}
	public boolean getSelected(showTime time) {
		return selected.get(time).booleanValue();
	}
	public void setSelected(showTime time,boolean s ) {
		selected.put(time, Boolean.valueOf(s));
	}
}
