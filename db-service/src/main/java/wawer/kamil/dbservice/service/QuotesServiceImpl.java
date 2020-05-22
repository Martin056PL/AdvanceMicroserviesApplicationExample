package wawer.kamil.dbservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
        return quotesRepository.findByUserName(username)
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList());
    }

}
