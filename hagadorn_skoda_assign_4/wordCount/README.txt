S542 Design Patterns
Spring 2016
PROJECT 4 README FILE

Due Date: Sunday, April 17 2016
Submission Date: 
Grace Period Used This Project: 0 Days
Grace Period Remaining: 3 Days
Author(s): Alison Hagadorn, David Skoda
e-mail(s): ahagado1@binghamton.edu, dskoda1@binghamton.edu


PURPOSE: The purpose of this project is to design a data structure
and subsequently visitors, such that the data structure optimizes
the performance of each of the visitors.

DATA STRUCTURE JUSTIFICATION: The data structure we chose to use was
a Trie. We chose a trie because for storing strings, it allows you to
access/store strings without much duplication, utilizing like prefixes
of words. Space efficiency we did not make any optimization, but for
time complexity if the length of the longest word is l than we never
have to search more than l nodes to find whether or not it is stored
in our trie. Insertion also is O(l)

PERCENT COMPLETE:
100%

PARTS THAT ARE NOT COMPLETE:
All parts are complete to the best of my knowledge.

BUGS:
There are no bugs to the best of my knowledge.

FILES:
---studentRecordsBackup
     ----- README.txt
     ----- src
          ----- build.xml
          ---treeVisitor
           ----------driver
           -----------------Driver.java
           ----------treesForStrings     
           -----------------Node.java
           -----------------Trie.java
           ----------util     
           -----------------FileProcessor.java
           -----------------FileProcessorI.java
           ----------visitors     
           -----------------TreeProcessingVisitorI.java
           -----------------GrepVisitor.java
           -----------------WordCountVisitor.java
           -----------------PopulateTreeVisitor.java

TO COMPILE:
From the same directory of this readme, run: 
ant -buildfile src/build.xml all

TO RUN:
ant -buildfile src/build.xml run -Darg0=InputFile -Darg1=OutputFile -Darg2=NumIterations -Darg3=SearchString

Sample running config:
ant -buildfile src/build.xml run -Darg0=Large.txt -Darg1=output.txt -Darg2=2 -Darg3=hello



SAMPLE OUTPUT:

bash-3.2$ ant -buildfile src/build.xml run -Darg0=Large.txt -Darg1=output.txt -Darg2=2 -Darg3=the
Buildfile: /Users/Home/Documents/442/wordCount/hagadorn_skoda_assign_4/wordCount/src/build.xml

jar:

run:
     [java] The total time it took to visit with each visitor is: 38 ms.

BUILD SUCCESSFUL
Total time: 0 seconds
bash-3.2$ cat output.txt
The total number of words is: 6749
The most frequently used word is: of
The frequency of the most frequently used word is: 248
The number of characters (without whitespaces) is: 36522
The word 'the' occurs the following times: 242
The total number of words is: 6749
The most frequently used word is: of
The frequency of the most frequently used word is: 248
The number of characters (without whitespaces) is: 36522
The word 'the' occurs the following times: 242


EXTRA CREDIT:
N/A

BIBLIOGRAPHY:
http://stackoverflow.com/questions/225337/how-do-i-split-a-string-with-any-whitespace-chars-as-delimiters
For the regex to split a string by whitespace.

ACKNOWLEDGEMENT:
N/A
