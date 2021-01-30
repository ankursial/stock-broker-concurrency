package com.ankur.stockbroker.services;

import com.ankur.stockbroker.models.Customer;
import com.ankur.stockbroker.models.StockOrder;
import java.util.Optional;

public interface IOrderService {

  Optional<StockOrder> getOrderById(long id);

  StockOrder requestOrder(Customer customer, StockOrder order);
}
