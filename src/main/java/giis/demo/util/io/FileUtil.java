package giis.demo.util.io;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import giis.demo.util.argumentchecks.ArgumentChecks;

/**
 * A utility class to read/write text lines from/to a text file
 */
public class FileUtil {

	public List<String> readLines(String inFileName) throws FileNotFoundException {
		
		ArgumentChecks.isNotNull(inFileName, "File cannot be null!");
		ArgumentChecks.isTrue(!inFileName.isEmpty(), "File cannot be empty!");
		
		List<String> res = new LinkedList<>();
		
		String line;
		BufferedReader in = new BufferedReader(new FileReader(inFileName));
		
		try {
			try {
				while((line = in.readLine()) != null) {
					res.add(line);
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return res;
		
	}

	public void writeLines(String outFileName, List<String> lines) {
		
		// Falta validar parámetros.
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(outFileName));
			try {	
				int lineNumber = 0;
				for(String line: lines) {
					lineNumber++;
					out.write(line);
					if(lineNumber < lines.size()-1) {
						out.newLine();
					}
				} 	
			} finally {	
				out.close();
			}
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

}
