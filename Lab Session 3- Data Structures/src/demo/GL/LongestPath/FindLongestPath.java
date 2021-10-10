package demo.GL.LongestPath;

import java.util.ArrayList;

public class FindLongestPath 
{
	static class Node
	{
		Node leftnode;
		Node rightnode;
		int nodeData;
	}
	
	static Node newNode(int nodeData)
	{
		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftnode = null;
		temp.rightnode = null;
		return temp;
	}
	
	public static ArrayList<Integer> findLongestPath(Node root)
	{
		if(root==null)
		{
			ArrayList<Integer> output = new ArrayList<Integer>();
			return output;
		}
		
		ArrayList<Integer> rightNode = findLongestPath(root.rightnode);
		ArrayList<Integer> leftNode = findLongestPath(root.leftnode);
		if(rightNode.size() < leftNode.size())
		{
			leftNode.add(root.nodeData);
		}
		else
		{
			rightNode.add(root.nodeData);
		}
		
		return (leftNode.size() > rightNode.size() ? leftNode : rightNode);
	}

	

	public static void main(String[] args) 
	{
		Node root = newNode(100);
		root.leftnode = newNode(20);
		root.rightnode = newNode(130);
		root.leftnode.leftnode = newNode(10);
		root.leftnode.rightnode = newNode(50);
		root.rightnode.leftnode = newNode(110);
		root.rightnode.rightnode = newNode(140);
		root.leftnode.leftnode.leftnode = newNode(5);
		
		ArrayList<Integer> output = findLongestPath(root);
		int size = output.size();
		System.out.print(output.get(size-1));
		for(int i=size-2; i>=0; i--)
			System.out.print("->" + output.get(i));

	}

}
