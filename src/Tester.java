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
	
	public static String[] toArray(String line) {
		String[] nums = line.trim().split("\\s+");
		return nums;
	}
	
	
	public static void main(String[] args) {
		PrintWriter out = outputFile("myAnswers.txt");
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
