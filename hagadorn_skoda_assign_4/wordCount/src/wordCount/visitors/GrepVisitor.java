package wordCount.visitors;

import java.io.BufferedWriter;
import java.io.IOException;

import wordCount.treesForStrings.Trie;
import wordCount.visitors.TreeProcessingVisitorI;

/**
 * Description: A visitor for "grep" that finds how many times a search-string occurs in the tree.
 * Search string will be a single string.
 * Must be exact match (case sensitive, not a substring)
 */
public class GrepVisitor implements TreeProcessingVisitorI{
	BufferedWriter br = null;
	String searchStr;

	public GrepVisitor(){
		System.out.println("GrepVisitor needs a BufferedWriter and search string during construction. Exiting.");
		System.exit(1);
	}

	public GrepVisitor(BufferedWriter brIn, String searchStrIn){
		br = brIn;
		searchStr = searchStrIn;
	}

	public void visit(Trie trie) {
		try {
			br.write("The word '" + searchStr + "' occurs the following times: " + trie.search(searchStr).occurrences);
			br.newLine();
		} catch (IOException e) {
			System.out.println("Unable to write to output file.");
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public String toString() {
		return "GrepVisitor [searchStr=" + searchStr + "]";
	}
}
