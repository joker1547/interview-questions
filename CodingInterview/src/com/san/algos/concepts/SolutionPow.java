package com.san.algos.concepts;

import java.util.HashMap;
import java.util.Map;

public class SolutionPow {
	public double myPow(double x, int n, Map<Integer, Double> map) {
        if(n == 0) {
            return 1.0; 
        }
        if(map.containsKey(n)) {
            return map.get(n);
        }
        if(n > 0) {
            double data = x * myPow(x, n-1, map);
            map.put(n, data);
        }
        else {
            double data = (1 / myPow(x, n*-1, map));
            map.put(n, data);    
        }  
        return map.get(n);
    }
    public double myPow(double x, int n) {               
        Map<Integer, Double> map = new HashMap<Integer, Double>();
        return myPow(x, n, map);                  
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
