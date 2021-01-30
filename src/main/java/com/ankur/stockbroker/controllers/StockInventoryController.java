package com.ankur.stockbroker.controllers;

import com.ankur.stockbroker.models.StockInventory;
import com.ankur.stockbroker.services.IStockInventoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock/inventory")
public class StockInventoryController {

  @Autowired
  private IStockInventoryService stockInventoryService;

  @GetMapping
  public List<StockInventory> getStockInventory() {
    return stockInventoryService.getAllStockInventory();
  }
}
