package treeVisitors.driver;

import treeVisitors.util.Logger;
import treeVisitors.treesForStrings.Trie;
public class Driver{
  public static void main(String args[]) {
    //Command line argument verification
    if(args.length > 4){
      throw new IllegalArgumentException("TreeVisitors requires four"
          + " arguments to be passed in at runtime.\n"
          + "More than three were passed into the execution of this program.\n"
          + "This could be a result of extra default args set in your ant buildfile.\n" 
          + "Ant usage: \n\t"
          + "ant -buildfile src/build.xml run -Darg0=<input file> "
          + "-Darg1=<output file> -Darg2=<Search String> -Darg3=<debug level>\n");
    }
    if(args.length < 4)
    {
      throw new IllegalArgumentException("StudentRecordsBackup requires four"
          + " arguments to be passed in at runtime.\n"
          + "You have passed in less than four arguments. Please check your usage.\n"
          + "If you are passing four arguments and using ant, ensure that your buildfile "
          + "has 4 arguments set in the run command. Otherwise they will silently not be passed in.\n\n"
          + "Ant usage: \n\t"
          + "ant -buildfile src/build.xml run -Darg0=<input file> "
          + "-Darg1=<output file> -Darg2=<Search String> -Darg3=<debug level>\n");
    } 

    //Verify debug level argument 
    int debugLevel = 0;
    try{
      debugLevel = Integer.valueOf(args[3]);
    }catch(NumberFormatException nfe){
      System.err.println("Exception caught parsing argument 4: Debug Level.");
      System.err.println("Stack Trace: " );
      nfe.printStackTrace();
      throw new IllegalArgumentException("Argument 4 must be a string " +
          "that can be parsed into an int, and between 0-4, inclusive.");
    }finally{
      if(debugLevel < 0 || debugLevel > 4){
        System.err.println("Debug level argument passed not in valid range.");
        throw new IllegalArgumentException("Argument 4 must be a string " +
            "that can be parsed into an int, and between 0-4, inclusive.");
      } 
    }
    //Initialize logger
    Logger.setDebugValue(debugLevel);

    Trie t = new Trie();
    t.insert("Hello");
    t.insert("Herro");
    t.insert("No");
    t.insert("Node");
    System.out.println(t.search("Hello"));
    System.out.println(t.search("Herro"));
    System.out.println(t.search("Herr"));
    System.out.println(t.search("Herroo"));
    System.out.println("");
    System.out.println("");
  } // end main(...)

} // end public class Driver
