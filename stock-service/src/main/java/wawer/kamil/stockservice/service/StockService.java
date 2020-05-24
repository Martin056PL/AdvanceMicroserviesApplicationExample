package wawer.kamil.stockservice.service;

import yahoofinance.Stock;

import java.util.List;

public interface StockService {
    List<Stock> getStockQuote(String username);
}
