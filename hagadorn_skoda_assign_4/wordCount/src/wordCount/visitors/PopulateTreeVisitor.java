package wordCount.visitors;

import wordCount.treesForStrings.Trie;
import wordCount.visitors.TreeProcessingVisitorI;
import wordCount.util.FileProcessorI;
import wordCount.util.FileProcessor;
/**
 * Description: A visitor that reads an input file and populates a tree data structure with all the words in the file.
 */
public class PopulateTreeVisitor implements TreeProcessingVisitorI{

	FileProcessorI fp;
	
	public PopulateTreeVisitor(){
		System.out.println("Populate Tree Visitor needs a file name during construction. Exiting.");
		System.exit(1);
	}
	
	public PopulateTreeVisitor(String fileName){
		this.fp = new FileProcessor(fileName);
	}

	/**
	 * http://stackoverflow.com/questions/225337/how-do-i-split-a-string-with-any-whitespace-chars-as-delimiters
	 */
	public void visit(Trie trie) {
		//Iterate through the file and insert each word found.
		String line;
		while((line = this.fp.readLine()) != null){
			//Split the line by whitespace
			String [] words = line.split("\\s+");
			//Insert each of the words here
			for(String w : words){
				trie.insert(w);
			}
		}
		
		fp.close();
	}
}



