package home.catechumen.rest.config.exceptionhandler;

public class UserBadRequest {

    String message;

    public UserBadRequest() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
