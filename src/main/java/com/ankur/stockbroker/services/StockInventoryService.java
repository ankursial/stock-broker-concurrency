package com.ankur.stockbroker.services;

import com.ankur.stockbroker.models.StockInventory;
import com.ankur.stockbroker.repositories.StockInventoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockInventoryService implements IStockInventoryService {

  @Autowired
  private StockInventoryRepository stockInventoryRepository;

  @Override
  public List<StockInventory> getAllStockInventory() {
    return stockInventoryRepository.findAll();
  }
}
