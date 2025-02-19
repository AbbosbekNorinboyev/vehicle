package uz.pdp.vehicle.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.pdp.vehicle.dto.ApiResponse;
import uz.pdp.vehicle.dto.ErrorDTO;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ApiResponse<Void> exception(MethodArgumentNotValidException e) {
        List<ErrorDTO> errors = e.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> {
                    String field = fieldError.getField();
                    String defaultMessage = fieldError.getDefaultMessage();
                    String rejectedValue = String.valueOf(fieldError.getRejectedValue());
                    return new ErrorDTO(field,
                            String.format("defaultMessage: '%s, rejectionValue: '%s'', ", defaultMessage, rejectedValue));
                }).toList();
        return ApiResponse.<Void>builder()
                .code(-1)
                .message("Validation error")
                .errors(errors)
                .build();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiResponse<Void> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        return ApiResponse.<Void>builder()
                .code(404)
                .message(resourceNotFoundException.getMessage())
                .success(false)
                .build();
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<Void> handleException(Exception exception) {
        return ApiResponse.<Void>builder()
                .code(500)
                .message("Something wrong -> " + exception.getMessage())
                .success(false)
                .build();
    }
}
