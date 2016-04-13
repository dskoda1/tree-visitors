package wordCount.treesForStrings;

import java.util.ArrayList;

public class Node {

	int occurences;
	ArrayList<Node> children;
	Node parent;
	char letter;

	public Node(char c) {
		children = new ArrayList<Node>();
		occurences = 0;
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
		this.occurences++;
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
		return "Letter: " + this.letter + "\n" + "Occurs: " + this.occurences
				+ "\n";
	}

}
