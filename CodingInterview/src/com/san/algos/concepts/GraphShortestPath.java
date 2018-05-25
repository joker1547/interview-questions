package com.san.algos.concepts;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphShortestPath {
	
	public class Point{
		public int x;
		public int y;
		public Point(int i, int j){
			x = i;
			y = j;
		}
		public String toString(){
			return "" + x + "-" + y;
		}
	}
	public void findShortestPath(int[][] matrix){
		//compute path value.
		int[][]distances = new int[matrix.length][matrix.length];
		Point[][] parents = new Point[matrix.length][matrix.length];
		printMatrix(distances);
		Queue queue = new LinkedList();
		Point p = new Point(0, 0); //start
		parents[0][0] = p;
		queue.add(p);
		while(!queue.isEmpty()){
			Point point = (Point)queue.poll();
			int i = point.x;
			int j = point.y;			
			if(j+1 < matrix.length && matrix[i][j+1] != 0){ 				
				int currentDist =  distances[i][j] + matrix[i][j+1];
				if(currentDist < distances[i][j+1] || distances[i][j+1] == 0){
					distances[i][j+1] = currentDist;
					parents[i][j+1] = point; 
				}
				queue.add(new Point(i, j+1)); 
			}
			if(i+1 < matrix.length && matrix[i+1][j] != 0 ){
				int currentDist = distances[i][j]+ matrix[i+1][j];
				if(currentDist < distances[i+1][j] || distances[i+1][j] == 0){
					distances[i+1][j] = currentDist;
					parents[i+1][j] = point; 
				}				
				queue.add(new Point(i+1, j));
			}
		}
		printMatrix(distances);
		printParent(parents);
	}
	
	public void printParent(Point[][] points){
		System.out.println("----------------------");
		for(int i= 0; i < points.length; i++){
			for(int j = 0; j < points[i].length; j++){
				if(points[i][j] != null)
					System.out.print(points[i][j].toString() + " ");
				else
					System.out.print("NR ");
			}
			System.out.println();
		}
		
	}
	public void printMatrix(int[][] matrix){
		System.out.println("----------------------");
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				System.out.print(matrix[i][j] + " ");
			}			
			System.out.println();
		}
	}

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] matrix = new int[n][n];
		for(int i = 0; i < n; i++){
			String s = in.next();
			char[] c = s.toCharArray();
			for(int j = 0; j < c.length; j++){
				matrix[i][j] = Integer.valueOf(""+c[j]);	
			}			 
		}
		GraphShortestPath g = new GraphShortestPath();
		g.printMatrix(matrix);
		g.findShortestPath(matrix);
		
	}
	
}
