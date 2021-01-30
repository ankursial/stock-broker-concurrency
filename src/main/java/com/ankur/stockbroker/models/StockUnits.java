package com.ankur.stockbroker.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockUnits extends BaseEntity {

  @ManyToOne
  private Customer customer;

  @ManyToOne
  private Stock stock;

  private int quantity;
}
