package com.ankur.stockbroker.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity {

  @Column(unique = true, nullable = false)
  private String username;

  private String password;
}
