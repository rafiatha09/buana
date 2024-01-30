package buana.technical.test.inventoryservice.dto.response;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

import buana.technical.test.inventoryservice.model.Inventory;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetProductDTO {
    @NotNull
    private String name;
    @NotNull
    private BigDecimal price;
    @NotNull
    private BigDecimal quantity;
    @NotNull
    private Inventory inventory;
}
