package wawer.kamil.stockservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wawer.kamil.stockservice.service.StockService;
import yahoofinance.Stock;
import yahoofinance.quotes.stock.StockQuote;

import java.util.List;

@RestController
@RequestMapping("/rest/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/{username}")
    public ResponseEntity<List<Stock>> getStock(@PathVariable("username") final String userName){
        return new ResponseEntity<>(stockService.getStockQuote(userName), HttpStatus.OK);
    }

}
