package com.san.algos.concepts;
import java.util.Arrays;
import java.util.Calendar;

public class ProductAssociation {
	public static void calculateAssociations(String[] associations){
		
	}
	public static void main(String args[]){
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		String[] associations = new String[n];
//		for(int i = 0; i < n; i++){
//			associations[i] = in.next();			
//		}
//		calculateAssociations(associations);
		String a = "cbaghkmnd";
		char[] b = a.toCharArray();
		Arrays.sort(b);
		System.out.println(new String(b));
		System.out.println(Calendar.getInstance().get(Calendar.YEAR));
		int year = Calendar.getInstance().get(Calendar.YEAR);
		System.out.println(year % 100);
	}
}
