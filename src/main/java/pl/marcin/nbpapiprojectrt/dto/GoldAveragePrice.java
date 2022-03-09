package pl.marcin.nbpapiprojectrt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class GoldAveragePrice {

    private BigDecimal averageGoldPrice;
}
