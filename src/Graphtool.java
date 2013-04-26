/* 
 * Graphtool.java
 */
// imports
import java.util.Scanner;
// Code
public class Graphtool
{
	public static void main(String args[])
	{
		AdjacencyList alist;
		int select, arg1, arg2;
		
		arg1 = -1;
		arg2 = -1;
		Scanner input = new Scanner(System.in);
		System.out.print("> ");
		select = input.nextInt();
		if(input.hasNextInt()) {arg1 = input.nextInt(); System.out.format("arg1 is %d\n", arg1);}
		
		if(input.hasNextInt()) {arg2 = input.nextInt(); System.out.format("arg2 is %d\n", arg2);}
		
		System.out.format("You entered %d\n", select);
		
		
	/*
		System.out.println("Ready to start coding!");
		alist = new AdjacencyList("test.txt");
		System.out.println("Made the list!");
		alist.adjacentVetexes(0);
		alist.adjacentVetexes(1);
		alist.adjacentVetexes(9);
		alist.adjacentVetexes(20);
	*/
	}
}
