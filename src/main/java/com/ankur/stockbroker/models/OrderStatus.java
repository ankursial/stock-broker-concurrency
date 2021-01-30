package com.ankur.stockbroker.models;

public enum OrderStatus {
  CREATED,
  QUANTITY_NOT_AVAILABLE,
  REQUESTED_PRICE_NOT_AVAILABLE,
  BALANCE_NOT_AVAILABLE,
  REJECTED,
  COMPLETED
}
