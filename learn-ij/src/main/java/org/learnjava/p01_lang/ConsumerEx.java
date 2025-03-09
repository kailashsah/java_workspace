package org.learnjava.p01_lang;

import java.util.ArrayList;
import java.util.function.Consumer;

/*
	1. The Consumer Interface is a part of the java.util.function package.
	2. It represents a function which takes in one argument and produces a result. However these kind of functions don’t return any value.
	
	3. The lambda expression assigned to an object of Consumer type is used to define its accept() which eventually applies the given operation on its argument. Consumers are useful when it not needed to return any value as they are expected to operate via side-effects.  
	
*/
public class ConsumerEx {

	public void useAccept() {

		Consumer<Integer> display = a -> System.out.println(a);

		// Implement display using accept()
		display.accept(10);
		// display(10);//error - The method display(int) is undefined for the
		// type Check

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(5);

		Consumer<Integer> method = (n) -> {
			System.out.println(n);
		};

		// print arraylist members
		numbers.forEach(method);
		System.out.println("here ended");
	}

	public void useAndThen() {
		Consumer<Integer> consumer1 = a -> System.out.println("consumer1: " + a);
		Consumer<Integer> consumer2 = a -> System.out.println("consumer2: " + a);

		// Using andThen()
		consumer1.andThen(consumer2).accept(10);
	}

	public static void main(String[] args) {
		ConsumerEx consumer = new ConsumerEx();
		consumer.useAccept();
		consumer.useAndThen();
		//new ConsumerEx().run();

	}

}
