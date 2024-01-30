package buana.technical.test.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import buana.technical.test.inventoryservice.model.Product;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public interface ProductDb extends JpaRepository<Product, Long>{
    List<Product> findAll();
    Optional<Product> findById(Long idProduct);
}
