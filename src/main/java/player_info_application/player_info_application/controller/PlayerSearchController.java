package player_info_application.player_info_application.controller;

import org.springframework.web.bind.annotation.*;
import player_info_application.player_info_application.dao.PlayerAppDao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("application.com/international/search-info")
public class PlayerSearchController {
    @GetMapping("/{player_name}")
    public Map<List<String>, List<Map<String, Object>>> fetchAnyNoOfPlayerInfo(@PathVariable("player_name") List<String> playerName){
        try {
            return PlayerAppDao.fetchAnyNoOfPlayerInfo(playerName);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
