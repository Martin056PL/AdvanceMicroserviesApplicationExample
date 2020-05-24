package wawer.kamil.dbservice.service;

import wawer.kamil.dbservice.dto.request.QuoteRequest;

import java.util.List;

public interface QuotesService {
    List<String> getQuotes(String username);

    List<String> addQuote(QuoteRequest request);
}
