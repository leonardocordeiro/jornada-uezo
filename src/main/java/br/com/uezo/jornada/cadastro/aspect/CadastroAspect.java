package br.com.uezo.jornada.cadastro.aspect;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import br.com.uezo.jornada.modelo.Usuario;
import br.com.uezo.jornada.validador.ValidadorDeMatriculaService;

@Aspect
@Component
public class CadastroAspect {
	
	private static final String validationErrorCSSClass = "has-error";

	@Autowired
	private ValidadorDeMatriculaService validadorDeMatricula;
	
	@Around("execution( * br.com.uezo.jornada.controller.UsuarioController.cadastro(..))")
	public Object valida(ProceedingJoinPoint jp) { 
		try {
			Model model = (Model) jp.getArgs()[0];
			Usuario usuario = (Usuario) jp.getArgs()[1];
			BindingResult result = (BindingResult) jp.getArgs()[2];
			
			boolean matriculaInvalida = !validadorDeMatricula.ehValida(usuario.getMatricula());
			
			if(result.hasErrors()) {
				List<FieldError> fieldErrors = result.getFieldErrors();
				
				for (FieldError fieldError : fieldErrors) {
					model.addAttribute("hasErrorIn" + fieldError.getField(), validationErrorCSSClass);
				}
				
				if(matriculaInvalida) { 
					model.addAttribute("matriculaInvalida", true);
					model.addAttribute("hasErrorInMatricula", validationErrorCSSClass);
				}
			} 
			
			return jp.proceed();
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}
}
