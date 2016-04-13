package wordCount.driver;

import wordCount.util.Logger;
import wordCount.treesForStrings.Trie;
public class Driver{
  public static void main(String args[]) {
    //Command line argument verification
	//4 arguments: input file, output file, search string, debug level
    validateArgLength(args.length, 4);

    //Verify string arguments or pass them directly to file processor here
    
    //Verify debug level argument 
    int debugLevel = validateNumParam(args[3], 0, 4, "Exception caught parsing argument 4: Debug Level.",
        "Argument 4 must be a string that can be parsed into an int, and between 0-4, inclusive.");
    //Initialize logger
    Logger.setDebugValue(debugLevel);

    //Program to an interface here?
    Trie t = new Trie();
    t.insert("Hello");
    t.insert("Herro");
    t.insert("herring");
    t.insert("Hey");
    t.insert("No");
    t.insert("Node");
    System.out.println(t.getWord(t.search("Hello")));
    //System.out.println(t.search("Herro"));
    //System.out.println(t.search("Herr"));
    //System.out.println(t.search("Herroo"));
    for(String n : t.getAllWords()){
    	System.out.println(n);
    }
    
    
  } // end main(...)

  private static void validateArgLength(int argsLength, int expectedLength)
    throws IllegalArgumentException {
      if(argsLength > expectedLength){
        throw new IllegalArgumentException("wordCount requires four"
            + " arguments to be passed in at runtime.\n"
            + "More than three were passed into the execution of this program.\n"
            + "This could be a result of extra default args set in your ant buildfile.\n" 
            + "Ant usage: \n\t"
            + "ant -buildfile src/build.xml run -Darg0=<input file> "
            + "-Darg1=<output file> -Darg2=<Search String> -Darg3=<debug level>\n");
      }
      if(argsLength < expectedLength)
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
    }
  private static int validateNumParam(String param, int min, int max, 
      String exCaught, String exMessage) throws IllegalArgumentException {
    int retVal = 0;
    try{
      retVal = Integer.valueOf(param);
    }catch(NumberFormatException nfe){
      System.err.println(exCaught);
      System.err.println("Stack Trace: " );
      nfe.printStackTrace();
      throw new IllegalArgumentException(exMessage);
    }finally{
      if(retVal < min || retVal > max){
        System.err.println("Argument passed not in valid range.");
        throw new IllegalArgumentException(exMessage);
      } 
    }
    return retVal;
  }

} // end public class Driver
