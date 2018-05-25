package com.san.algos.concepts;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class JavaConcepts {

	public static void printP(Person p){
		System.out.println("local : " +p.toString());
	}

	public void testLambda(LamdaData d){
		String s = "result : " + d.getData();
		System.out.println(s);
	}
	public interface LamdaData{
		public String getData();
	}
	public static void main(String args[]){
		JavaConcepts demo = new JavaConcepts();
		List<Person> d = new ArrayList<Person>();
		Person p = new Person("santhsoe", 0);
		d.add(p);
		d.add(new Person("a", 33));
		d.add(new Person("b", 3));
		d.add(new Person("c", 4));
		d.add(new Person("d", 5));
		d.add(new Person("e", 6));
		d.add(new Person("f", 7));
		d.add(new Person("g", 8));
		d.add(new Person("h", 9));
		System.out.println(d.stream().count());
		d.stream().filter(t -> t.age > 5).forEach(JavaConcepts::printP);
		List<Person> filtered = d.stream().filter(t -> t.age > 6).collect(Collectors.toList());
		filtered.forEach((Person a) -> System.out.println("etst" + a.name));
		demo.testLambda(() -> "um hi?");
	}
}
