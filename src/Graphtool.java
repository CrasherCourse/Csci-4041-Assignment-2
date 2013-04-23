/* 
 * Graphtool.java
 */
// imports
// Code
public class Graphtool
{
	public static void main(String args[])
	{
		AdjacencyList alist;
		
		System.out.println("Ready to start coding!");
		alist = new AdjacencyList("test.txt");
		System.out.println("Made the list!");
		alist.adjacentVetexes(0);
	}
}
