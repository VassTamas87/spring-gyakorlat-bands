package hu.flowacademy.gyakorlatBands.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(ValidateException.class)
    public List<String> handleValidateException(ValidateException validateException) {
        return List.of(validateException.getMessage());
    }
}
