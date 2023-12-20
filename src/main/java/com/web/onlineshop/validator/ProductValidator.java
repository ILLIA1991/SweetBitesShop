package com.web.onlineshop.validator;

import com.web.onlineshop.dto.FlavourCategoryDTO;
import com.web.onlineshop.dto.ProductDTO;
import com.web.onlineshop.exception.ValidationException;
import com.web.onlineshop.repository.model.NameFlavours;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.hibernate.internal.util.StringHelper.isBlank;

@Component
public class ProductValidator {
    private static final Pattern ONLY_LETTERS_PATTERN = Pattern.compile("^[a-zA-Z0-9 ]*$");

    public void validateProduct(ProductDTO productDTO) throws ValidationException {
        List<String> violations = new ArrayList<>();
        validateName(productDTO.getName(), violations);
        validateFlavourCategory(productDTO.getFlavourCategoryDTO(), violations);
        validatePrice(productDTO.getPrice(), violations);

        if (!violations.isEmpty()) {
            throw new ValidationException("Provided product is invalid!", violations);
        }
    }

    private void validateName(String name, List<String> violations) {
        if (isBlank(name)) {
            violations.add("Product name is blank");
        }
        if (!ONLY_LETTERS_PATTERN.matcher(name).matches()) {
            violations.add(String.format("Product name can contain only letters and digits: '%s'", name));
        }
    }

    private void validateFlavourCategory(FlavourCategoryDTO flavourCategoryDTO, List<String> violations) {
        if (flavourCategoryDTO == null) {
            violations.add("Flavour category is null");
        } else {
            String flavourName = flavourCategoryDTO.getName();
            if (isBlank(flavourName)) {
                violations.add("Flavour name is blank");
            } else {
                if (!isFlavourValid(flavourName)) {
                    violations.add(String.format("Invalid flavour name: '%s'", flavourName));
                }
            }
        }
    }

    private void validatePrice(BigDecimal price, List<String> violations) {
        if (price == null) {
            violations.add("Price is null");
        } else if (price.compareTo(BigDecimal.ZERO) < 0) {
            violations.add("Price must be greater than zero");
        }
    }

    private boolean isFlavourValid(String flavourName) {
        for (NameFlavours nameFlavour : NameFlavours.values()) {
            if (nameFlavour.getValue().equalsIgnoreCase(flavourName)) {
                return true;
            }
        }
        return false;
    }
}
