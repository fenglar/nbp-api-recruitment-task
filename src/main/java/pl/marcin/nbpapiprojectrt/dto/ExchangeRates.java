package pl.marcin.nbpapiprojectrt.dto;

import lombok.Data;

import java.util.List;

@Data
public class ExchangeRates {


    private String table;
    private String currency;
    private String code;
    private List<Rates> rates;


}
