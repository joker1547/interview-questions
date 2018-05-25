package com.san.algos.concepts;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 * @author subrsa
 * modified a little bit to take additional.
 * 
 */
public class MinCostDP {
	
	public static int findShortestPath(int[][] matrix, int sourceRow, int sourceCol, int targetRow, int targetCol) {
		if(sourceRow == targetRow && sourceCol == targetCol) {
			return matrix[targetRow][targetCol];
		}
		if(targetRow < 0 || targetRow > matrix.length) {
			return 8 ;
		}			
		if(targetCol < 0 || targetCol > matrix.length) {
			return 8;
		}
		return matrix[targetRow][targetCol] + min (
					 findShortestPath(matrix, sourceRow, sourceCol, targetRow, targetCol-1)
					,  findShortestPath(matrix, sourceRow, sourceCol, targetRow-1, targetCol-1)
					,  findShortestPath(matrix, sourceRow, sourceCol, targetRow-1, targetCol) );
	}
	
	public static int min(int x, int y, int z) {
		if(x < y)
			return (x < z )? x : z;
		else
			return (y < z)? y : z;
	}
	
		
	
	public static void calculateParentPoint(int[][]matrix, String[][]parents) {
		parents[0][0] = "0-0";
		int leftCellRow, leftCellCol, topCellRow, topCellCol, diagCellRow, diagCellCol;
		
		int minX, minY;
		
		for(int row = 0; row < matrix.length; row++) {			
			for(int col = 0; col < matrix[row].length; col++) {
				int min = 500; //Integer.max_value not working correctly.
				minX = row;
				minY = col;
				leftCellRow = row;
				leftCellCol = col-1;
				topCellRow = row-1;
				topCellCol = col;
				diagCellRow = row-1;
				diagCellCol = col-1;
				if(leftCellRow >= 0 && leftCellCol >= 0 ) {
					//System.out.println(matrix[leftCellRow][leftCellCol] + " " + min);
					int val = matrix[leftCellRow][leftCellCol];
					if(val < min) {
						minX = leftCellRow;
						minY = leftCellCol;
						min = matrix[leftCellRow][leftCellCol]; 						
					}
				}
					
				if(topCellRow >= 0 && topCellCol >= 0 && matrix[topCellRow][topCellCol] < min) {
					minX = topCellRow;
					minY = topCellCol;
					min = matrix[topCellRow][topCellCol];
				}
				if(diagCellRow >= 0 && diagCellCol >= 0 && matrix[diagCellRow][diagCellCol] < min) {
					minX = diagCellRow;
					minY = diagCellCol;
					min = matrix[diagCellRow][diagCellCol];
				}
				parents[row][col] = "" + minX + "-" + minY;
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("enter matrix size: ");
		int size = in.nextInt();
		int[][] costMatrix = new int[size][size];
		System.out.println("----------------Cost Matrix -------------");
		for(int i = 0; i < costMatrix.length; i++){
			for(int j = 0; j < costMatrix[i].length; j++) {
				int ran = (int) (Math.random() * 6 ) + 1;
				costMatrix[i][j] = ran;				
			}
			System.out.println(Arrays.toString(costMatrix[i]));
		}
//		System.out.println("enter target row: ");
//		int tr = in.nextInt();
//		System.out.println("enter target col: ");		
//		int tc = in.nextInt();
//		System.out.println("enter source row: ");
//		int sr = in.nextInt();
//		System.out.println("enter source col: ");
//		int sc = in.nextInt();
		
		//System.out.println(findShortestPath(costMatrix, sr, sc, tr, tc));
		
		String [][] points = new String[costMatrix.length][costMatrix.length];
		calculateParentPoint(costMatrix, points);
		for(int i = 0; i < points.length; i++){
			System.out.println(Arrays.toString(points[i]));
		}
		
	}
}
