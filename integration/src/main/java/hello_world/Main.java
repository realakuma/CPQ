package hello_world;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author outofmemory.cn
 */
public class Main {

	/**
	 * Prints some data to a file
	 */
	public void writeToFile(String filename) {

		BufferedOutputStream bufferedOutput = null;

		try {

			// Construct the BufferedOutputStream object
			bufferedOutput = new BufferedOutputStream(new FileOutputStream(filename));

			// Start writing to the output stream
			bufferedOutput.write("Line one".getBytes());
			bufferedOutput.write("\n".getBytes()); // new line, you might want
													// to use \r\n if you're on
													// Windows
			bufferedOutput.write("Line two".getBytes());
			bufferedOutput.write("\n".getBytes());

			// prints the character that has the decimal value of 65
			bufferedOutput.write(65);

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			// Close the BufferedOutputStream
			try {
				if (bufferedOutput != null) {
					bufferedOutput.flush();
					bufferedOutput.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		new Main().writeToFile("myFile.txt");
	}
}