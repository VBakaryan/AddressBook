import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * Created by ASUS on 27-Aug-16.
 */
public class ProgramValidation  {
    Scanner scanner = new Scanner(System.in);
    String input;
    public static final String filePath = "AddressBook.txt";
    public static List<User> users = new ArrayList<>();
    public static int attemptsCount=0;
    public static User currentUser;

    public static final String SIGN_UP="Sign Up";
    public static final String SIGN_IN="Sign In";
    public static final String ADD_TEL_NUMB="Add Tel. Numb";
    public static final String SHOW_TEL_NUMBER="Show Tel. Numbers";
    public static final String SIGN_OUT="Sign Out";
    public static final String HELP="Help";
    public static final String EXIT="Exit";
    public static final String COMMAND_LIST = "\"Sign Up\" --- Create new User \n"
            + "\"Sign In\" --- Log in to your profile \n"
            + "\"Add Tel. Numb\" --- Add new telephone number \n"
            + "\"Show Tel. Numbers\" --- Show all your saved phone numbers \n"
            + "\"Sign Out\" --- Log out from your profile \n"
            + "\"Help\" --- All Commands List \n"
            + "\"Exit\" --- Quit from program \n";



    public void inputvalidation(){
        System.out.println(">>Please write down one of this commands \"Sign In\" or \"Sign Up\".  ");
        input = scanner.nextLine();
        boolean signedIn = false;
        while(1==1) {
            switch (input.toString()) {
                case (SIGN_UP):
                    if (!signedIn) {
                        signUp();
                    } else{
                        System.out.println("You signed in. Please sign out and try again");
                    }
                    break;
                case (SIGN_IN):
                    if (!signedIn) {
                        signIn();
                        signedIn = true;
                    } else {
                        System.out.println("You have already signed in");
                    }
                    break;
                case (ADD_TEL_NUMB):
                    if (signedIn) {
                        inputPhoneNumber(currentUser);
                    } else {
                        System.out.println("You should first sign up");
                    }
                    break;
                case (SHOW_TEL_NUMBER):
                    if (signedIn) {
                        showUserNumbers(currentUser);
                    } else {
                        System.out.println("You should first sign up");
                    }
                    break;
                case (HELP):
                    System.out.print(COMMAND_LIST);
                    break;
                case (SIGN_OUT):
                    if (signedIn) {
                        signOut();
                        //signedIn = false;
                    } else {
                        System.out.println("You should first signed in");
                    }
                    break;
                case (EXIT):
                    System.out.println("Good bye!!!");
                    System.exit(0);
                default:
                    System.out.println("Wrong command, please enter Help for command list");
                    break;
            }
            input = scanner.nextLine();
        }
    }

    public void signUp(){
        System.out.print(">>Please provide your username: ");
        String tempUsername = scanner.nextLine();
        System.out.print(">>Please provide your password: ");
        String tempPassword = scanner.nextLine();
        User tempUser = new User(tempUsername,tempPassword);
        users.add(tempUser);
        printInFile(tempUser,filePath);
        System.out.print(">>You have successfully created user. Please write down one of this commands \"Sign In\" or \"Sign Up\".");

    }
    public void signIn() {
        boolean existance = false;
        System.out.print(">>Please provide your username: ");
        String tempUsername = scanner.nextLine();
        System.out.print(">>Please provide your password: ");
        String tempPassword = scanner.nextLine();
        User tempUser = new User(tempUsername, tempPassword);
        for (User element : users) {
            if (tempUser.equals(element)) {
                existance = true;
                currentUser = element;
                break;
            }
        }
        if(existance){
            System.out.println(">>You are successfully logged in");
            System.out.println(">>Now you can write down one of this commands \"Add Tel. Numb\" or \"Show Tel. Numbers\"'");
        }else{
            counter();
        }
    }
    public void signOut(){
        currentUser = null;
        attemptsCount = 0;
        System.out.print("You were succsesfully sighned out.");
        inputvalidation();
    }

    public void counter() {
        if(attemptsCount<2) {
            System.out.println(">>Your username or password is incorrect please try again ");
            attemptsCount++;
            signIn();
        }else {
            System.out.println("The wrong attempts limit was exceeded. Good bye!!!");
            System.exit(0);
        }
    }
    public void inputPhoneNumber(User user){
        System.out.print(">>Please provide your telephone number: ");
        String tempNumber = scanner.nextLine();
        user.phoneNumbers.add(new PhoneNumber(tempNumber));
        System.out.println(">>You have successfully added your number. If you want to add one more please write \"Add Tel. Numb\". If you want to see your numbers list please write \"Show Tel. Numbers\"' ");

    }
    public void showUserNumbers(User user){
        for(PhoneNumber element:user.phoneNumbers){
            System.out.println(element.getPhoneNUmber().toString());
        }
    }
    public void printInFile(User user, String filePath){

        File file = new File(filePath);

        try{
            FileWriter fileWriter = new FileWriter(file,true);
            fileWriter.write(user.toString());
            fileWriter.flush();
            fileWriter.close();

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

}
