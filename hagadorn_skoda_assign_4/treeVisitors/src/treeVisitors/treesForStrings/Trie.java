package treeVisitors.treesForStrings;


import treeVisitors.treesForStrings.Node;

public class Trie{

  private Node root;

  public Trie(){
    root = new Node(' ');
  }
  /*
     public boolean search(String searchQuery){

     Node temp = root;
     for(char c : searchQuery.toCharArray()){
     if(temp.contains(c) != null){
     temp = temp.contains(c);
     }else{
     return false;
     }

     }
     Now see if were at a leaf
     if(temp.leaf == true){
     return true;
     }else{
     return false;
     }
     }
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
    //Now see if were at a leaf
    if(temp.leaf == true){
      return temp;
    }else{
      return null;
    }
  }

  public void insert(String insertMe){

    Node temp = null, child = null;
    //The node occurs in the tree, so just increment its count
    if((temp = search(insertMe)) != null){
      temp.occurences++;
      return;
    }

    temp = root;
    for(char c : insertMe.toCharArray()){
      child = temp.contains(c);
      //child doesnt exist, add it in
      if(child == null){
        temp.addChild(c);
        temp = temp.contains(c);
      }else{
        temp = child;
      }
      temp.occurences++;
    }
    temp.leaf = true;
  }



}
