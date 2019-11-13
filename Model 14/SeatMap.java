package com.models;

public class SeatMap {
	private  int seatArr[][];

	
	
	
	
	public SeatMap() {
		this.seatArr = new int[7][7];
		for(int i=0; i<7; i++)
		{
			for(int j=0; j<7; j++)
			{
				seatArr[i][j] =0;
			}
		}
	}

	public  int[][] getSeatArr() {
		return seatArr;
	}

	public  void setSeatArr(int i, int j) {
		this.seatArr[i][j] = 1;
	}

}
