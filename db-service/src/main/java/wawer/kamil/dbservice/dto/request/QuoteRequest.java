package wawer.kamil.dbservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuoteRequest {

    private String userName;
    private List<String> quotes;

}
