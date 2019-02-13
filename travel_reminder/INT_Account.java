/*
* user interface class for account
*/
package travel_reminder;
import java.util.Scanner;

public class INT_Account{
	Scanner in;
	private String username="", password="";

	/*
	gets the username and password
	*/
	public void getUsernamePassword(){
		in = new Scanner(System.in);
		System.out.println("Enter your Username: ");
		this.username = in.nextLine();
		System.out.println("Enter password: ");
		this.password = in.nextLine();
		in.close();
	}

	/*
	gets the username
	*/
	public String getUsername(){
		return this.username;
	}

	/*
	gets the password
	*/
	public String getPassword(){
		return this.password;
	}
}
