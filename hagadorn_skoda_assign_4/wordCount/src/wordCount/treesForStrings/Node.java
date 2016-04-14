package wordCount.treesForStrings;

import java.util.ArrayList;

public class Node {

	public int occurrences;
	public ArrayList<Node> children;
	public Node parent;
	public char letter;

	public Node(char c) {
		children = new ArrayList<Node>();
		occurrences = 0;
		letter = c;
		parent = null;
	}

	/**
	 * Check if this node has a matching child for
	 * the character requested.
	 * @param c
	 * @return The child node that matches, or null
	 */
	public Node contains(char c) {
		if (children != null) {
			for (Node child : children) {
				if (child.letter == c) {
					return child;
				}
				//TODO short circuit if its no longer possible
				//for the node to exist. Was getting null ptrs
				//if(child.letter > c) return null; ??
			}
		}
		return null;
	}
	
	public void occurred(){
		this.occurrences++;
	}

	/**
	 * Add the char passed in as a node. 
	 * Maintain alphabetical order.
	 * @param c the char to create a node for
	 */
	public Node addChild(char c) {
		//Find the index at which c is < the current childs letter
		if(children.size() > 0){
			int i = 0;
			for(i = 0; i < children.size() && children.get(i).letter < c; ++i){}
			if(i == children.size()){
				//insert at end
				children.add(new Node(c));
				return children.get(children.size() - 1);
			}else{
				//insert at i index
				children.add(i, new Node(c));
				return children.get(i);
			}
			
		}else{
			children.add(new Node(c));
			return children.get(0);
		}
	}

	@Override
	public String toString() {
		return "Node [occurrences=" + occurrences + ", children=" + children
				+ ", parent=" + parent + ", letter=" + letter + "]";
	}
}
