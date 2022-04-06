package br.com.sarev.microforum.configs.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorFormDto {
	
	private String campo;
	private String erro;
}
