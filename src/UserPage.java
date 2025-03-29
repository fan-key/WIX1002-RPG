import java.util.Random;
import java.util.Scanner;

public class UserPage {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static JDBC jdbc = new JDBC();
    public static void main(String[] args) {
        
        while(true){
            System.out.println("Welcome to the application!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.exit(0);
                    break;
                case -1:
                    jdbc.clear();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void register(){
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        int key = rand.nextInt(10);

        if(jdbc.alreadyExists(name, "user_name")){
            System.out.println("Username already exists!");
            return;
        }
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        if(jdbc.alreadyExists(email , "user_email")){
            System.out.println("Email already exists!");
            return;
        }
        
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        jdbc.register(name, email, encrypt(password, key), key);
    }

    public static void login(){
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine(); 
        password = encrypt(password, jdbc.getKey(email));  
        if(jdbc.login(email, password)){
            System.out.println("Login successful!");
        }else {
            System.out.println("Incorrect email or password!");
        }
    }        
    public static String encrypt(String pass, int key){
        StringBuilder encrypted = new StringBuilder();
        for(char c : pass.toCharArray()){
            int newChar = c + key;
            if(newChar > 126) newChar = 32 + (newChar - 127);
            else encrypted.append((char) newChar);
        }
        return encrypted.toString();
    }

    public static String decrypt(String pass, int key){
        StringBuilder decrypted = new StringBuilder();
        for(char c : pass.toCharArray()){
            int newChar = c - key;
            if(newChar < 32) newChar = 127 - (32 - newChar);
            else decrypted.append((char) newChar);
        }
        return decrypted.toString();
    }
}