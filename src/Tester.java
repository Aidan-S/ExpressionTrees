import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Tester {

	/**
	 * @author Aidan-S
	 * date: March 9th, 2018
	 * method: create a print writer that I can output text to
	 * @param fName: the name of the file to print to
	 * @return: the print writer
	 */
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
	
	
	/**
	 * @author Aidan-S
	 * date: March 11th, 2018
	 * method: create a scanner that I can use to read in Prof. Kelly's files
	 * @param fname: the name of the file to read
	 * @param out: the file to print to
	 * @return: the scanner for the given file
	 */
	public static Scanner openWords(String fname, PrintWriter out) {
		File file = new File(fname);
		Scanner input = null;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException ex) {
			System.out.println("This isnt there");
			return null;
		}
		return input;	
	}
	
	/**
	 * @author Aidan-S
	 * date: March 11th, 2018
	 * method: make an array of lines in the file
	 * @param file: the scanner that is reading in the file
	 * @param s: how many lines the file has
	 * @return: String array of the lines
	 */
	public static String[] makeArray(Scanner file, int s) {
		String line = file.nextLine();
		Scanner f = file;
		String[] lines = new String[s];

		for(int i = 0; i < s; i++) {
			lines[i] = line; 
			if(file.hasNextLine())
				line = file.nextLine();
		}
		return lines;
	}
	
	/**
	 * @author Aidan-S
	 * date: March 11th, 2018
	 * method: count the number of lines in the file
	 * @param file: the scanner that is reading in the file
	 * @return: the number of lines in the file
	 */
	public static int size(Scanner file) {
		int count = 0;
		//how many items are in the given file
		while (file.hasNextLine()) {
		    count++;
		    if(file.hasNextLine()) {   
		    	file.nextLine();
		    }
		}
		return count;
	}
	
	/**
	 * @author Aidan-S
	 * date: March 11th, 2018
	 * method: split a line into an array so that it can be turned into a expression tree 
	 * @param line: the line to be split up
	 * @return: the array of nums and operators in the line
	 */
	public static String[] toArray(String line) {
		String[] nums = line.trim().split("\\s+");
		return nums;
	}
	
	/**
	 * @author Aidan-S
	 * date: March 11th, 2018
	 * method: test the expression tree program by taking in a file full of postfix expressions and making trees from them, outputting them to a file 
	 * @param args: file name arguments 
	 * return none
	 */
	public static void main(String[] args) {
		PrintWriter out = outputFile("Aidan_Expressions.txt");
		int e;
		String line;
		
		Scanner file = openWords(args[0], out);	
		e = size(file);
		file = openWords(args[0], out);	
		
		if(file == null) {
			file = openWords("postFixExpressions.txt", out);
			e = size(file);
			file = openWords("postFixExpressions.txt", out);
			if(file == null) {
				Scanner k = new Scanner(System.in);
				line = k.nextLine();
				file = openWords(line, out);
				e = size(file);
				file = openWords(line, out);
			}
		}
		
		Scanner file2 = file;
		
		
		String[] array = makeArray(file, e);
		
		String[] array2;;
		
		String s;
		
		ExpressionTree t;
		
		for(int i = 0; i < array.length; i++) {
			 s = array[i];
			 array2 = toArray(s);
			 t = new ExpressionTree(array2);
			 out.println(t.evalTree());
			 out.println(t.toPrefixNotation());
			 out.println(t.toInfixNotation());
			 out.println(t.toPostfixNotation());
			 out.println(t.postfixEval(array2));
			 out.println("\n");
		}
		
		file.close();
		file2.close();
		out.close();
	}

}
