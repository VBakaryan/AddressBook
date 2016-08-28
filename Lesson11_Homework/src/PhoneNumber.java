/**
 * Created by ASUS on 27-Aug-16.
 */
public class PhoneNumber {
    private String phoneNUmber;

    public String getPhoneNUmber() {
        return phoneNUmber;
    }
    public void setPhoneNUmber(String phoneNUmbers) {
        this.phoneNUmber = phoneNUmbers;
    }

    PhoneNumber(){

    }
    PhoneNumber(String telNumber){
        this.setPhoneNUmber(telNumber);
    }
}
