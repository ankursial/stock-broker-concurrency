package com.ankur.stockbroker.repositories;

import com.ankur.stockbroker.models.StockOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<StockOrder, Long> {

}
