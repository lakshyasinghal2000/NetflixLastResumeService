package service;


import exceptions.ShowRequestException;
import exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pojos.WatchedHistory;
import pojos.WatchedShow;
import repository.WatchHistoryRepository;

import java.util.*;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class WatchHistoryService {

    private final WatchHistoryRepository repository;

    // Get the last 6 watched shows of a user
    public List<WatchedShow> getWatchHistory(String userId) {
        if(Boolean.FALSE.equals(repository.existsById(userId))) {
            throw new UserNotFoundException("User By this Id does not exists");
        }
        Optional<WatchedHistory> watchedHistory = repository.findByUserId(userId);
        return watchedHistory.map(history -> history.getShows().values().stream().toList()).orElseGet(ArrayList::new);
    }

    // Add/update user's watch history
    public String updateWatchHistory(String userId, List<WatchedShow> watchedHistoryList) {
        WatchedHistory history ;
        if(repository.existsById(userId)) {
            history = repository.findByUserId(userId).get();
        } else {
            throw new UserNotFoundException("User does exists with this user id");
        }

        if (history.getShows() == null) {
            history.setShows(new HashMap<>());
        }
        if(nonNull(watchedHistoryList)) {
            for(WatchedShow watchedShow : watchedHistoryList) {
                if(nonNull(watchedShow.getShowId())) {
                    history.getShows().remove(watchedShow.getShowId());
                    history.getShows().put(watchedShow.getShowId(), watchedShow);
                } else {
                    throw new ShowRequestException("Show Id is Null");
                }

            }

        }
        try {
            repository.save(history);
        } catch (Exception ex) {
            return "Show list for user id : " + userId + " NOT updated. Please try again";
        }

        return "Show list for user id : " + userId + " updated.";
    }
}
