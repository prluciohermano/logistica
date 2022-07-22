package com.garagecontrol.validation.constraintvalidation;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.garagecontrol.validation.NotEmptyList;

@SuppressWarnings("rawtypes")
public class NotEmptyListValidator implements ConstraintValidator<NotEmptyList, List> {

	@Override
	public boolean isValid(List list,
	                   ConstraintValidatorContext constraintValidatorContext) {
		return list != null && !list.isEmpty();
	}
	
	@Override
	public void initialize( NotEmptyList constraintAnnotation ) {
	}
}
