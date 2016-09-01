package bin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 27-Aug-16.
 */
public class User {
    private String userName;
    private String passWord;
    public List<PhoneNumber> phoneNumbers = new ArrayList<>();
    public List<String> friendList = new ArrayList<>();

    public static int userID;
    static{
        userID=0;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        if( userName !=null) {
            this.userName = userName;
        }else{
            throw new NullPointerException();
        }
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        if(passWord != null) {
            this.passWord = passWord;
        }else{
            throw new NullPointerException();
        }

    }

    public User(){}

    public User(String userName, String passWord){
        this.setUserName(userName);
        this.setPassWord(passWord);
    }

    @Override
    public boolean equals(Object obj){
        boolean result;
        if(obj !=null && this.getClass()==obj.getClass() && this.getUserName()!=null && this.getUserName()!=null && ((User)obj).getUserName()!=null && ((User)obj).getPassWord()!=null){
            if(this.getUserName().equals(((User) obj).getUserName())&&this.getPassWord().equals(((User) obj).getPassWord())){
                result = true;
            } else{
                result = false;
            }
        }else
            result = false;
        return result;
    }

    @Override
    public int hashCode(){
        int result = 31*this.getUserName().hashCode()+this.getPassWord().hashCode();
        return result;

    }

    @Override
    public String toString(){
        return userID+"   "+this.getUserName()+"   "+this.getPassWord()+"  "+this.phoneNumbers.toString()+"  "+this.friendList.toString();
    }

}
