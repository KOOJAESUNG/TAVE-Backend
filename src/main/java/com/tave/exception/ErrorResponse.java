package com.tave.exception;

import jakarta.validation.ConstraintViolation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class ErrorResponse {

    private int status;
    private String message;

    //MethodArgumentNotValidException으로부터 발생하는 에러 정보를 담는 멤버 변수이다.
    // 즉, DTO 멤버 변수 필드의 유효성 검증 실패로 발생한 에러 정보를 담는 멤버 변수.
    private List<FieldError> fieldErrors;

    //ConstraintViolationException으로부터 발생하는 에러 정보를 담는 멤버 변수이다.
    // 즉, URI 변수 값의 유효성 검증에 실패로 발생한 에러 정보를 담는 멤버 변수.
    private List<ConstraintViolationError> violationErrors;


    private ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public static ErrorResponse of(int status, String message) {
        return new ErrorResponse(status, message);
    }

    // 추가
    public static ErrorResponse of(HttpStatus httpStatus) {
        return new ErrorResponse(httpStatus.value(), httpStatus.getReasonPhrase());
    }


    private ErrorResponse(int status,List<FieldError> fieldErrors,
                          List<ConstraintViolationError> violationErrors) {
        this.status = status;
        this.fieldErrors = fieldErrors;
        this.violationErrors = violationErrors;
    }

    public static ErrorResponse of(int status,BindingResult bindingResult) {
        return new ErrorResponse(status,FieldError.of(bindingResult), null);
    }

    public static ErrorResponse of(int status,Set<ConstraintViolation<?>> violations) {
        return new ErrorResponse(status,null, ConstraintViolationError.of(violations));
    }

    public static ErrorResponse of(ExceptionCode exceptionCode) {
        return new ErrorResponse(exceptionCode.getHttpStatus().value(), exceptionCode.getMessage());
    }

    @Getter
    public static class FieldError {
        private String field;
        private Object rejectedValue;
        private String reason;

        private FieldError(String field, Object rejectedValue, String reason) {
            this.field = field;
            this.rejectedValue = rejectedValue;
            this.reason = reason;
        }

        private static List<FieldError> of(BindingResult bindingResult) {
            final List<org.springframework.validation.FieldError> fieldErrors =
                    bindingResult.getFieldErrors();
            return fieldErrors.stream()
                    .map(error -> new FieldError(
                            error.getField(),
                            error.getRejectedValue() == null ?
                                    "" : error.getRejectedValue().toString(),
                            error.getDefaultMessage()))
                    .collect(Collectors.toList());
        }
    }

    @Getter
    public static class ConstraintViolationError {
        private String propertyPath;
        private Object rejectedValue;
        private String reason;

        private ConstraintViolationError(String propertyPath, Object rejectedValue,
                                         String reason) {
            this.propertyPath = propertyPath;
            this.rejectedValue = rejectedValue;
            this.reason = reason;
        }

        private static List<ConstraintViolationError> of(
                Set<ConstraintViolation<?>> constraintViolations) {
            return constraintViolations.stream()
                    .map(constraintViolation -> new ConstraintViolationError(
                            constraintViolation.getPropertyPath().toString(),
                            constraintViolation.getInvalidValue().toString(),
                            constraintViolation.getMessage()
                    )).collect(Collectors.toList());
        }
    }
}

