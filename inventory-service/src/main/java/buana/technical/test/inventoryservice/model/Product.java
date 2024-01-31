package buana.technical.test.inventoryservice.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private BigDecimal quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inventory", referencedColumnName = "idInventory")
    @JsonIgnore
    private Inventory inventory;
}
