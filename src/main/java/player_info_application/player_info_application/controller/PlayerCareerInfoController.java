package player_info_application.player_info_application.controller;

import org.springframework.web.bind.annotation.*;
import player_info_application.player_info_application.dao.PlayerAppDao;

import java.sql.SQLException;
import java.util.Map;

@RestController
@RequestMapping("/application.com/international/career-info")
public class PlayerCareerInfoController {

    @GetMapping("/{player_name}")
    public Map<String, Map<String,Object>>  getPlayerCareerInfo(@PathVariable("player_name") String playerName) {
        try {
            return PlayerAppDao.fetchPlayerCareerData(playerName);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
    @GetMapping("/t20i/{player_name}")
    public Map<String, Map<String, Object>> fetchPlayerT20iInfoByName(@PathVariable("player_name") String  playerName) {

        try {
            return PlayerAppDao.fetchPlayerT20iInfoByName(playerName);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
    @GetMapping("/odi/{player_name}")
    public Map<String, Map<String, Object>> fetchPlayerODIInfoByName(@PathVariable("player_name") String  playerName)
    {
        try {
            return PlayerAppDao.fetchPlayerODIInfoByName(playerName);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
    @GetMapping("/test/{player_name}")
    public static Map<String, Map<String, Object>> fetchPlayerTestInfoByName(@PathVariable("player_name") String  playerName)
    {
        try {
            return PlayerAppDao.fetchPlayerTestInfoByName(playerName);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
