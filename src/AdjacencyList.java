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
	public enum Color { WHITE, GRAY, BLACK};
	private class Node 			// Node class for Adjacency Lists
	{
		int key;				// The key of the node
		Color color;
		ArrayList<Node> adj;	// Stores a nodes adjacencies
		Node(int value)
		{
			key = value;						
			adj = new ArrayList<Node>();		
		}
		public int getKey(){  return key; }
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
		catch (IOException e)
		{
			e.printStackTrace();
		}

		
	}
	
	public void adjacentVetexes(int key)
	{
		if(key < 0 || key >= size)			// Make sure node exists
		{
			System.out.format("Node %d does not exist!\n", key);
			return;
		}
		Node[] temp = nodeList[key].adj.toArray(new Node[nodeList[key].adj.size()]);
		if(temp.length == 0)
		{
			System.out.format("Node %d has no adjacent vetexes!\n", key);
			return;
		}
		for(int i = 0; i < temp.length; i++)
		{
			System.out.print(temp[i].key + " ");
		}
		System.out.println("");
	}
	
	public boolean isSameSet(int x, int y)
	{
		for(Node n: nodeList)
		{
			n.color = Color.WHITE;		// set all nodes to white
		}
		return iSS(x, y);
	}
	
	// Recursive DFS used to determine if two nodes are in the same set
	private boolean iSS(int x, int y)
	{
		boolean retval = false;
		if(x == y) return true;				// return true if you are the node
		nodeList[x].color = Color.GRAY;		// Indicate that we have seen this node
		for(Node n: nodeList)
		{
			if(n.color == Color.WHITE && iSS(n.key, y))		// check only nodes that have yet to be checked
			{
				return true;
			}
		}
		nodeList[x].color = Color.BLACK;
		return false;		// no matches were found
	}
	
	@Override public String toString()
	{
		String retval;
		retval = "This is an adjaceny list!";
		return retval;
	}
	
}
