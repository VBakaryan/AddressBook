package Controler;

import DataLayer.UserRepository;
import bin.User;

import java.util.*;

/**
 * Created by Vahan.Bakaryan on 8/30/2016.
 */
public class StaticVariables {
    Scanner scanner = new Scanner(System.in);
    String input;
    public static final String fileName = "AddressBook.txt";
    public static List<User> userList = new ArrayList<>();
    UserRepository userRepo = new UserRepository();
    public static int wrongAttemptsCounter=0;
    public static User currentUser;

    public enum CommandTypes{
        SIGN_UP("Sign Up"),
        SIGN_IN("Sign In"),
        ADD_TEL_NUMB("Add Tel. Numb"),
        SHOW_TEL_NUMBER("Show Tel. Numbers"),
        SIGN_OUT("Sign Out"),
        HELP("Help"),
        EXIT("Exit");
        String str;
        CommandTypes(String str){
            this.str = str;
        }
        String getStr(){
            return this.str;
        }
    }


    public static final List<String> commandList = Arrays.asList("Sign Up","Sign In","Add Tel. Numb","Show Tel. Numbers","Sign Out","Help","Exit","Add Friend","Delete Friend","Show my friend list");

    public static final String SIGN_UP="Sign Up";
    public static final String SIGN_IN="Sign In";
    public static final String ADD_TEL_NUMB="Add Tel. Numb";
    public static final String SHOW_TEL_NUMBER="Show Tel. Numbers";
    public static final String SIGN_OUT="Sign Out";
    public static final String HELP="Help";
    public static final String EXIT="Exit";
    public static final String ADD_FRIEND="Add Friend";
    public static final String DELETE_FRIEND="Delete Friend";
    public static final String SHOW_MY_FRIEND_LIST="Show my friend list";

    public static final String FILE_DIR = "C:\\Users\\vahan.bakaryan\\Documents\\GitHub\\Lesson11_Homework\\Lesson11_Homework\\resources\\config.properties";

}
