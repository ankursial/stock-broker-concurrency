package com.ankur.stockbroker.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockOrder extends BaseEntity {

  @JsonIgnore
  @ApiModelProperty(hidden = true)
  @ManyToOne
  Customer customer;

  @Enumerated(value = EnumType.STRING)
  private OrderType orderType;

  @ManyToOne
  @ApiModelProperty(hidden = true)
  private Stock stock;

  private int quantity;

  private int requestedPrice;

  @ApiModelProperty(hidden = true)
  private float allottedPrice;

  @ApiModelProperty(hidden = true)
  @Enumerated(value = EnumType.STRING)
  private OrderStatus status;
}
