package cursojava.curso_java.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cursojava.curso_java.errors.DefaultError;
import cursojava.curso_java.exceptions.NotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<?> handleNotFoundException(NotFoundException notFoundException) {
    DefaultError error = new DefaultError(HttpStatus.NOT_FOUND.value(), notFoundException.getMessage());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
}
