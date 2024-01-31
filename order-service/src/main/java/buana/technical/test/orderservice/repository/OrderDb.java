package buana.technical.test.orderservice.repository;

import org.springframework.stereotype.Repository;

import buana.technical.test.orderservice.model.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface OrderDb extends JpaRepository<Order, Long>{
    List<Order> findAll();
    Optional<Order> findById(Long idOrder);
}