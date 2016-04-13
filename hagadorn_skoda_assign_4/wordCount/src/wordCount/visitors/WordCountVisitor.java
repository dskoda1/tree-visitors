package wordCount.visitors;

import wordCount.treesForStrings.Trie;

/**
 * Description: A visitor that counts:
 * - the number of words
 * - most frequently used word and its frequency
 * - number of characters in the tree
 * and stores results in a file
 */
public class WordCountVisitor implements TreeProcessingVisitorI{
	public void visit(Trie trie) {
		// TODO
		// Note: Can perform data gathering during one recursive traversal of the tree
		// WordCountVisitor can have members for word/char count, etc.
	}
}
