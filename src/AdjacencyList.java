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
		public int getKey(){  return key; }
	}
	
	int size;					// number of nodes total
	Node[] nodeList;			// List of all nodes used for reference disjoint nodes
	ArrayList[] adjList;		// The actualy adjacency list
	
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
			adjList = new ArrayList[size];
		
			for(int i = 0; i < nodeList.length; i++)
			{
				nodeList[i] = new Node(i);
			}
			for(int i = 0; i < adjList.length; i++)
			{
				adjList[i] = new ArrayList<Node>();
			}
			
			while(f.hasNextInt())
			{
				index = f.nextInt();
				adjList[index].add(nodeList[f.nextInt()]);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		
	}
	
	public void adjacentVetexes(int key)
	{
		Node temp;
		if(key > 0 || key >= size) return;
		for(int i = 0; i < adjList[i].size(); i++)
		{
			temp = (Node) adjList[key].get(i);
			System.out.print(temp.getKey() + " ");
		}
	}
	
	public void print()
	{
		for(int i = 0; i < adjList.length; i++)
		{
			//for(int j = 0; j < ad
		}
	}
	
	@Override public String toString()
	{
		String retval;
		retval = "This is an adjaceny list!";
		return retval;
	}
	
}
