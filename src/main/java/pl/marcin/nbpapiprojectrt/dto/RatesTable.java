package pl.marcin.nbpapiprojectrt.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RatesTable {

    private String currency;
    private String code;
    private BigDecimal mid;

}
