package www.jcc.com.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.logging.Logger;

public class FileControl {
	final Logger logger = Logger.getLogger(FileControl.class.getSimpleName());
	
	public void writeFile(String title, String content) {
		File newFile = new File(title);
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))) {
			writer.write(content);
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(newFile.getAbsolutePath());
	}
	
	public String readFile(String title) {
		StringBuilder result = new StringBuilder();
		File storedFile = new File(title);
		
		try(BufferedReader reader = new BufferedReader(new FileReader(storedFile))){
			String line;
			while((line = reader.readLine()) != null) {
				result.append(line);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return result.toString();
	}
	
	public void appendFile(String title, String content) {
		File storedFile = new File(title);
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(storedFile, true))){
			writer.append(content);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean deleteFile(String title) {
		boolean result = false;
		File storedFile = new File(title);
		if(storedFile.exists()) {
			result = storedFile.delete();
		}
		return result;
	}
}
