package com.san.algos.concepts;
public class Solution {

    public static boolean isPalindrome(char[] charArray){
//        char[] charArray = number.toCharArray();
        int left = 0; 
        int right = charArray.length-1;
        int mid = charArray.length/2;
        while(left!=right && left <= mid && right>= mid){
            if(charArray[left] != charArray[right]){
                return false;                  
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static void convertoBiggerNumber(char[] numberArray, int tries){
        int left = 0; 
        int mid = numberArray.length/2;
        int right = numberArray.length-1;
        //System.out.println("converting to a bigger number");
        while(left != right && left <= mid && right >= mid && tries > 1){
            if(numberArray[left] != '9') {
                numberArray[left] = '9';
                numberArray[right] = '9';
                tries -=2;                
            }
            left++;
            right--;
           // System.out.println(Arrays.toString(numberArray));
        }
    }
    public static void printPalindrome(int n, int k, String number){
        char[] numberArray = number.toCharArray();
        int left = 0; 
        int mid = n/2;
        int right = number.length()-1;
        int tries = k;
        while(left != right && left <= mid && right >= mid && tries > 0){
            if(numberArray[left] != numberArray[right]){
                int leftDigit = Integer.parseInt(""+numberArray[left]);
                int rightDigit = Integer.parseInt(""+numberArray[right]);
              //  System.out.println( left + " " + right + " |  " + numberArray[left] + " " + numberArray[right]);
//                if(leftDigit != 9 && rightDigit != 9){
//                    numberArray[left] = '9';
//                    numberArray[right] = '9';
//                    tries-=2;
//                }
                if( rightDigit == '9'){
                    numberArray[left] = numberArray[right];
                    tries--;
                }
                else if(leftDigit == '9'){
                    numberArray[right] = numberArray[left];
                    tries--;
                }
                else if(leftDigit > rightDigit){
            		numberArray[right] = numberArray[left];
                    tries--;            	
                }
                else if(rightDigit > leftDigit){
                	numberArray[left] = numberArray[right];
                    tries--;
                }
            }
            left++;
            right--;
        }
      //  System.out.println(tries);
      //  System.out.println(Arrays.toString(numberArray));
        if(tries == 1 ){
            if(numberArray.length == 1){
                numberArray[0] = '9';
            }
            else{
                if(numberArray.length%2 == 1){
                    numberArray[mid] = '9'; 
                }
            }    
        }    
        if(isPalindrome(numberArray)){    
        	if(tries > 1){
        		convertoBiggerNumber(numberArray, tries);
        	}
            String newNumber = new String(numberArray);
            System.out.println(newNumber);   
        }                        
        else
            System.out.println(-1); 
    }
    
    public static void characterSort(String string){
    	char[] arr = new char[26];
    	for(int i = 0; i < string.length(); i++){
    		//System.out.print(string.charAt(i) + " : ");
    		//System.out.println( string.charAt(i)-'a');
    		arr[string.charAt(i)-'a']++;
    	}
    	String s = new String(arr);
    	System.out.println(s);
    }
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int k = in.nextInt();
//        String number = in.next();
//        printPalindrome(n, k, number);
    	characterSort("santhose");
    }
}
