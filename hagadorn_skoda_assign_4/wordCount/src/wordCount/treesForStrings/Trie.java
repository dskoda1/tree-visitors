package wordCount.treesForStrings;


import wordCount.treesForStrings.Node;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.LinkedList;
public class Trie{

  private Node root;

  public Trie(){
    root = new Node(' ');
  }

  /**
   * Searches the trie for a given word.
   * @param searchQuery the word being searched for
   * @return the Node 
   */
  public Node search(String searchQuery){

    Node temp = root;
    for(char c : searchQuery.toCharArray()){
      if(temp.contains(c) != null){
        temp = temp.contains(c);
      }else{
        return null;
      }
    }
    
    if(temp.occurences > 0){
    	return temp;
    }else{
    	return null;
    }
  }

  /**
   * Insert the given string.
   * This first checks if the word already occurs, and if it
   * does then increments its count. If not, it iteratively
   * goes through the characters in the new word and attempts
   * to append it to the tree through either existing words
   * that share a similar prefix, or creating new nodes.
   * @param insertMe the word to insert
   */
  public void insert(String insertMe){
    Node temp = null, child = null, newChild = null;
    //The node occurs in the tree, so just increment its count
    if((temp = search(insertMe)) != null){
      temp.occurred();
      return;
    }

    temp = root;
    for(char c : insertMe.toCharArray()){
      child = temp.contains(c);
      //child doesnt exist, add it in
      if(child == null){
        newChild = temp.addChild(c);
        newChild.parent = temp;
        temp = newChild;
      }else{
        temp = child;
      }
    }
    temp.occurred();
  }
  /**
   * Returns an unsorted arraylist of all the words
   * in the trie. ****We could optimize insert to store the 
   * words alphabetically and actually improve insert time,
   * along with keep the words sorted in memory.**
   * @return an array list of all the words
   */
  public ArrayList<String> getAllWords(){
	  Node temp = root;
	  LinkedList<Node> nodes = new LinkedList<Node>();
	  ArrayList<String> words = new ArrayList<String>();
	  for(Node n : temp.children){
		  nodes.add(n);
	  }
	  while(nodes.size() > 0){
		  temp = nodes.remove();
		  if(temp.occurences > 0){
			  words.add(getWord(temp));
		  }
		  for(Node n : temp.children){
			  nodes.add(n);
		  }
	  }
	  return words;
	  
  }
  
  /**
   * Given a node, traverses the parent links and
   * constructs the word ending at that node
   * @param n the node for which a word was requested.
   * @return a String the word
   */
  public String getWord(Node n){
	  if(n == null){
		  return "Word doesn't exist";
	  }
	  StringBuilder sb = new StringBuilder();
	  while(n.letter != ' '){
		  sb.insert(0, n.letter);
		  n = n.parent;
	  }
	  return sb.toString();
  }
  
}
