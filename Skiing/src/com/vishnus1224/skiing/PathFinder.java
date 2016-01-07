package com.vishnus1224.skiing;

import java.util.Stack;

/**
 * Finds the long path from the input matrix.
 * @author Vishnu
 *
 */
public class PathFinder {

	private int[][] elementMatrix;
	
	private int lastRowIndex;
	
	private int lastColumnIndex;
	
	int len = 0;
	int slo = 0;
	
	public PathFinder(int[][] elementMatrix, int lastRowIndex, int lastColumnIndex){
		this.elementMatrix = elementMatrix;
		this.lastRowIndex = lastRowIndex;
		this.lastColumnIndex = lastColumnIndex;
	}
	
	/**
	 * Find the longest path within the input matrix.
	 * @return The longest path.
	 */
	public Path longestPath(){
		
		//represents the length of the longest path from the current element.
		int maxPathLength = 0;
		int maxSlope = 0;
		
		for(int rowIndex = 0; rowIndex < lastRowIndex; rowIndex++){
		
			for(int columnIndex = 0; columnIndex < lastColumnIndex; columnIndex++){
				
				int currentElement = elementMatrix[rowIndex][columnIndex];
			
				//position of the element to be pushed on the stack from the starting element.
				int stackPosition = 1;
				
				Stack<MatrixElement> validNeighbourStack = new Stack<MatrixElement>();
				
				//push the element for which the path needs to be calculated on to the stack.
				validNeighbourStack.push(MatrixElement.newInstance(rowIndex, columnIndex, currentElement, stackPosition));
				
				//continue processing neighbors until stack is empty.
				while(!validNeighbourStack.isEmpty()){
					
					//if a valid neighbor is found in any direction, then set this flag to true and increment currentLength.
					boolean incrementLength = false;
					
					MatrixElement elementToProcess = validNeighbourStack.pop();
					
					stackPosition = elementToProcess.getPosition();
					
					//the current length of the path. When coming back to process neighbors of an element, reset to the saved position and start processing again.
					int currentLength = stackPosition;
					
					//set rowIndex and columnIndex to the index of the current element being processed.
					int elementRowIndex = elementToProcess.getRowIndex();
					int elementColumnIndex = elementToProcess.getColumnIndex();
					
					//check for valid neighbors. i.e. if the index is not out of bounds and if it's value is less than the current element.
					
					//check the top element.
					int topRowIndex = elementRowIndex - 1;
		
					//if the index to check is not out of bounds.
					if(topRowIndex >= 0){
						
						//if the element is less than the current value.
						if(elementMatrix[topRowIndex][elementColumnIndex] < elementToProcess.getValue()){
							
							//a neighbor is found so increment the length.
							incrementLength = true;
							//push this element on to the stack at a position that is one greater than the current position.
							validNeighbourStack.push(MatrixElement.newInstance(topRowIndex, elementColumnIndex, elementMatrix[topRowIndex][elementColumnIndex], stackPosition + 1));
						}
					}
					
					//check the bottom element.
					int bottomRowIndex = elementRowIndex + 1;
					
					//bounds check.
					if(bottomRowIndex < lastColumnIndex){
						
						if(elementMatrix[bottomRowIndex][elementColumnIndex] < elementToProcess.getValue()){
							
							incrementLength = true;
							validNeighbourStack.push(MatrixElement.newInstance(bottomRowIndex, elementColumnIndex, elementMatrix[bottomRowIndex][elementColumnIndex], stackPosition + 1));
						}
					}
					
					//check the left element.
					int leftColumnIndex = elementColumnIndex - 1;
					
					if(leftColumnIndex >= 0){
						if(elementMatrix[elementRowIndex][leftColumnIndex] < elementToProcess.getValue()){
							incrementLength = true;
							validNeighbourStack.push(MatrixElement.newInstance(elementRowIndex, leftColumnIndex, elementMatrix[elementRowIndex][leftColumnIndex], stackPosition + 1));
						}
					}
					
					int rightColumnIndex = elementColumnIndex + 1;
					
					if(rightColumnIndex < lastRowIndex){
						if(elementMatrix[elementRowIndex][rightColumnIndex] < elementToProcess.getValue()){
							incrementLength = true;
							validNeighbourStack.push(MatrixElement.newInstance(elementRowIndex, rightColumnIndex, elementMatrix[elementRowIndex][rightColumnIndex], stackPosition + 1));
						}
					}
					
					
					if(incrementLength){
						currentLength++;
					}
					
					//if current length is greater than assign it to the max directly, and find the slope.
					//slope calculation is not necessary if currentLength is less than maxLength.
					if(currentLength > maxPathLength){
						maxPathLength = currentLength;
						
						maxSlope = currentElement - elementToProcess.getValue();
						
					}else if(currentLength == maxPathLength){
						//if the lengths are equal, compare slopes and then assign the max length accordingly.
						int newSlope = currentElement - elementToProcess.getValue();
						
						if(newSlope > maxSlope){
							maxSlope = newSlope;
							//this is not necessary as the paths are equal.
							maxPathLength = currentLength;
						}
					}
					
				}
				
			}
		
		}
		
		
		return new Path(maxPathLength, maxSlope);
	}
	
}
