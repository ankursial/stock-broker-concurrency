package com.ankur.stockbroker.services;

import com.ankur.stockbroker.models.StockInventory;
import java.util.List;

public interface IStockInventoryService {

  List<StockInventory> getAllStockInventory();
}
