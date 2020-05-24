package wawer.kamil.dbservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wawer.kamil.dbservice.dto.request.QuoteRequest;
import wawer.kamil.dbservice.model.Quote;
import wawer.kamil.dbservice.repository.QuotesRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuotesServiceImpl implements QuotesService {

    private final QuotesRepository quotesRepository;

    @Override
    public List<String> getQuotes(String username) {
        //TODO implement optional as security of list as null
        return quotesRepository.findByUserName(username)
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> addQuote(QuoteRequest request) {
        List<Quote> quoteList = request.getQuotes()
                .stream()
                .map(quote -> new Quote(request.getUserName(), quote))
                .collect(Collectors.toList());

        quotesRepository.saveAll(quoteList);

        return quoteList.stream().map(Quote::getQuote).collect(Collectors.toList());
    }

    public void deleteQuote(String username) {
        //TODO implement optional as security of list as null
        List<Quote> quotes = quotesRepository.findByUserName(username);
        quotes.forEach(quotesRepository::delete);
    }
}
