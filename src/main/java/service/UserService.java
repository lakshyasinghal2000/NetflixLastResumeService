package service;

import exceptions.DuplicateUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pojos.User;
import pojos.WatchedHistory;
import repository.WatchHistoryRepository;

import java.util.HashMap;
import java.util.LinkedList;

@Service
@RequiredArgsConstructor
public class UserService {

    private final WatchHistoryRepository repository;

    public void addUser(String userId, String userName) {
        if(repository.existsById(userId)) {
            throw new DuplicateUserException("User with this id already exists");
        }
        WatchedHistory watchedHistory = new WatchedHistory();
        watchedHistory.setUserId(userId);
        watchedHistory.setShows(new HashMap<>());
        repository.save(watchedHistory);
    }
}
