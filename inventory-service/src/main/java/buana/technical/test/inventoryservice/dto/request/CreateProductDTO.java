package buana.technical.test.inventoryservice.dto.request;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductDTO {
    @NotNull
    private String name;
    @NotNull
    private BigDecimal price;
    @NotNull
    private BigDecimal quantity;
    @NotNull
    private Long inventoryId;
}
