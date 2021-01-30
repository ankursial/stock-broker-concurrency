package com.ankur.stockbroker.models;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock extends BaseEntity {

  private String name;

  private String symbol;
}
