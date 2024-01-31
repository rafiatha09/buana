package buana.technical.test.apigetaway.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddProductDTO {
    @NotNull
    private String name;
    @NotNull
    private BigDecimal price;
    @NotNull
    private BigDecimal quantity;
    @NotNull
    private Long inventoryId;
}
