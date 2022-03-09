package pl.marcin.nbpapiprojectrt.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoldPrice {
    private String data;
    private BigDecimal cena;

}
