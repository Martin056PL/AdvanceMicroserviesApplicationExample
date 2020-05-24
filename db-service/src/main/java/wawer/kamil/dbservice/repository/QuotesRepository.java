package wawer.kamil.dbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import wawer.kamil.dbservice.model.Quote;

import java.util.List;

@Repository
public interface QuotesRepository extends JpaRepository<Quote, String> {

    List<Quote> findByUserName(String username);

    @Modifying
    @Transactional
    @Query("delete from Quote q where q.userName =?1")
    void deleteByUserName(String username);

}
