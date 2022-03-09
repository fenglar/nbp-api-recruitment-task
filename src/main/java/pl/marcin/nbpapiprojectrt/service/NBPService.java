package pl.marcin.nbpapiprojectrt.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.marcin.nbpapiprojectrt.dto.ExchangeRates;
import pl.marcin.nbpapiprojectrt.dto.ExchangeRatesTable;
import pl.marcin.nbpapiprojectrt.dto.GoldAveragePrice;
import pl.marcin.nbpapiprojectrt.dto.GoldPrice;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


@Service
public class NBPService {
    RestTemplate restTemplate = new RestTemplate();
    String baseUrl = "http://api.nbp.pl/api/exchangerates/";
String tableAUrl= "tables/a/?format=json";
String tableBUrl= "tables/b/?format=json";


    public String checkTables (String currencyCode) {
        ExchangeRatesTable[] exchangeRatesTableA = restTemplate.getForEntity(baseUrl + tableAUrl,
                ExchangeRatesTable[].class).getBody();

        if (exchangeRatesTableA!= null && exchangeRatesTableA[0].getRates().stream().anyMatch(o -> o.getCode().equals(currencyCode))) {
            return "a";
        }

        ExchangeRatesTable[] exchangeRatesTableB = restTemplate.getForEntity(baseUrl + tableBUrl,
                ExchangeRatesTable[].class).getBody();

        if ( exchangeRatesTableB != null && exchangeRatesTableB[0].getRates().stream().anyMatch(o -> o.getCode().equals(currencyCode))) {
            return "b";
        } else return "currency not found";

    }

    public ExchangeRates getExchangeRates(String currencyCode){
        String tableUrl = checkTables(currencyCode.toUpperCase()) + "/";


        ExchangeRates exchangeRates = restTemplate.getForEntity(baseUrl +"rates/"+ tableUrl + currencyCode+"/last/5/?format=json",
                ExchangeRates.class).getBody();
        return exchangeRates;
    }


    public GoldAveragePrice getAverageGoldPrice(){
        String url = "https://api.nbp.pl/api/cenyzlota/last/14/?format=json";
        GoldPrice[] goldPrice = restTemplate.getForEntity(url,
                GoldPrice[].class).getBody();
        return new GoldAveragePrice(calculateAverage(goldPrice));
    }

    public BigDecimal calculateAverage(GoldPrice[] goldPrices){
        List<BigDecimal> priceList = new ArrayList<>();
        for(int i=0; i< goldPrices.length;i++){
            priceList.add(goldPrices[i].getCena());
        }
        BigDecimal avgGoldPrice = priceList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

        return avgGoldPrice.divide(new BigDecimal(priceList.size()), RoundingMode.HALF_UP);
    }
}
