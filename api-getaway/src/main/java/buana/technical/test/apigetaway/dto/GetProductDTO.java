package buana.technical.test.apigetaway.dto;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetProductDTO {
    @NotNull
    private long idProduct;
    @NotNull
    private String name;
    @NotNull
    private BigDecimal price;
    @NotNull
    private BigDecimal quantity;
}
