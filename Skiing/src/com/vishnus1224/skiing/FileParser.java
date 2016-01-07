package com.vishnus1224.skiing;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Helper for parsing the contents of the file specified by the URL.
 * @author Vishnu
 *
 */
public class FileParser {

	private String fileURL;
	
	public FileParser(String fileURL){
		this.fileURL = fileURL;
	}
	
	/**
	 * Parse the contents of the file specified by fileURL.
	 * @param firstRowIndex Index of the first row.
	 * @param firstColumnIndex Index of the first column.
	 * @param lastRowIndex Index of the last row.
	 * @param lastColumnIndex Index of the last column.
	 * @return A 2D array with the parsed numbers.
	 */
	public int[][] parse(int firstRowIndex, int firstColumnIndex, int lastRowIndex, int lastColumnIndex){
		
		Scanner scanner = null;
		
		int[][] elementMatrix = new int[lastRowIndex][lastColumnIndex];
		
		try {
			URL url = new URL(fileURL);
			scanner = new Scanner(url.openStream());
			
			scanner.nextInt();
			scanner.nextInt();
			
			for(int i = firstRowIndex; i < lastRowIndex; i++){
				for(int j = firstColumnIndex; j < lastColumnIndex; j++){
					elementMatrix[i][j] = scanner.nextInt();
				}
			}
			
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}finally{
			if(scanner != null){
				scanner.close();
			}
		}
		
		return elementMatrix;
		
	}
	
}
