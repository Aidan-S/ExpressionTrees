import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Tester {

	
	public static PrintWriter outputFile(String fName) {
			File fileName = new File(fName);
			PrintWriter output = null;
			try {
				output = new PrintWriter(fileName);
			} catch (FileNotFoundException ex) {
				System.out.print("Cannot open " + fName + ", it may not exist");
				return null;
			}
			return output;
	}
	
	
	
	public static Scanner openWords(String fname, int fnum, PrintWriter out) {
		File file = new File(fname);
		Scanner input = null;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException ex) {
			System.out.print("Cannot open " + fname + ", it may not exist");
			return null;
		}
		return input;	
	}
	
	
	public static void main(String[] args) {
		PrintWriter out = outputFile("knapsack.txt");
		
		Scanner file = openWords(args[0], 1, out);
		Scanner keyboard = new Scanner(System.in);
		
		String s = keyboard.nextLine();
		
		if(file == null) {
			openWords(s, 1, out);
		}
		
				
		
		
		

	}

}
