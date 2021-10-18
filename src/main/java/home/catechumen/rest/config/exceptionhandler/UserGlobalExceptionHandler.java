package home.catechumen.rest.config.exceptionhandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<UserBadRequest> handleException(UserNotFoundException userNotFoundException){
        UserBadRequest userBadRequest = new UserBadRequest();
        userBadRequest.setMessage(userNotFoundException.getMessage());
        return new ResponseEntity<>(userBadRequest, HttpStatus.NOT_FOUND);
    }

}
