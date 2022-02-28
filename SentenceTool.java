import java.io.*;
import java.util.*;

public class SentenceTool {
    
	// ATTRIBUTES
	private List<String> lineList = new LinkedList<>();
    private List<String> sentenceList = new LinkedList<>();
	Iterator <String> sentenceIterator;
	
  

    //contructor: reads a textfile with given fileName
    // and creates a list of all sentences in this textfile
    public SentenceTool(String filename) {
		
		// read in file to lineList
		readLines(filename);
		
		boolean multiLine = false;
		for(int i = 0; i < lineList.size(); i++) {
		
			String[] splitLine = lineList.get(i).split("[!\\.\\?]");
			
			// handle case of unfinished sentence in previous line
			if (multiLine) {
				int n = sentenceList.size();
				String buffer = sentenceList.remove(n-1);
				splitLine[0] = buffer + splitLine[0];
				multiLine = false;
			}
			
			for (int j = 0; j < splitLine.length; j++) 
				sentenceList.add(splitLine[j]);
				
			
			int n = lineList.get(i).length();
			char last = lineList.get(i).charAt(n-1);
			if ( last != '.' && last != '?' && last != '.' ) multiLine = true;
		}
		
		sentenceIterator = sentenceList.iterator();
	}
	
	
	// called by constructor:
	private final void readLines(String filename) {
		try {
			BufferedReader in = null;
			try {
				//abstract base class for representing an input stream of bytes
				InputStream inStream = new FileInputStream(filename);
				//using a Reader for input
				Reader r = new InputStreamReader(inStream);
				//additional buffer and methods for efficient input
				in = new BufferedReader(r);

				String line;
				while (in.ready()) {
					lineList.add(in.readLine()); //reading next line
				}
			} catch (Exception e) {
				System.out.println(">> Exception 1: " + e.getMessage());
			}
			//these instructions are always executed
			finally {
				if (in != null)
					in.close();
				System.out.println("All closed");
			}
		} catch (Exception e) {
			System.out.println(">> Exception 2: " + e.getMessage());
		}
	}
	
	
    //returns the number of sentences in this sentence list
    public int size() {
        return sentenceList.size();
    }

    //returns the next sentence
	//returns null if there is no more sentence
    public String nextSentence() {
		if (sentenceIterator.hasNext())
			return sentenceIterator.next();
		else return null;
    }

    //test if there exists a next sentence
    public boolean hasNextSentence() {
        return sentenceIterator.hasNext();
    }
}