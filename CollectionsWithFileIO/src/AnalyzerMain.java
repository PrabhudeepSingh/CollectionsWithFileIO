import java.io.IOException;

public class AnalyzerMain {

	public static void main(String[] args) throws IOException {

		FileAnalyzer fileAnalyzer = new FileAnalyzer();
		fileAnalyzer.readAndCountTotal();
		fileAnalyzer.readAndCountDifferent();
		fileAnalyzer.readAndSort();
		fileAnalyzer.readToMap();
	}
}