import java.util.Scanner;

public class SimpleEncodeDecode {
	
	public static String publicKey = "open"; 
	private static String privateKey = "letmesee";
	
	
	public static void main (String args[]) {
		String message;
		System.out.print("Enter your message: ");
		Scanner reader = new Scanner(System.in); //user enters a message they want to encode/decode
		message = reader.nextLine(); 
		
		encode(message); //method to encode the message

	}
	
	public static void encode(String message){
		System.out.print("Enter public key for encoded message: ");
		Scanner reader =  new Scanner(System.in); //user must enter correct publickey to get encoded message
		String key = reader.nextLine();
		
		while(!key.equals(publicKey)){
			System.out.print("Try again: "); //if user enters the wrong publickkey, they are asked to try again until they are correct
			reader =  new Scanner(System.in);
			key = reader.nextLine();
		}
		
		String[] binary = new String[message.length()]; //this array will hold the binary representation of each character in the message
		System.out.print("Encoded Message: ");
		for(int i=0; i<message.length(); i++){
			if(message.charAt(i) == (' ')){
				binary[i] = "_"; //this is used to represent spaces when encoding
				System.out.print(binary[i]);
			}
			else{
				int numRep = (int) message.charAt(i); //gets the integer representation of the character
				binary[i] = Integer.toBinaryString(numRep); //uses integer representation and changes it to binary
				System.out.print(binary[i]); //prints binary representation
			}
		}
		System.out.println();
		decode(binary); //method to decode encoded message
	}
	
	public static void decode(String[] binary){
		System.out.print("Enter private key to decode message: ");
		Scanner reader =  new Scanner(System.in); //user must enter privatekey to see decoded message
		String key = reader.nextLine();
		
		while(!key.equals(privateKey)){
			System.out.print("Try again: "); //if the user enters the wrong privatekey, they are asked to try again
			reader =  new Scanner(System.in);
			key = reader.nextLine();
		}
		System.out.print("Decoded Message: ");
		char[] decodedMsg = new char[binary.length]; //array to store character representation of binary number
		for(int i=0; i<binary.length; i++){
			if(binary[i] == "_"){
				decodedMsg[i] = ' '; //for spaces in message
				System.out.print(decodedMsg[i]);
			}
			else{
				int numRep = Integer.parseInt(binary[i], 2); //gets integer representation of binary number
				decodedMsg[i] = (char) numRep; //gets character representation of the number
				System.out.print(decodedMsg[i]); //prints decoded message
			}
		}
	}
} //end class
