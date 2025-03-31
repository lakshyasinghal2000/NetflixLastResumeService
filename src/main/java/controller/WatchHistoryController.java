package controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pojos.UpdateWatchHistoryRequest;
import pojos.WatchedHistory;
import pojos.WatchedShow;
import service.WatchHistoryService;

import java.util.List;

@RestController
@RequestMapping("/watch-history")
@RequiredArgsConstructor
public class WatchHistoryController {

    private final WatchHistoryService service;

    // GET API to fetch last 6 watched shows
    @GetMapping("/{userId}")
    public ResponseEntity<List<WatchedShow>> getWatchHistory(@PathVariable String userId) {
        return ResponseEntity.ok(service.getWatchHistory(userId));
    }

    // POST API to update user's watch history
    @PostMapping("/add-shows")
    public ResponseEntity<String> updateWatchHistory(@RequestBody UpdateWatchHistoryRequest updateWatchHistoryRequest) {
        return ResponseEntity.ok(service.updateWatchHistory(updateWatchHistoryRequest.getUserId(), updateWatchHistoryRequest.getWatchedShowList()));
    }
}
