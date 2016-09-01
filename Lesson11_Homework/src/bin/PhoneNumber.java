package bin;


/**
 * Created by ASUS on 27-Aug-16.
 */
public class PhoneNumber {

    private String phoneNumber;
    private PhoneType phoneType;

    public PhoneType getPhoneType() {
        return phoneType;
    }
    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }
    public String getPhoneNUmber() {
        return phoneNumber;
    }
    public void setPhoneNUmber(String phoneNUmbers) {
        this.phoneNumber = phoneNUmbers;
    }

    public PhoneNumber(){

    }
    public PhoneNumber(PhoneType phoneType, String phoneNumber){
        this.setPhoneType(phoneType);
        this.setPhoneNUmber(phoneNumber);
    }

    @Override
    public String toString(){
        return this.getPhoneType()+"  "+this.getPhoneNUmber();
    }
}
