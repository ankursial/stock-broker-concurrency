package com.ankur.stockbroker.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockInventory extends BaseEntity {

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "stock_id", referencedColumnName = "id")
  private Stock stock;

  private int totalQuantity;

  private int availableQuantity;

  private float price;
}
