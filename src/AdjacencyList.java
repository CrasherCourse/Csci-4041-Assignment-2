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
		ArrayList<Node> adj;
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
		if(key > 0 || key >= size) return;
		Node[] temp = nodeList[key].adj.toArray(new Node[nodeList[key].adj.size()]);
		for(int i = 0; i < temp.length; i++)
		{
			System.out.print(temp[i].key + " ");
		}
		System.out.println("");
	}
	
	public void print()
	{

	}
	
	@Override public String toString()
	{
		String retval;
		retval = "This is an adjaceny list!";
		return retval;
	}
	
}
