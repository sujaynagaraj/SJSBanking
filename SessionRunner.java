// A testing class for our banking program

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SessionRunner {
	
	public static ArrayList<String> acctList = new ArrayList<>();
	public static String FILENAME = new String();
	
	public static void main(String[] args) {
		
		makeArrayList(args[0]);
		acctList.toString();
		
		FILENAME = args[1];
		
		startUp();
		
		
		
	}
	
	private static void makeArrayList(String inputFile) {
		ArrayList<String> aList = new ArrayList<>();
		Path file = Paths.get(inputFile);
		String line;
		try (BufferedReader reader = Files.newBufferedReader(file)) {
			while ((line = reader.readLine()) != null) {
				aList.add(line);
				}// end while loop
		} catch (FileNotFoundException err) {
		    System.out.println(err.getMessage());
		} catch (IOException err) {
			System.err.println(err.getMessage());
		} catch (NumberFormatException err) {
			System.err.println(err.getMessage());			
		} // end try/catch 
		acctList = aList;
	} // end method
	
	
	public static void startUp() {
		Session atm = new Session();
		
		System.out.println("Please enter command 'login' or close the program.");
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		
		if (input.equals("login")) {
			atm.login(reader);
		}
		else {
			startUp();
		}
		
		if (atm.getUserType().equals("agent")) {
			Agent user = new Agent();
			user.runMachine();

		}
		else {
			Machine user = new Machine();
			user.runMachine();
		}

	}

}

