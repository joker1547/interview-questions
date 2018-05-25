package com.san.algos.concepts;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StringRelatedQuestions {

	public static int[] myArray = new int[10];
	public int[] mySortedArray = new int[10];
	public static int[] uniqueArray = new int[3];
	public void init(){
		for(int i = 0; i < myArray.length; i++){
			myArray[i] = (int)( Math.random() * 10 ) +1;			
		}
		for(int i = 0; i < uniqueArray.length;i++){
			uniqueArray[i] = i+1;
		}
	}
	
	public void insertionSort(){ 
		
		for(int i = 0; i < myArray.length; i++){			
			for(int j = 0; j < i; j++){   
				if(myArray[i] < myArray[j]){ 
					//swap
					int temp = myArray[j];
					myArray[j] = myArray[i];
					myArray[i] = temp;
				}
			}
		}
	}
	
	public void selectionSort(){
		for(int i = 0; i < myArray.length; i++){
			int min = myArray[i];
			int index = i;
			for( int j = i+1; j < myArray.length; j++){
				if(myArray[j] < min){
					index = j;
					min = myArray[j];
				}
			}
			int temp = myArray[i];
			myArray[i] = myArray[index];
			myArray[index] = temp;
		}
	}
	
	
	public void printAnagrams(String word, List<String>anagrams){
		if(!anagrams.contains(word))
			anagrams.add(word);
		for(int i = 0; i < word.length(); i++){
			String left = "";
			if(i-1 >= 0)
				left = word.substring(0, i);
			String right = "";
			if( i+1 <= word.length() - 1)
				right =  word.substring(i+1);
			String combo = left + right;
			//anagrams.add(""+word.charAt(i)+ combo);
			for(int j = 0; j < combo.length(); j++){
				String newWord = combo.substring(0, j);				
				newWord += word.charAt(i);
				if(j <= combo.length()-1)
					newWord += combo.substring(j);
				if(!anagrams.contains(newWord)){
					anagrams.add(newWord);
					printAnagrams(newWord, anagrams);	
				}					
			}
			if(!anagrams.contains(combo + word.charAt(i))){
				String newWord = combo + word.charAt(i);
				anagrams.add(newWord);
				printAnagrams(newWord, anagrams);	
			}				
		}
	}
	
	public void mergeSort(int[] array, int left, int right){
		if(left >= right)
			return;
		int middle = (right + left ) / 2;
	    //System.out.println( middle  );
		mergeSort( array, left, middle);
		mergeSort(array, middle + 1, right);
		merge(array, left, middle, right);
		
	}
	
	public void merge(int[] array, int left, int middle, int right){
		int [] helper = new int[array.length];
		for(int i = left; i <= right; i++){
			helper[i] = array[i];			
		}
		int leftIndex = left;
		int rightIndex = middle+1;
		int arrayIndex = left;
		
		while(leftIndex <= middle && rightIndex <= right){			
			if(helper[leftIndex] < helper[rightIndex]){
				array[arrayIndex] = helper[leftIndex];
				leftIndex++;
			}
			else{
				array[arrayIndex] = helper[rightIndex];
				rightIndex++;
			}
			arrayIndex++;
		}
		
		while(leftIndex <= middle){
			array[arrayIndex] = helper[leftIndex];
			leftIndex++;
			arrayIndex++;
		}
		//System.out.println(Arrays.toString(array));
		/**
		while(rightIndex < right){
			array[arrayIndex] = helper[rightIndex];
			rightIndex++;
			arrayIndex++;
		}**/
		
	
	}
	
	public void printAnagrams(String prefix, String word, List<String>anagrams){
		if(word.length() == 0){
			if(!anagrams.contains(prefix))
				anagrams.add(prefix);
		}else{
			for(int i = 0; i < word.length(); i++){
				printAnagrams( prefix + word.charAt(i) , word.substring(0, i) + word.substring(i+1, word.length()), anagrams);
				
			}
		}
	}
	public boolean isPalindrome(String word){
		char[] charArray = word.toCharArray();
		int left = 0;
		int right = charArray.length -1;
		int mid = charArray.length /2;
		while(left != right && left <= mid && right >= mid ){
			
			if(charArray[left] != charArray[right]){
				return false;
			}
		//	System.out.println(left + " - " + right);
			left++;
			right--;
		}
		//Integer.parse
		return true;
	}
	
	public String[] isPalindromePair(String[] words){
		String[] result = new String[words.length*words.length];
		int count = 0;
		for(int i = 0; i < words.length; i++){
			for(int j = 0; j < words.length; j++ ){
				if(i != j){
					String newWord = words[i] + words[j];
					if(this.isPalindrome(newWord)){
						result[count++] = i + " - " + j;
					}
				}
			}
		}
		return result;
	}
	
	public static boolean validString(String t){
        char[] chars = t.toCharArray();
        for(int i = 0;  i < chars.length-2; i++){
            if(chars[i] == chars[i+1] || chars[i] != chars[i+2]){
                System.out.println(t);
                return false;   
            }
                
        }
        return true;
    }
	
	public void printAllSubArrays(int[] a){
		if(a.length <= 0)
			return;
		int[] subArray = new int[a.length - 1];
		int index = 0;
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		for(int i = 0; i < a.length; i++){
			
					
			for(int m = 0; m < i; m++){
				subArray[index] = a[m];
				index++;
			}
			for(int m = i+1; m < a.length; m++ ){
				subArray[index] = a[m];
				index++;
			}
			printAllSubArrays(subArray);
			index = 0;
		}
		
	}
	
	public static void checkDupeString(){
		Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        if(s.length() <= 1)
            System.out.println(0);
        else if(validString(s))
            System.out.println(s.length());
        else{
            Set uniqueChars = new HashSet();
            Set<String> validT = new HashSet();
            char[] stringArray = s.toCharArray();
            for(int i = 0; i < stringArray.length; i++){
                uniqueChars.add(""+stringArray[i]);
            }
            
            Iterator<String> it = uniqueChars.iterator();
            while(it.hasNext()){
                String c = it.next();
                String reducedString = s.replaceAll(c, "");
                //System.out.println(reducedString);
                if(validString(reducedString)){
                    validT.add(reducedString);
                }
                Iterator<String> it2 = uniqueChars.iterator();
                while(it2.hasNext()){
                    reducedString = reducedString.replaceAll(it2.next(), "");
                    //System.out.println(reducedString);                    
                    if(validString(reducedString)){
                        validT.add(reducedString);
                    }
                }
            }
            Iterator<String> it2 = validT.iterator();
            int max = 0;
            while(it2.hasNext()){
                String b = it2.next();
                System.out.println(b);
               // System.out.println(b.length());
                
                int length = b.length();
                if(length > max)
                    max = length;
            }
                
            System.out.println(max);
        }
	}
	
	/**
	 * 
	 * print all substring combinations of a string
	 */
	public void getSubstringCombos(String s, List<String> combos){
		if(s.length() <= 0){
			return;
		}
		if(combos.contains(s))
			return;
		String sub = "";
		for(int i = 0; i < s.length(); i++){
			sub += s.substring(0, i);
			sub += s.substring(i+1);
			System.out.println(sub);			
			getSubstringCombos(sub, combos);
			combos.add(sub);
			sub = "";
		}			
	}
	
	public static void main(String args[]){
		String s = "ABCD";
		StringRelatedQuestions solution = new StringRelatedQuestions();
//		List<String> anagrams = new ArrayList<String>();
//		solution.printAnagrams(s, anagrams);
//		System.out.println(anagrams.size());
//		
//		System.out.println("-------------------");
//		anagrams = new ArrayList<String>();
//		solution.printAnagrams("", s, anagrams);
//		System.out.println(anagrams.size());
//		
//		solution.init();
//		System.out.println(Arrays.toString(solution.myArray));
//		//solution.insertionSort();
//		//solution.selectionSort();
//		solution.mergeSort(solution.myArray, 0, solution.myArray.length-1);
//		System.out.println(Arrays.toString(solution.myArray));
//	//	String [] words = {"abcd", "dcba", "lls", "s", "sssll"};
//	//	String[] palindromePairs = solution.isPalindromePair(words);
//	//	System.out.println(Arrays.toString(palindromePairs));
//		//solution.printAllSubArrays(uniqueArray);
//		solution.checkDupeString();
		
		solution.getSubstringCombos("abcdefgh", new ArrayList<String>());
	}
	//0 1 2 4 5 6 7
	//0 1 2 3 4 5 6
}
