package buana.technical.test.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import buana.technical.test.inventoryservice.model.Inventory;
import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public interface InventoryDb extends JpaRepository<Inventory, Long>{
    List<Inventory> findAll();
    Optional<Inventory> findById(Long idInventory);
}
