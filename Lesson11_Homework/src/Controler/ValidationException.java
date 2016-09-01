package Controler;

/**
 * Created by Vahan.Bakaryan on 8/29/2016.
 */
public class ValidationException extends RuntimeException {
    ValidationException(){

    }
    ValidationException(String message){
        super(message);
    }
}
