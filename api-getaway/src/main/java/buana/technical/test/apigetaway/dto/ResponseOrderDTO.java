package buana.technical.test.apigetaway.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseOrderDTO {
    @NotNull
    private Long idOrder;

    @NotNull
    private BigDecimal quantity;

    @NotNull
    private Long idProduct;
}
