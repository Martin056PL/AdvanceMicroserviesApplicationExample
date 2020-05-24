package wawer.kamil.stockservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockQuotesService {

    private final WebClient.Builder builder;

    @HystrixCommand(fallbackMethod = "getStockQuotesFallBackMethod")
    public List<StockQuote> getStockQuotes(String username) {
        return builder.build()
                .get()
                .uri("http://db-service/rest/db/" + username)
                .retrieve()
                .bodyToFlux(StockQuote.class)
                .timeout(Duration.ofMillis(2000))
                .collectList()
                .block();
    }

    @HystrixCommand(fallbackMethod = "getStockFallBackMethod")
    public Stock getStock(StockQuote quote) {
        try {
            return YahooFinance.get(quote.getSymbol());
        } catch (IOException e) {
            e.printStackTrace();
            return new Stock(quote.getSymbol());
        }
    }

    private Stock getStockFallBackMethod(StockQuote quote){
        throw new NullPointerException();
    }

    private List<StockQuote> getStockQuotesFallBackMethod(String username){
        return new ArrayList<>();
    }
}
