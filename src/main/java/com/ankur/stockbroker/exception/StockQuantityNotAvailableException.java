package com.ankur.stockbroker.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
@ResponseBody
public class StockQuantityNotAvailableException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  private String message;

  public StockQuantityNotAvailableException(String message) {
    this.message = message;
  }
}
