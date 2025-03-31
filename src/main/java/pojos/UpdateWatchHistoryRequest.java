package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateWatchHistoryRequest {
    private String userId;
    private List<WatchedShow> watchedShowList;
}
