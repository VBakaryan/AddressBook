package bin;

/**
 * Created by Vahan.Bakaryan on 8/29/2016.
 */
public enum PhoneType{
    MOBILE(1),
    HOME(2);
    int id;

    PhoneType(int id){
        this.id = id;
    }

    int getID(){
        return this.id;
    }
    void setID(Integer id){
        this.id=id;
    }
}
