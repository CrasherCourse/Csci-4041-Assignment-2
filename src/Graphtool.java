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
		alist.adjacentVetexes(1);
		alist.adjacentVetexes(9);
		alist.adjacentVetexes(20);
	}
}
