package wawer.kamil.dbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wawer.kamil.dbservice.model.Quote;

import java.util.List;

@Repository
public interface QuotesRepository extends JpaRepository<Quote, String> {

    List<Quote> findByUserName(String username);

}
