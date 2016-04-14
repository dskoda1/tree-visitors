package wordCount.driver;

import wordCount.util.FileProcessor;
import wordCount.util.FileProcessorI;
import wordCount.visitors.GrepVisitor;
import wordCount.visitors.PopulateTreeVisitor;
import wordCount.visitors.TreeProcessingVisitorI;
import wordCount.visitors.WordCountVisitor;
import wordCount.treesForStrings.Trie;

public class Driver {
	public static void main(String args[]) {
		// Command line argument verification
		// 4 arguments: input file, output file, num iterations, search string
		validateArgLength(args.length, 4);
		// BufferedWriter br = null;
		FileProcessorI fpOut = new FileProcessor(args[1], true);
		// br = new BufferedWriter(new FileWriter(args[1], false));

		// Verify Num Iterations
		int NUM_ITERATIONS = validateNumParam(args[2], Integer.MIN_VALUE,
				Integer.MAX_VALUE,
				"Exception caught parsing argument 3: Num Iterations.",
				"Argument 3 must be a string that can be parsed into an int.");

		// Call visitors and test performance
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < NUM_ITERATIONS; i++) {
			// Declare/instantiate the tree and visitors
			Trie trie = new Trie();
			TreeProcessingVisitorI populateTreeVisitor = new PopulateTreeVisitor(args[0]);
			TreeProcessingVisitorI wordCountVisitor = new WordCountVisitor(fpOut);
			TreeProcessingVisitorI grepVisitor = new GrepVisitor(fpOut, args[3]);
			
			// Code to visit with the PopulateTreeVisitor
			trie.accept(populateTreeVisitor);
			// Code to visit with the WordCountVisitor
			trie.accept(wordCountVisitor);
			// Code to grep with the grepVisitor
			trie.accept(grepVisitor);
		}
		fpOut.close();
		long finishTime = System.currentTimeMillis();
		long totalTime = (finishTime - startTime) / NUM_ITERATIONS;
		System.out
				.println("The total time it took to visit with each visitor is: "
						+ totalTime + " ms.");
	} // end main(...)

	private static void validateArgLength(int argsLength, int expectedLength)
			throws IllegalArgumentException {
		if (argsLength > expectedLength) {
			throw new IllegalArgumentException(
					"WordCount requires four"
							+ " arguments to be passed in at runtime.\n"
							+ "More than four were passed into the execution of this program.\n"
							+ "This could be a result of extra default args set in your ant buildfile.\n"
							+ "Ant usage: \n\t"
							+ "ant -buildfile src/build.xml run -Darg0=<input file> "
							+ "-Darg1=<output file> -Darg2=<Num Iterations> -Darg3=<Search String>\n");
		}
		if (argsLength < expectedLength) {
			throw new IllegalArgumentException(
					"WordCount requires four"
							+ " arguments to be passed in at runtime.\n"
							+ "You have passed in less than four arguments. Please check your usage.\n"
							+ "If you are passing four arguments and using ant, ensure that your buildfile "
							+ "has 4 arguments set in the run command. Otherwise they will silently not be passed in.\n\n"
							+ "Ant usage: \n\t"
							+ "ant -buildfile src/build.xml run -Darg0=<input file> "
							+ "-Darg1=<output file> -Darg2=<Num Iterations> -Darg3=<Search String>\n");
		}
	}

	private static int validateNumParam(String param, int min, int max,
			String exCaught, String exMessage) throws IllegalArgumentException {
		int retVal = 0;
		try {
			retVal = Integer.valueOf(param);
		} catch (NumberFormatException nfe) {
			System.err.println(exCaught);
			System.err.println("Stack Trace: ");
			nfe.printStackTrace();
			throw new IllegalArgumentException(exMessage);
		} finally {
			if (retVal < min || retVal > max) {
				System.err.println("Argument passed not in valid range.");
				throw new IllegalArgumentException(exMessage);
			}
		}
		return retVal;
	}

} // end public class Driver
