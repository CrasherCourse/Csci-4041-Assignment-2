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
		String command;
		String[] temp;
		int[] arg = new int[3];
		Scanner input = new Scanner(System.in);
		
		// Create the adjacency list
		alist = new AdjacencyList("test.txt");
		while(true)
		{
			arg[0] = -1;
			arg[1] = -1;
			arg[2] = -1;

			System.out.print("> ");
			command = input.nextLine();
			temp = command.split(" ");
			for(int i = 0; i < temp.length && i < arg.length; i++)
			{
				System.out.println(temp[i]);
				try
				{
					arg[i] = Integer.parseInt(temp[i]);
				}
				catch (Exception e)
				{
					arg[0] = 99;
				}
			}
			
			switch(arg[0])
			{
				case 1: 	System.out.format("You entered %d\n", arg[0]);
							System.out.println(alist.isSameSet(arg[1], arg[2]));
				case 2:		System.out.format("You entered %d\n", arg[0]);
							break;
				case 3:		System.out.format("You entered %d\n", arg[0]);
							if(arg[1] != -1) alist.adjacentVetexes(arg[1]);
							break;
				case 0:		System.out.println("Goodbye!");
							System.exit(0);
				default:	System.out.format("Not a valid option.\n", arg[0]);
			}
		}
		
	/*
		System.out.println("Ready to start coding!");

		System.out.println("Made the list!");
		alist.adjacentVetexes(0);
		alist.adjacentVetexes(1);
		alist.adjacentVetexes(9);
		alist.adjacentVetexes(20);
	*/
	}
}
