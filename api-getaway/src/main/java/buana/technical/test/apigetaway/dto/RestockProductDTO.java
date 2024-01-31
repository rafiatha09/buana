package buana.technical.test.apigetaway.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestockProductDTO {
    @NotNull
    private BigDecimal quantityToAdd;
}
