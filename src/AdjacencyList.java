/*
 * AdjacencyList Class
 */
package Assignment2;

import <ArrayList>

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
	
	int size;
	Node[] nodeList;			// List of all nodes, mostly for holding nodes
	ArrayList<Node>[] graph;	// The actualy adjacency list
	
	AdjacencyList(String fileName)
	{
	}
	
}
