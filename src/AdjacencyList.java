/*
 * AdjacencyList Class
 */
// imports
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.lang.Comparable;
import java.util.Collections;
// Code

public class AdjacencyList
{
	public enum Color { WHITE, GRAY, BLACK};				// Colors to true emulate DFS
	private class Node implements Comparable<Node>			// Node class for Adjacency Lists
	{
		int key;				// The key of the node
		Color color;			// Node color
		ArrayList<Node> adj;	// Stores a nodes adjacencies
		Node(int value)			// Constructor
		{
			key = value;						
			adj = new ArrayList<Node>();		
		}
		public int getKey(){  return key; }		// get node's key
		@Override
		public int compareTo(Node other)		// for sorting
		{
			if(this.key < other.key) return -1;
			else if(other.key == this.key) return 0;
			else return 1;
		}
	}
	
	int size;					// number of nodes total
	Node[] nodeList;			// List of all nodes used for reference disjoint nodes

	
	AdjacencyList(String fileName)
	{	
		int index;
		try (Scanner f = new Scanner(new File(fileName)))
		{
			if(f.hasNextInt())		// will not work if file is not well defined!
			{
				this.size = f.nextInt();
			}
			nodeList = new Node[size];
		
			for(int i = 0; i < nodeList.length; i++)	// make the list of nodes
			{
				nodeList[i] = new Node(i);
			}

			while(f.hasNextInt())						// add adjacenies to the list
			{
				int index1 = f.nextInt();
				int index2 = f.nextInt();
				nodeList[index1].adj.add(nodeList[index2]);		// make adjacencies both ways since graph is undirected
				nodeList[index2].adj.add(nodeList[index1]);				
			}
		}
		catch (IOException e)		// Quit the program if the input text is non-existent
		{
			e.printStackTrace();
		}

		
	}
	
	// check if key is vaild, sends appropriate response if not
	public boolean invalidKey(int key)
	{
		if(key == -1)	// -1 means no number argument was given
		{
			System.out.println("Not enough arguments");
			return true;
		}
		if(key < 0 || key >= this.size)		// keys should range from 0 to size -1
		{
			System.out.printf("Node %d does not exist\n", key);
			return true;
		}
		return false;
	}
// ------------------------------------------------------------------------------------------------
	// Choice 1: finds out if two nodes are in the same set
	public void isSameSet(int x, int y)
	{
		if(invalidKey(x) || invalidKey(y)) return;
		for(Node n: nodeList)
		{
			n.color = Color.WHITE;		// set all nodes to white
		}
		System.out.println(iSS(x, y));	// print out true/false
		return;
	}
	
	// Recursive DFS used to determine if two nodes are in the same set
	private boolean iSS(int x, int y)
	{
		if(x == y) return true;				// return true if you are the node
		nodeList[x].color = Color.GRAY;		// Indicate that we have seen this node
		for(Node n: nodeList[x].adj)
		{
			if(n.color == Color.WHITE && iSS(n.key, y))		// check only nodes that have yet to be checked
			{
				return true;
			}
		}
		nodeList[x].color = Color.BLACK;
		return false;		// no matches were found
	}
// ------------------------------------------------------------------------------------------------
	// Choice 2: Prints out a list of vertexes in the same set in a sorted fashion
	public void printSet(int key)
	{
		if(invalidKey(key)) return;
		ArrayList<Node> q = new ArrayList<Node>();
		for(Node n: nodeList)
		{
			n.color = Color.WHITE;		// set all nodes to white
		}
		q = getSet(nodeList[key]);		// Make a set of all connected nodes
		q.remove(nodeList[key]);			// Remove key node from set
		Collections.sort(q);			// Sort the list of nodes
		System.out.printf("%s ", key);	// Print out the starting key
		for(Node x: q)					// Print out the rest in ascending order
		{
			System.out.printf("%s ",x.key);
		}
		System.out.println("");			// Make a new Line
	}
	
	// reusive DFS gets a list of all currently white nodes
	private ArrayList<Node> getSet(Node node)
	{
		ArrayList<Node> retval = new ArrayList<Node>();
		retval.add(node);
		node.color = Color.GRAY;
		for(Node n: node.adj)				// check all adjacent nodes
		{
			if(n.color == Color.WHITE)
			{
				retval.addAll(getSet(n));	// adds all connecting nodes for a nearby WHITE node
			}
		}
		return retval;
	}
// ------------------------------------------------------------------------------------------------
	// Choice 3: prints out adjacent vertexes
	public void adjacentVetexes(int key)
	{
		if(invalidKey(key)) return;			// Check if key is valid
		Node temp = nodeList[key];			
		System.out.printf("%d ", key);		// Print the user selected Node
		Collections.sort(temp.adj);			// Sort node's adjacency list
		for(Node n: temp.adj)				// print out adjacency list
		{
			System.out.printf("%d ", n.key);
		}
		System.out.println("");
	}
// ------------------------------------------------------------------------------------------------
}
