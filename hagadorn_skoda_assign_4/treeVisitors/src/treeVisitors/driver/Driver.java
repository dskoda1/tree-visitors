package treeVisitors.driver;

import treeVisitors.util.Logger;

public class Driver{
  public static void main(String args[]) {
    //Command line argument verification
    if(args.length > 3){
      throw new IllegalArgumentException("StudentRecordsBackup requires three"
          + " arguments to be passed in at runtime.\n"
          + "More than three were passed into the execution of this program.\n"
          + "This could be a result of extra default args set in your ant buildfile.\n" 
          + "Ant usage: \n\t"
          + "ant -buildfile src/build.xml run -Darg0=<input file> "
          + "-Darg1=<update value> -Darg2=<debug level>\n");
    }
    if(args.length < 3)
    {
      throw new IllegalArgumentException("StudentRecordsBackup requires three"
          + " arguments to be passed in at runtime.\n"
          + "You have passed in less than three arguments. Please check your usage.\n"
          + "If you are passing three arguments and using ant, ensure that your buildfile "
          + "has 3 arguments set in the run command. Otherwise they will silently not be passed in.\n\n"
          + "Ant usage: \n\t"
          + "ant -buildfile src/build.xml run -Darg0=<input file> "
          + "-Darg1=<update value> -Darg2=<debug level>\n\n");
    } 

    String fileName = args[0];
    int updateValue = 0, debugLevel = 0;
    //Verify number of threads argument
    try{
      updateValue = Integer.valueOf(args[1]);
    }catch(NumberFormatException nfe){
      System.err.println("Exception caught parsing argument 2: Update Value.");
      System.err.println("Stack Trace: " );
      nfe.printStackTrace();
      throw new IllegalArgumentException("Argument 2 must be a string " +
          "that can be parsed into an int, and not cause any integer overflow.");
    }finally{
    }
    //Verify debug level argument
    try{
      debugLevel = Integer.valueOf(args[2]);
    }catch(NumberFormatException nfe){
      System.err.println("Exception caught parsing argument 3: Debug Level.");
      System.err.println("Stack Trace: " );
      nfe.printStackTrace();
      throw new IllegalArgumentException("Argument 3 must be a string " +
          "that can be parsed into an int, and between 0-4, inclusive.");
    }finally{
      if(debugLevel < 0 || debugLevel > 4){
        System.err.println("Debug level argument passed not in valid range.");
        throw new IllegalArgumentException("Argument 3 must be a string " +
            "that can be parsed into an int, and between 0-4, inclusive.");
      } 
    }
    //Initialize logger
    Logger.setDebugValue(debugLevel);


  } // end main(...)

} // end public class Driver
