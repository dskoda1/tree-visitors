package treeVisitors.treesForStrings;

import java.util.ArrayList;

public class Node{

  boolean leaf;
  int occurences;
  private ArrayList<Node> children;
  char letter;


  public Node(char c){
    children = new ArrayList<Node>();
    occurences = 0;
    leaf = false;
    letter = c;
  }

  public Node contains(char c){
    if(children != null){
      for(Node child : children){
        if(child.letter == c){
          return child;
        }
      }
    }
    return null;
  }

  public void addChild(char c){
    children.add(new Node(c));
  } 

  @Override
  public String toString(){
    return "Letter: " + this.letter + "\n" + 
          "Occurs: " + this.occurences + "\n" +
          "Leaf: " + this.leaf + "\n";
  }

}
