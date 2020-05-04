package br.com.cwi.crescer.tcc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ValidacaoAplicacaoException extends RuntimeException  {

    public ValidacaoAplicacaoException(String message) {
        super(message);
    }
}
