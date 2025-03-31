package repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pojos.WatchedHistory;

import java.util.Optional;

@Repository
public interface WatchHistoryRepository extends MongoRepository<WatchedHistory, String> {
    Optional<WatchedHistory> findByUserId(String userId);
}
