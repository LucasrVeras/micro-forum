package br.com.sarev.microforum.configs.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroValidationHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorFormDto> handle(MethodArgumentNotValidException argumentNotValidException) {
		
		List<ErrorFormDto> erroDto = new ArrayList<>();
		
		List<FieldError> fieldErrors = argumentNotValidException
				.getBindingResult()
				.getFieldErrors();
		
		fieldErrors.forEach(e -> {
			String msg = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErrorFormDto erro = new ErrorFormDto(e.getField(), msg);
			erroDto.add(erro);
		});
		
		return erroDto;			
	}
		
}
