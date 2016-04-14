package wordCount.visitors;

import java.io.BufferedWriter;
import java.io.IOException;
import wordCount.treesForStrings.Trie;
import wordCount.visitors.TreeProcessingVisitorI;

/**
 * Description: A visitor that counts:
 * - the number of words
 * - most frequently used word and its frequency
 * - number of characters in the tree
 * and stores results in a file
 */
public class WordCountVisitor implements TreeProcessingVisitorI{
	private BufferedWriter br = null;
	// Includes duplicate words
	public int numOfWords;
	public int numOfChars;
	public int highestFrequency;
	public String mostFrequentWord;

	public WordCountVisitor(){
		System.out.println("WordCountVisitor needs an output file name during construction. Exiting.");
		System.exit(1);
	}

	public WordCountVisitor(BufferedWriter brIn){
		br = brIn;
		numOfWords = 0;
		numOfChars = 0;
		highestFrequency = 0;
	}

	public void visit(Trie trie) {
		traverse(trie, trie.root);
		// Store results in output file
		try {
			br.write("The total number of words is: " + numOfWords);
			br.newLine();
			br.write("The most frequently used word is: " + mostFrequentWord);
			br.newLine();
			br.write("The frequency of the most frequently used word is: " + highestFrequency);
			br.newLine();
			br.write("The number of characters (without whitespaces) is: " + numOfChars);
			br.newLine();
		} catch (IOException e) {
			System.out.println("Unable to write to output file.");
			e.printStackTrace();
			System.exit(1);
		}
	}

	private void traverse(Trie trie, wordCount.treesForStrings.Node curNode) {
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
