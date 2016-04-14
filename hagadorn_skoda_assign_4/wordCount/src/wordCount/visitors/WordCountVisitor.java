package wordCount.visitors;

import java.io.BufferedWriter;
import java.io.IOException;
import wordCount.treesForStrings.Trie;
import wordCount.treesForStrings.Node;
import wordCount.visitors.TreeProcessingVisitorI;
import wordCount.util.FileProcessorI;

/**
 * Description: A visitor that counts:
 * - the number of words
 * - most frequently used word and its frequency
 * - number of characters in the tree
 * and stores results in a file
 */
public class WordCountVisitor implements TreeProcessingVisitorI{
	private FileProcessorI fp = null;
	// Includes duplicate words
	public int numOfWords;
	public int numOfChars;
	public int highestFrequency;
	public String mostFrequentWord;

	public WordCountVisitor(){
		System.out.println("WordCountVisitor needs an output file name during construction. Exiting.");
		System.exit(1);
	}

	public WordCountVisitor(FileProcessorI fpIn){
		fp = fpIn;
		numOfWords = 0;
		numOfChars = 0;
		highestFrequency = 0;
	}

	public void visit(Trie trie) {
		for(Node n : trie.root.children){
			traverse(trie, n);
		}
		// Store results in output file
		fp.writeLine("The total number of words is: " + numOfWords);
		fp.writeLine("The most frequently used word is: " + mostFrequentWord);
		fp.writeLine("The frequency of the most frequently used word is: " + highestFrequency);
		fp.writeLine("The number of characters (without whitespaces) is: " + numOfChars);
			
	}

	private void traverse(Trie trie, Node curNode) {
		if(curNode.occurrences != 0) {
			numOfWords += curNode.occurrences;
			numOfChars += trie.getWord(curNode).length() * curNode.occurrences;
		}
		if(curNode.occurrences > highestFrequency) {
			highestFrequency = curNode.occurrences;
			mostFrequentWord = trie.getWord(curNode);
		}
		for(int i=0; i<curNode.children.size(); i++) {
			traverse(trie, curNode.children.get(i));
		}
	}
}
