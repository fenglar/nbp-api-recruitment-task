package pl.marcin.nbpapiprojectrt.dto;


import lombok.Data;

import java.util.List;

@Data
public class ExchangeRatesTable {

    private String table;
    private String no;
    private String effectiveDate;
    private List<RatesTable> rates;

}
