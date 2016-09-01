package DataLayer;

import bin.User;

import java.io.*;

/**
 * Created by Vahan.Bakaryan on 8/29/2016.
 */
public class UserRepository implements DataLayerMode {
    public static String filePath = "Users.txt";
    File file = new File(filePath);

    public void addUser(User user){
        try{
            User.userID++;
            BufferedWriter buffer = new BufferedWriter(new FileWriter(filePath,true));
            buffer.write(user.toString());
            buffer.newLine();
            buffer.flush();
            buffer.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }


    public void getUser(String userName){
        //
    }

    public void deleteUser(Integer userId){
        //
    }

    public void editUser(User user){
        //
    }

}
