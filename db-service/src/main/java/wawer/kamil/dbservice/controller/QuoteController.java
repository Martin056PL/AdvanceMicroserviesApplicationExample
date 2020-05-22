package wawer.kamil.dbservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wawer.kamil.dbservice.service.QuotesServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/rest/db")
@RequiredArgsConstructor
public class QuoteController {

    private final QuotesServiceImpl quotesService;

    @GetMapping("/{username}")
    public ResponseEntity<List<String>> getQuotes(@PathVariable("username") final String username){
        return new ResponseEntity<>(quotesService.getQuotes(username), HttpStatus.OK);
    }

}
