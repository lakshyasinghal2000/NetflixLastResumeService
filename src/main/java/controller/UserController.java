package controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pojos.User;
import pojos.WatchedHistory;
import service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<String> updateWatchHistory(@RequestBody User user) {
        userService.addUser(user.getUserId(), user.getUserName());
        return ResponseEntity.ok("User Added");
    }
}
