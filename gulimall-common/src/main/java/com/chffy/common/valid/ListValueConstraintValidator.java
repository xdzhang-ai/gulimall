package com.chffy.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

public class ListValueConstraintValidator implements ConstraintValidator<ListValue, Integer> {
    private Set<Integer> set = new HashSet<>();

    @Override
    public void initialize(ListValue constraintAnnotation) {
        for (int value : constraintAnnotation.values()) {
            set.add(value);
        }

    }

    @Override
    public boolean isValid(Integer val, ConstraintValidatorContext constraintValidatorContext) {
        return set.contains(val);
    }
}
