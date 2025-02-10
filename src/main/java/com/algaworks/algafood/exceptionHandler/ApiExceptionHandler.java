package com.algaworks.algafood.exceptionHandler;

import com.algaworks.algafood.exception.EntidadeEmUsoException;
import com.algaworks.algafood.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.exception.NegocioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<?> tratarEstadoNaoEncontradoException(EntidadeNaoEncontradaException e, WebRequest request) {

        return handleExceptionInternal(e, e.getMessage(), null, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<?> tratarNegocioException(NegocioException e, WebRequest request) {

        return handleExceptionInternal(e, e.getMessage(), null, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(EntidadeEmUsoException.class)
    public ResponseEntity<?> tratarEntidadeEmUsoException(EntidadeEmUsoException e, WebRequest request) {

        return handleExceptionInternal(e, e.getMessage(), null, HttpStatus.CONFLICT, request);

    }


    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {

        if (body==null){
            body = Problema.builder()
                    .dataHora(LocalDateTime.now())
                    .mensagem(status.getReasonPhrase())
                    .build();
        } else if (body instanceof String){
            body = Problema.builder()
                    .dataHora(LocalDateTime.now())
                    .mensagem((String) body)
                    .build();
        }
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

}
