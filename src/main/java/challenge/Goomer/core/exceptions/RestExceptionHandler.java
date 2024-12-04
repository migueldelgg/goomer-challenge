package challenge.Goomer.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorMessage> handleIllegalArgumentException(
            IllegalArgumentException ex
    ) {
        var code = HttpStatus.BAD_REQUEST;
        ErrorMessage response = ErrorMessage.builder()
                .code(code.getReasonPhrase())
                .name(ex.getMessage())
                .build();
        return ResponseEntity.status(code).body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorMessage> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException ex
    ) {
        var code = HttpStatus.BAD_REQUEST;
        ErrorMessage response = ErrorMessage.builder()
                .code(code.getReasonPhrase())
                .name(ex.getMessage())
                .build();
        return ResponseEntity.status(code).body(response);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorMessage> handleNullPointerException(
            NullPointerException ex
    ) {
        var index = ex.getMessage().indexOf("because");
        var split = ex.getMessage().substring(index);
        var code = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorMessage response = ErrorMessage.builder()
                .code(code.getReasonPhrase())
                .name(split)
                .build();
        return ResponseEntity.status(code).body(response);
    }
}
