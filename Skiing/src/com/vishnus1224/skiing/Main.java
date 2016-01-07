package com.vishnus1224.skiing;


public class Main {
	
	private static final String TEXT_FILE_URL = "http://s3-ap-southeast-1.amazonaws.com/geeks.redmart.com/coding-problems/map.txt";

	private static final int FIRST_ROW_INDEX = 0;
	private static final int FIRST_COLUMN_INDEX = 0;
	
	private static final int LAST_ROW_INDEX = 1000;
	private static final int LAST_COLUMN_INDEX = 1000;
	

	public static void main(String[] args){

		FileParser fileParser = new FileParser(TEXT_FILE_URL);
		
		//parse the elements from the file.
		int[][] elementMatrix = fileParser.parse(FIRST_ROW_INDEX, FIRST_COLUMN_INDEX, LAST_ROW_INDEX, LAST_COLUMN_INDEX);
		
		PathFinder pathFinder = new PathFinder(elementMatrix, LAST_ROW_INDEX, LAST_COLUMN_INDEX);
		
		Path longestPath = pathFinder.longestPath();
		
		System.out.println(" Length : " + longestPath.getLength() + " Slope :" + longestPath.getSlope());
		
		
	} 
	
}
