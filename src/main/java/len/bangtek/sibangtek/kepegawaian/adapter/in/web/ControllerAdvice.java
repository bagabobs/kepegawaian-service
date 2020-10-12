package len.bangtek.sibangtek.kepegawaian.adapter.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(NonExistingException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNonExisting() {

    }

    @ExceptionHandler(ValueInvalidException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public void handleIllegalArgument() {

    }
}
