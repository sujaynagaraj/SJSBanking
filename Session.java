
import java.util.Scanner;
import java.io.*;


public class Session extends SessionRunner{
	private String userType;

	public Session() {
		
	}

	
	// method to read in master accounts list, convert to an arrayList of strings
	// method to read in the the valid accounts list
	// method to check if an account number is valid
	// method to check if an account name is valid
	
	
	public void login(Scanner reader){
		System.out.println("What kind of user are you? Type 'agent' for agent or 'machine' for machine");
		userType = reader.nextLine();
		if (!userType.equals("agent") && !userType.equals("machine")){
			login(reader);
		}
//		
//		else if (userType.equals("machine")) {
//			Machine machine1 = new Machine();
//			machine1.runMachine();
//					
//		}
//		
//		else if (userType.equals("agent")) {
//			Agent agent1 = new Agent();
//			agent1.runMachine();
//		}

	}
	
	public static boolean validAcctNum(String acctNum) {
		if (acctNum.length() != 7 || acctNum.charAt(0) == '0' ) {
			return false;
		}
		if (acctList.contains(acctNum)) {
			return true;
		}
		else {
			for (int i=0; i < 7; i++) {
		        char c = acctNum.charAt(i);
		        if (c < '0' || c > '9') {
		            return false;
		        }
			}
		return true;
		}
		
	}
	
	
	
	public void logout() {
		System.out.println("Thank you for using SJS Banking");
		//return (or print) transaction summary
		
	}
	
	public String getUserType() {
		return userType;
	}
	
	public static void writeFile(String arg) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			File file = new File(FILENAME);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write(arg);

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

	}
	

}
