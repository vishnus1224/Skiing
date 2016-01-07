package com.vishnus1224.skiing;

/**
 * Represents a path encapsulating its length and slope.
 * @author Vishnu
 *
 */
public class Path {

	private int length;
	private int slope;
	
	public Path(int length, int slope){
		this.length = length;
		this.slope = slope;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getSlope() {
		return slope;
	}

	public void setSlope(int slope) {
		this.slope = slope;
	}
	
}
