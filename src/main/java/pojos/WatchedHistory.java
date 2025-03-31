package pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "watch_history")
public class WatchedHistory {

    @Id
    private String userId;

    private HashMap<String, WatchedShow> shows = new HashMap<>();

    public void addShow(WatchedShow show) {
        if (shows.size() >= 6 && !shows.containsKey(show.getShowId())) {
            shows.remove(0); // Keep only last 6 shows
        } else {
            shows.put(show.getShowId(), show);
        }
    }
}
