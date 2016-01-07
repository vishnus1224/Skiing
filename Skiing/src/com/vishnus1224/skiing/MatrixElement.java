package com.vishnus1224.skiing;

public class MatrixElement {

	private int rowIndex;
	private int columnIndex;
	private int value;
	
	//the position of the element from the starting position.
	private int position;
	
	private MatrixElement(){
		
	}
	
	//private constructor. Use new instance for generating a new matrix element.
	private MatrixElement(int rowIndex, int columnIndex, int value, int position) {
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
		this.value = value;
		this.position = position;
	}
	
	public int getRowIndex() {
		return rowIndex;
	}
	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}
	public int getColumnIndex() {
		return columnIndex;
	}
	public void setColumnIndex(int columnIndex) {
		this.columnIndex = columnIndex;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	//creates and returns a new instance of this object.
	public static MatrixElement newInstance(int rowIndex, int columnIndex, int value, int position){
		return new MatrixElement(rowIndex, columnIndex, value, position);
	}
	
}
