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
			}
		}
		return null;
	}
	
	public void occurred(){
		this.occurrences++;
	}

	/**
	 * Add the char passed in as a node.
	 * @param c the char to create a node for
	 */
	public Node addChild(char c) {
		children.add(new Node(c));
		return contains(c);
	}

	@Override
	public String toString() {
		return "Node [occurrences=" + occurrences + ", children=" + children
				+ ", parent=" + parent + ", letter=" + letter + "]";
	}
}
