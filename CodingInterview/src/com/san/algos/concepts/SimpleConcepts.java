package com.san.algos.concepts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimpleConcepts {
	public static class LexComparator implements Comparator<String>{

		@Override
		public int compare(String s1, String s2) {						
			if(s1.startsWith("1") && s2.startsWith("1")){
				int a = Integer.valueOf(s1);
				int b = Integer.valueOf(s2);
				return (a<b)? 1 : -1;
			}
			else if(s1.charAt(0) == s2.charAt(0)){
				String shorterString = (s1.length() < s2.length())? s1: s2;
				String biggerString = (s1.length() > s2.length())? s1: s2;
				int index = 0;
				
				while(index < shorterString.length()){
					int v1 = Integer.parseInt(""+shorterString.charAt(index));
					int v2 = Integer.parseInt(""+biggerString.charAt(index));
					if(v1 > v2){
						if(shorterString.equals(s1)) return 1;
						else return -1;						
					}
					else if(v1 < v2){
						if(shorterString.equals(s1)) return -1;
						else return 1;
					}
					index++;
				}
				if(shorterString.length() != biggerString.length()){
					if(biggerString.equals(s1)) return 1;
					else
					   return -1;	
				}
			}
			else{
				int v1 = Integer.parseInt(""+s1.charAt(0));
				int v2 = Integer.parseInt(""+s2.charAt(0));
				if(v1 > v2)
					return -1;
				else return 1;
			}
			return 0;
		}
		
	}
	public static void main(String args[]){
		int i = 0;
		int a = 0;
		for(int j = 0; j < 10; j++){
			a= i++;		
		}
		System.out.println(a);
		
		Map<String, String> c = new HashMap<String, String>();
		Map<String, String> b = new HashMap<String, String>();
		b.put("a", "A");
		b.put("b", "b");
		b.put("c", "c");
		c.put("b", "d");
		c.put("c", "c");
		
		String[] strings = {"31", "4","45", "46", "34","312", "3333", "3332", };
		String[] strings2 = {"92", "91", "9"};
		String[] strings3 = {"113", "112", "1"};
		Arrays.sort(strings);
		System.out.println(Arrays.toString(strings));
		Arrays.sort(strings2, new LexComparator());
		System.out.println(Arrays.toString(strings2));
		Arrays.sort(strings3);
		System.out.println(Arrays.toString(strings3));
		
	}
}
