import java.util.ArrayList;
import java.util.Scanner;

public class Machine extends Session {
	private int currentBal;
	private int currentAcctNum2;
	private static String transactionSummary = "", currentAcctNum = "", currentAcctName = "";
	private ArrayList<String> validAcctNums = new ArrayList<>();
	
	public Machine() {
		
	}
	
	public void addAcct(String acctNum) {
		validAcctNums.add(acctNum);
	}
	
	public void runMachine() {
		
		System.out.println("Please enter a command");
		Scanner reader = new Scanner(System.in);
		while (reader.hasNextLine()) {
			System.out.println("Please enter a command");
			String input = reader.nextLine();

			if (input.equals("deposit")) {
				deposit(reader);
			}
			else if (input.equals("withdraw")) {
				withdraw(reader);
			}
			else if (input.equals("transfer")) {
				transfer(reader);
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
	
	public static void deposit(Scanner reader) {
		System.out.println("Account number: ");
		currentAcctNum = reader.nextLine();
		if (!validAcctNum(currentAcctNum)) {
			System.out.println("Invalid account number. Please try again.");
			deposit(reader);
		}
		System.out.println("Amount to deposit: ");
		int depositAmount;
		depositAmount = Integer.parseInt(reader.nextLine());
		if (1 > depositAmount || depositAmount > 100000 ) {
			System.out.println("Illegal deposit amount. Please try again.");
			deposit(reader);
		}
		transactionSummary += "DEP " + currentAcctNum + " " + Integer.toString(depositAmount) + " 0000000 " + currentAcctName + "\n";
		System.out.println(transactionSummary);
		writeFile("DEP " + currentAcctNum + " " + Integer.toString(depositAmount) + " 0000000 " + currentAcctName + "\n");
	}
	
	public static void withdraw(Scanner reader) {
		
	}
	
	public static void transfer(Scanner reader) {
		
	}

}