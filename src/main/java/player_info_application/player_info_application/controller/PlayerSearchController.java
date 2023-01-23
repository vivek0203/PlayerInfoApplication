package player_info_application.player_info_application.controller;

import org.springframework.web.bind.annotation.*;
import player_info_application.player_info_application.dao.PlayerAppDao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("application.com/international/search")
public class PlayerSearchController {
    @GetMapping()
    public Map<List<String>, List<Map<String, Object>>> fetchAnyNoOfPlayerInfo(@RequestParam List<String> playerName){
        try {
            return PlayerAppDao.fetchAnyNoOfPlayerInfo(playerName);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
