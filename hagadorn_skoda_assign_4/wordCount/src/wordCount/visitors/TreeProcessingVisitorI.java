package wordCount.visitors;

import wordCount.treesForStrings.Trie;

/**
 * Description: Visitor interface
 */
public interface TreeProcessingVisitorI {
	public void visit(Trie trie);
}
