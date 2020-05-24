package wawer.kamil.stockservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import wawer.kamil.stockservice.service.StockQuotesService;
import wawer.kamil.stockservice.service.StockService;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockQuotesService stockQuotesService;

    @Override
    public List<Stock> getStockQuote(final String username){
        List<StockQuote> stockQuoteList = stockQuotesService.getStockQuotes(username);
        return stockQuoteList
                .stream()
                .map(stockQuotesService::getStock)
                .collect(Collectors.toList());
    }
}
