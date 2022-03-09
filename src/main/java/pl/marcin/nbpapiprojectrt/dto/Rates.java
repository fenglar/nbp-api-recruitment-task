package pl.marcin.nbpapiprojectrt.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Rates {

    private String no;
    private String effectiveDate;
    private BigDecimal mid;


}
