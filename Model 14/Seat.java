package com.models;

public class Seat {
	
	int seatRow;
	int seatColumn;
	public Seat(int seatRow, int seatColumn) {
		super();
		this.seatRow = seatRow;
		this.seatColumn = seatColumn;
	}
	@Override
	public String toString() {
		return "Seat [seatRow=" + seatRow + ", seatColumn=" + seatColumn + "]";
	}
	public int getSeatRow() {
		return seatRow;
	}
	public void setSeatRow(int seatRow) {
		this.seatRow = seatRow;
	}
	public int getSeatColumn() {
		return seatColumn;
	}
	public void setSeatColumn(int seatColumn) {
		this.seatColumn = seatColumn;
	}

}
