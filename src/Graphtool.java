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
		alist = new AdjacencyList("sample.input");
		while(true)
		{
			arg[0] = -1;
			arg[1] = -1;
			arg[2] = -1;

			System.out.print("> ");			// Get the user's input from cmd line
			command = input.nextLine();
			temp = command.split(" ");
			for(int i = 0; i < temp.length && i < arg.length; i++)		// convert input into ints
			{
				try
				{
					arg[i] = Integer.parseInt(temp[i]);
				}
				catch (Exception e)			// if there are any invalid inputs, use to default handler
				{
					arg[0] = 99;
				}
			}
			
			switch(arg[0])	// Where we determine which choice to execute
			{
				case 1: 	System.out.format("You entered %d\n", arg[0]);
							alist.isSameSet(arg[1], arg[2]);
							break;
				case 2:		System.out.format("You entered %d\n", arg[0]);
							alist.printSet(arg[1]);
							break;
				case 3:		System.out.format("You entered %d\n", arg[0]);
							alist.adjacentVetexes(arg[1]);
							break;
				case 0:		System.out.println("Goodbye!");
							System.exit(0);
				default:	System.out.format("Not a valid option.\n", arg[0]);
			}
		}
	}
}
