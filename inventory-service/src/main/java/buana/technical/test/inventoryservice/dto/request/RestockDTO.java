package buana.technical.test.inventoryservice.dto.request;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestockDTO {
    @NotNull
    private BigDecimal quantityToAdd;
}
