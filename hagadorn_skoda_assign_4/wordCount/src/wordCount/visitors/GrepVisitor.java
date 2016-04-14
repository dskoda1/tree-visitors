package wordCount.visitors;

import wordCount.treesForStrings.Trie;
import wordCount.visitors.TreeProcessingVisitorI;
import wordCount.util.FileProcessorI;

/**
 * Description: A visitor for "grep" that finds how many times a search-string
 * occurs in the tree. Search string will be a single string. Must be exact
 * match (case sensitive, not a substring)
 */
public class GrepVisitor implements TreeProcessingVisitorI {
	FileProcessorI fp = null;
	String searchStr;

	public GrepVisitor() {
		System.out.println("GrepVisitor needs a BufferedWriter and search" 
				+ " string during construction. Exiting.");
		System.exit(1);
	}

	public GrepVisitor(FileProcessorI fpIn, String searchStrIn) {
		fp = fpIn;
		searchStr = searchStrIn;
	}

	public void visit(Trie trie) {
		// Make sure the word actually occurs
		if (trie.search(searchStr) != null) {
			// System.out.println("The word '" + searchStr +
			// "' occurs the following times: " +
			// trie.search(searchStr).occurrences);
			fp.writeLine("The word '" + searchStr
					+ "' occurs the following times: "
					+ trie.search(searchStr).occurrences);
		} else {
			// System.out.println("The word '" + searchStr +
			// "' does not exist.");
			fp.writeLine("The word '" + searchStr + "' does not exist.");
		}

	}

	@Override
	public String toString() {
		return "GrepVisitor [searchStr=" + searchStr + "]";
	}
}
