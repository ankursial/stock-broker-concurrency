package com.ankur.stockbroker.models;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {

  //  //Out of scope for now
//  @OneToOne(cascade = CascadeType.ALL)
//  @ApiModelProperty(hidden = true)
//  private Account account;
  private String name;

  private String email;

  private float balance;

  //  @JsonBackReference
  @OneToMany(mappedBy = "customer")
  @ApiModelProperty(hidden = true)
  private List<StockOrder> stockOrders;

  //  @JsonManagedReference
  @OneToMany(mappedBy = "customer")
  @ApiModelProperty(hidden = true)
  private List<StockUnits> stockUnits;
}
