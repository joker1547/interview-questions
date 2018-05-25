package com.san.algos.concepts;
public class Person{
		String name;
		int age;
		public Person(String n, int a){
			name = n;
			age = a;
		}
		public String toString(){
			return name + " - "+age;
		}
}