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
public class StockInventoryNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  private String message;

  public StockInventoryNotFoundException(String message) {
    this.message = message;
  }
}
