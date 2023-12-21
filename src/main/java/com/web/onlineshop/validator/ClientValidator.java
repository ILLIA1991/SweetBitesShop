package com.web.onlineshop.validator;

import com.web.onlineshop.dto.ClientDTO;
import com.web.onlineshop.exception.ValidationException;
import com.web.onlineshop.repository.ClientRepository;
import com.web.onlineshop.repository.model.Client;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.hibernate.internal.util.StringHelper.isBlank;

@Component
public class ClientValidator {

    private static final Pattern ONLY_LETTERS_PATTERN = Pattern.compile("^[a-zA-Z]*$");
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$");
    private final ClientRepository clientRepository;

    public ClientValidator(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void validateClient(ClientDTO clientDTO) throws ValidationException {
        List<String> violations = new ArrayList<>();
        validateLetterField(clientDTO.getName(), "name", violations);
        validateLetterField(clientDTO.getSurname(), "surname", violations);
        validateLetterField(clientDTO.getAddress(), "address", violations);
        validateLetterField(clientDTO.getCountry(), "country", violations);
        validateLetterField(clientDTO.getEmail(), "email", violations);

        validatePhone(clientDTO, violations);
        validateEmail(clientDTO, violations);

        if (!violations.isEmpty()) {
            throw new ValidationException("Provided client is invalid!", violations);
        }
    }

    private void validateLetterField(String value, String fieldName, List<String> violations) {
        if (isBlank(value)) {
            violations.add(String.format("%s is blank", fieldName));
        } else if (!ONLY_LETTERS_PATTERN.matcher(value).matches()) {
            violations.add(String.format("%s can contain only letters: '%s'", fieldName, value));
        }
    }

    private void validatePhone(ClientDTO clientDTO, List<String> violations) {
        if (isBlank(clientDTO.getPhoneNumber())) {
            violations.add("Phone is blank");
        }
        if (!PHONE_NUMBER_PATTERN.matcher(clientDTO.getPhoneNumber()).matches()) {
            violations.add(String.format("%s can contain only digits: '%s'", "phone", clientDTO.getPhoneNumber()));
        }
    }

    private void validateEmail(ClientDTO clientDTO, List<String> violations) {
        if (!EMAIL_PATTERN.matcher(clientDTO.getEmail()).matches()) {
            violations.add(String.format("Invalid email format: '%s'", clientDTO.getEmail()));
        }

        String emailToCheck = clientDTO.getEmail().toLowerCase(); // Приводим к нижнему регистру для сравнения
        Client byEmail = clientRepository.findByEmail(emailToCheck);

        if (byEmail != null) {
            violations.add(String.format("Email '%s' is already used in the system. Please choose a different one!", clientDTO.getEmail()));
        }
    }

}
