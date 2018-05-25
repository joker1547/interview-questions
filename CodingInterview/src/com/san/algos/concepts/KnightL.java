package com.san.algos.concepts;
import java.util.Scanner;

public class KnightL {

    public static int getPathForKnight(int a, int b, int[][]visited, int row, int col, boolean found){
        System.out.println(row + " - " + col);
        if(row == visited.length-1 && col == visited.length - 1 ){
            System.out.println("found node");
            found = true;
            return 0;
        }
            
        if(visited[row][col] == 1) //entered a cycle.  no path found. just return.
            return 0;
        int path = 0;
        visited[row][col] = 1;
        path++;
        if(row+a < visited.length){
            if(col+b < visited.length){
                path += getPathForKnight(a, b, visited, row+a, col+b, found);     
                System.out.println( "path = " + path);                
                if(found)
                    return path;
            }
            if(col-b >= 0){
                path += getPathForKnight(a, b, visited, row+a, col-b, found);
               // System.out.println( "path = " + path);
                if(found)
                    return path;                
            }
        }
        if(row-a >= 0){
            if(col+b < visited.length){
                path += getPathForKnight(a, b, visited, row-a, col+b, found);                                    
//                System.out.println( "path = " + path);                
                if(found)
                    return path;
            }
            if(col-b >= 0){
                path += getPathForKnight(a, b, visited, row-a, col-b, found);                            
//                System.out.println( "path = " + path);                
                if(found)
                    return path;                        
            }
        }   

        //System.out.println(path);
        return -1;
        
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // your code goes here
        int[][] board = new int[n][n];
        int[][] visited = new int[n][n];
        boolean found = false;
        int path = getPathForKnight(1, 3, visited, 0, 0, found);
        /***for(int a = 1; a < n; a++){
            for(int b = 1; b < n; b++){              
                int[][] visited = new int[n][n];
                System.out.println(a + " : " + b);
                int path = getPathForKnight(a, b, visited, 0, 0);
                System.out.println(path );                
            }
            System.out.println();
        }**/
    }
}
