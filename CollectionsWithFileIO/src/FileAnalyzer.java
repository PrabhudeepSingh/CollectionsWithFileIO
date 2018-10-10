import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class FileAnalyzer {
	
	private File textFile;
	private FileWriter fileWriter;
	private InputStream fileInputSteam;
	private InputStreamReader inputStreamReader;
	private BufferedReader bufferedReader;
	private ArrayList<String> wordsInFile;
	
	public FileAnalyzer() throws IOException {
		
		textFile = new File("textToAnalyze.txt");
		textFile.createNewFile();

		fileWriter = new FileWriter(textFile);
		writeInFile();		
		
		fileInputSteam = new FileInputStream(textFile);
		inputStreamReader = new InputStreamReader(fileInputSteam, Charset.forName("UTF-8"));
		bufferedReader = new BufferedReader(inputStreamReader);
		wordsInFile = new ArrayList<>();
		readFile();
	}
	
	private void writeInFile() throws IOException {
		
		fileWriter.write(TextUtility.getText());
		fileWriter.flush();
		fileWriter.close();
	}
	
	private void readFile() throws IOException {
		
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			
		    String[] words = line.split(" ");
		    for(String word: words) {
		    	wordsInFile.add(word);
		    }
		}
	}
	
	public void readAndCountTotal() {

		System.out.println("Total Words in File are: "+wordsInFile.size());
	}
	
	public void readAndCountDifferent() {
		HashSet<String> wordsInFileHashSet = new HashSet<>();
		
		for(int i=0; i<wordsInFile.size(); i++) {
			wordsInFileHashSet.add(wordsInFile.get(i));
		}
		
		System.out.println("\nTotal different Words in File are: "+wordsInFileHashSet.size());
	}
	
	public void readAndSort() {
		
		TreeSet<String> wordsInFileTreeSet = new TreeSet<>();
		for(int i=0; i<wordsInFile.size(); i++) {
			wordsInFileTreeSet.add(wordsInFile.get(i));
		}
			
		System.out.println("\nDifferent words in sorted order (using TreeSet):");
		System.out.println(wordsInFileTreeSet);
	}
	
	public void readToMap() {
		
		HashMap<String, Integer> wordsInFileHashMap = new HashMap<>();
		
		for(int i=0; i<wordsInFile.size(); i++) {
			
			if(wordsInFileHashMap.containsKey(wordsInFile.get(i))) {
				int count = wordsInFileHashMap.get(wordsInFile.get(i));
				count++;
				wordsInFileHashMap.put(wordsInFile.get(i), count);
			}
			else {
				wordsInFileHashMap.put(wordsInFile.get(i), 1);
			}
		}

		System.out.println("\nDifferent words with count (using HashMap):");
		System.out.println(wordsInFileHashMap);
	}
}