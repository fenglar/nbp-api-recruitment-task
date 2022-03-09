package pl.marcin.nbpapiprojectrt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.marcin.nbpapiprojectrt.service.NBPService;


@RestController
@RequestMapping("/api")
public class NBPController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NBPService nbpService;



    @GetMapping("/exchange-rates/{currencyCode}")
    public ResponseEntity<?> getExchangeRatesByCode(@PathVariable("currencyCode") String currencyCode) {


        return new ResponseEntity<>(nbpService.getExchangeRates(currencyCode), HttpStatus.OK);

    }
@GetMapping("/gold-price/average")
    public ResponseEntity<?> getGoldPrice (){


    return new ResponseEntity<>(nbpService.getAverageGoldPrice(), HttpStatus.OK);

}

}
