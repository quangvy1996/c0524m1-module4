package com.example.validation.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Setter
@Getter
@NoArgsConstructor
public class UserDto implements Validator {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;
    private String email;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if ("".equals(userDto.getFirstName())) {
            errors.rejectValue("firstName", "Empty", "First name is required");
        }
        else if (!userDto.getFirstName().matches("^([A-Z][a-z]+\\s?)+$")) {
            errors.rejectValue("firstName", "null", "First name contains invalid characters");
        }
        if ("".equals(userDto.getLastName())) {
            errors.rejectValue("lastName", "Empty", "Last name is required");
        }
        else if (!userDto.getLastName().matches("^([A-Z][a-z]+\\s?)+$")) {
            errors.rejectValue("lastName", "null", "Last name contains invalid characters");
        }
        if (!userDto.getPhoneNumber().matches("^[0-9]{10}$")) {
            errors.rejectValue("phoneNumber", "null", "Phone number is required");
        }
        if (userDto.getAge() < 18) {
            errors.rejectValue("age", "age.invalid", "Age must be greater than or equal to 18.");
        }
        if (userDto.getEmail() != null && !userDto.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            errors.rejectValue("email", "email.invalid", "Email format is invalid.");
        }
    }
}
