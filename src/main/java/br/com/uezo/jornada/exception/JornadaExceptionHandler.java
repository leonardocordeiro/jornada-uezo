package br.com.uezo.jornada.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class JornadaExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String handleRuntimeException() { 
		return "redirect:/";
	}
}
