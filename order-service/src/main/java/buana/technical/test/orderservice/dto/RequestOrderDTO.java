package buana.technical.test.orderservice.dto;

import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderDTO {
    @NotNull
    private BigDecimal quantity;

    @NotNull
    private Long idProduct;
}
