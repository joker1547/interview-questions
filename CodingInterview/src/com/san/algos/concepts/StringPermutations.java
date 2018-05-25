package com.san.algos.concepts;

public class StringPermutations {
	
	public static int findPerms(String s, int n){
		
		if(s.contains("ccc"))
			return 0;
		if(n == 0){
			System.out.println(s);
			return 1;
		}
		int perms = 0;
		perms += findPerms(s+"a", n-1);
		if(!s.contains("b"))
			perms += findPerms(s+"b", n-1);
		perms += findPerms(s+"c", n-1);
			
		return perms;
	}
	
	/***
	 * <p>Given a length n, return the number of strings of length n that can be made up 
	 * of the letters 'a', 'b', and 'c', where there can only be a maximum of 1 'b's and can only have up to two consecutive 'c's
<br>
<br>Example: 
<br>findStrings(3) returns 19
<br>since the possible combinations are: aaa,aab,aac,aba,abc,aca,acb,baa,bac,bca,caa,cab,cac,cba,cbc,acc,bcc,cca,ccb
<br>and the invalid combinations are:
<br>abb,bab,bba,bbb,bbc,bcb,cbb,ccc</p>
	 * @param args
	 */
	public static void main(String args[]){
		int permutations = findPerms("", 4);
		System.out.println(permutations);
	}
}
