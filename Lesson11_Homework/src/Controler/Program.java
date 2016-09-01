package Controler;

import DataLayer.UserRepository;
import bin.PhoneNumber;
import bin.PhoneType;
import bin.User;

import java.io.*;
import java.util.List;
import java.util.Properties;


/**
 * Created by ASUS on 27-Aug-16.
 */
public class Program extends StaticVariables{




    public void start() {

        getMessage("initialMessage");
        input = scanner.nextLine();

        boolean signedIn = false;

        while (1 == 1) {
            try {
                validation(input);

                switch (input.toString()) {
                    case (SIGN_UP):
                        if (!signedIn) {
                            signUp();
                        } else {
                            getMessage("signedIn");
                        }
                        break;
                    case (SIGN_IN):
                        if (!signedIn) {
                            signIn();
                            signedIn = true;
                        } else {
                            getMessage("alreadySignIt");
                        }
                        break;
                    case (ADD_TEL_NUMB):
                        if (signedIn) {
                            inputPhoneNumber(currentUser);
                        } else {
                            getMessage("firstSignIn");
                        }
                        break;
                    case (SHOW_TEL_NUMBER):
                        if (signedIn) {
                            showUserNumbers(currentUser);
                            showUserAndFriendNumbers(userList, currentUser);
                        } else {
                            getMessage("firstSignIn");
                        }
                        break;

                    case (ADD_FRIEND):
                        if (signedIn) {
                            addFriend(currentUser);
                        } else {
                            getMessage("firstSignIn");
                        }
                        break;
                    case (DELETE_FRIEND):
                        if (signedIn) {
                            deleteFriend(currentUser);
                        } else {
                            getMessage("firstSignIn");
                        }
                        break;
                    case (SHOW_MY_FRIEND_LIST):
                        if (signedIn) {
                            showFriendList(currentUser);
                        } else {
                            getMessage("firstSignIn");
                        }
                        break;
                    case (HELP):
                        getMessage("commandList");
                        break;
                    case (SIGN_OUT):
                        if (signedIn) {
                            signOut();
                        } else {
                            getMessage("firstSignIn");
                        }
                        break;
                    case (EXIT):
                        exit();
                        break;
                    default:
                        getMessage("systemIssue");
                        break;
                }

            } catch (ValidationException ex) {
                System.out.println(ex.getMessage());
            }
            input = scanner.nextLine();
        }
    }




    public void validation(String input) throws ValidationException{
        if(!commandList.contains(input)){
            throw new ValidationException(getProperties().getProperty("wrongCommand"));
        }
    }

    public void signUp(){
        getMessage("userName");
        String tempUsername = scanner.nextLine();
        getMessage("passWord");
        String tempPassword = scanner.nextLine();
        User tempUser = new User(tempUsername,tempPassword);
        userList.add(tempUser);
        userRepo.addUser(new User(tempUsername,tempPassword));
        getMessage("successUserCreation");
    }
    public void signIn() {
        boolean existance = false;
        getMessage("userName");
        String tempUsername = scanner.nextLine();
        getMessage("passWord");
        String tempPassword = scanner.nextLine();
        User tempUser = new User(tempUsername, tempPassword);
        for (User element : userList) {
            if (tempUser.equals(element)) {
                existance = true;
                currentUser = element;
                break;
            }
        }
        if(existance){
            getMessage("successLogedIn");
            getMessage("successLoginInAddorShowNumbers");
        }else{
            counter();
        }
    }
    public void counter() {
        if(wrongAttemptsCounter<2) {
            getMessage("incorrectUsernameOrPassword");
            wrongAttemptsCounter++;
            signIn();
        }else {
            getMessage("wrongLimitReached");
            System.exit(0);
        }
    }

    public void inputPhoneNumber(User user) {
            getMessage("phoneNumberType");
            PhoneType tempPhoneType = PhoneType.valueOf(scanner.nextLine().toUpperCase());
            //System.out.println(tempPhoneType);
            getMessage("phoneNumber");
            String tempNumber = scanner.nextLine();
            user.phoneNumbers.add(new PhoneNumber(tempPhoneType, tempNumber));
            getMessage("successNumberAddition");
    }
    public void showUserNumbers(User user){
        for(PhoneNumber element:user.phoneNumbers){
            System.out.println(element.toString());//(element.getPhoneType().toString()+"  "+element.getPhoneNUmber().toString());
        }
    }
    public void showUserAndFriendNumbers(List<User> users, User user){
        for(User userElement:users){
            for(String friendElement:userElement.friendList){
                if(friendElement.equals(user.getUserName())){
                    System.out.println(userElement.getUserName()+"'s phone numbers "+userElement.phoneNumbers.toString());
                }
            }
        }
    }

    public void addFriend(User user){
        getMessage("friendUsername");
        String tempFriendUsername= scanner.nextLine();
        boolean friendUsernameExists = false;
        for(User element:userList){
            if(element.getUserName().equals(tempFriendUsername)){
                friendUsernameExists = true;
            }
        }
        if(friendUsernameExists){
            user.friendList.add(new String(tempFriendUsername));
            getMessage("successFriendAddition1");
            System.out.print(" "+tempFriendUsername+" ");
            getMessage("successFriendAddition2");
        }else{
            getMessage("friendUsernameNotExists");
        }

    }
    public void deleteFriend(User user){
        getMessage("friendUsername");
        String tempFriendUsername= scanner.nextLine();
        boolean friendExists= false;
        int index=-1;
        for(String element:user.friendList){
            if(element.equals(tempFriendUsername)){
                index = user.friendList.indexOf(tempFriendUsername);
                //user.friendList.remove(tempFriendUsername);
                friendExists=true;
            }
        }
        if(!friendExists){
            getMessage("friendDoesNotExists1");
            System.out.print(" "+tempFriendUsername+" ");
            getMessage("friendDoesNotExists2");
        }
        if(index>=0){
            user.friendList.remove(index);
            getMessage("successFriendDeleteion1");
            System.out.println(" "+tempFriendUsername+" ");
            getMessage("successFriendDeleteion2");
        }
    }
    public void showFriendList(User user){
        if(!user.friendList.isEmpty()) {
            getMessage("friendList");
            for (String element : user.friendList) {
                System.out.println(element.toString());
            }
        }else{
            getMessage("friendListIsEmpty");
        }
    }


    public void signOut(){
        currentUser = null;
        wrongAttemptsCounter = 0;
        getMessage("signOut");
        start();
    }
    public void exit(){
        getMessage("goodBye");
        System.exit(0);
    }

    public Properties getProperties() {

        Properties prop = new Properties();
        InputStream inputStream  = null;

        try {
            inputStream = new FileInputStream(FILE_DIR);
            prop.load(inputStream);
            //prop.getProperty("vahan");
            inputStream.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
    public void getMessage(String str){
        System.out.print(getProperties().getProperty(str));
    }

}
