/*
 * AdjacencyList Class
 */
// imports
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
// Code
public class AdjacencyList
{
	private class Node 			// Node class for Adjacency Lists
	{
		int key;
		Node(int value)
		{
			key = value;
		}
	}
	
	int size;					// number of nodes total
	Node[] nodeList;			// List of all nodes used for reference disjoint nodes
	ArrayList[] adjList;		// The actualy adjacency list
	
	AdjacencyList(String fileName)
	{	
		try (Scanner f = new Scanner(new File(fileName)))
		{
			if(f.hasNextInt())		// will not work if file is not well defined!
			{
				this.size = f.nextInt();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		nodeList = new Node[size];
		adjList = new ArrayList[size];
		
		for(int i = 0; i < nodeList.length; i++)
		{
			nodeList[i] = new Node(i);
		}
		for(int i = 0; i < adjList.length; i++)
		{
			adjList[i] = new ArrayList<Node>();
		}
		
	}
	
	@Override public String toString()
	{
		String retval;
		retval = "This is an adjaceny list!";
		return retval;
	}
	
}
