package wordCount.visitors;

import wordCount.treesForStrings.Trie;
import wordCount.visitors.TreeProcessingVisitorI;
/**
 * Description: A visitor for "grep" that finds how many times a search-string occurs in the tree.
 * Search string will be a single string.
 * Must be exact match (case sensitive, not a substring)
 */
public class GrepVisitor implements TreeProcessingVisitorI{
	public void visit(Trie trie) {
		// TODO
	}
}
