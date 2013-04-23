/*
 * AdjacencyList Class
 */
// imports
import java.io.BufferedReader;
// Code
public class AdjacencyList
{
	public class Node 			// Node class for Adjacency Lists
	{
		int key;
		Node(int value)
		{
			key = value;
		}
	}
	
	int size;
	Node[] nodeList;			// List of all nodes, mostly for holding nodes
//	ArrayList<Node>[] graph;	// The actualy adjacency list
	
	AdjacencyList(String fileName)
	{
		size = 10;
		nodeList = new Node[size];
		for(int i = 0; i < nodeList.length; i++)
		{
			nodeList[i] = new Node(i);
			System.out.println(nodeList[i].key);
		}
	}
	
	@Override public String toString()
	{
		String retval;
		retval = "This is an adjaceny list!";
		return retval;
	}
	
}
