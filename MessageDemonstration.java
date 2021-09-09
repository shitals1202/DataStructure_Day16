package Day16;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDemonstration {
	
	static String firstName;
	static String fullName;
	static String contactNumber;
	static String date;
	
	static String message = "Hello <<name>>, We have your full name as <<full name>> in our system."
			+ "Your contact number is 91-XXXXXXXXXX. Please, let us know in case of any clarification."
			+ "Thank you BridgeLabz 01/01/2016.";
	
	public static void main(String[] args) {
		MessageDemonstration.start();
	}
	private static void start() {
		getUserDetails();
		message = MessageDemonstration.replace("<<name>>",firstName);
		message = MessageDemonstration.replace("<<full name>>",fullName);
		message = MessageDemonstration.replace("XXXXXXXXXX",contactNumber);
		message = MessageDemonstration.replace("01/01/2016",date);
		System.out.println(message);
	}
	
	private static void getUserDetails() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your first name :");
		firstName = sc.nextLine();
		
		System.out.println("Enter your Full Name :");
		fullName = sc.nextLine();
		
		System.out.println("Enter contact number :");
		contactNumber = sc.nextLine();
		
		System.out.println("Enter date in dd/mm/yyyy format: ");
		date = sc.nextLine();
	}
	public static String replace(String stringToBeReplaced, String replacement) {
		Pattern pattern = Pattern.compile(stringToBeReplaced);
		Matcher matcher = pattern.matcher(message);
		return message = matcher.replaceAll(replacement);
	}
}