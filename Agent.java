import java.util.ArrayList;
import java.util.Scanner;

public class Agent extends Machine { 
	private int currentAcctNum, currentBal, currentAcctNum2;
	private String transactionSummary;
	private ArrayList<String> validAcctNums = new ArrayList<>();
	
	public Agent() {
		
	}
	
	
	public void runMachine() {		
		System.out.println("Please enter a command");
		Scanner reader = new Scanner(System.in);
		while (reader.hasNextLine()) {
			String input = reader.nextLine();
			
			if (input.equals("createAcct")) {
				createAcct();
				
			}
			else if (input.equals("deleteAcct")) {
				
				}
			else if (input.equals("deposit")) {
				
			}
			else if (input.equals("withdraw")) {
				
			}
			else if (input.equals("transfer")) {
				
			}
			else if (input.equals("logout")) {
				logout();
				reader.close();
				break;	
			}
			else {
				System.out.println("Illegal Command.");
			}
		} // end while
	} // end runMachine()
	
	public void createAcct() {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Please enter an account number and an account name: ");
		String acctToDelete = reader.nextLine(); // Scans the next token of the input as a String.
		reader.close();		//once finished
		this.validAcctNums.remove(acctToDelete);
		
	}
	
	public void deleteAcct() {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Please enter the account number you would like to delete: ");
		String acctToDelete = reader.nextLine(); // Scans the next token of the input as a String.
		reader.close();		//once finished
		this.validAcctNums.remove(acctToDelete);	
	}
	
}
