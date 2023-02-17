package player_info_application.player_info_application.controller;

import org.springframework.web.bind.annotation.*;
import player_info_application.player_info_application.dao.PlayerAppDao;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/players-data")

public class PlayerAppController {

    @GetMapping()
    public Map<String, Map<String, Object>> getFirst10PlayerData() throws SQLException {
        return PlayerAppDao.get10PlayerData();
    }
    @GetMapping("/{name}/personal-info")
    public Map<String, Map<String, Object>> fetchPlayerPersonalDataByName(@PathVariable("name") String name) throws SQLException {
        return PlayerAppDao.fetchPlayerPersonalDataByName(name);
    }
    @GetMapping("/{player_name}/career-info")
    public Map<String, Map<String,Object>>  getPlayerCareerInfo(@PathVariable("player_name") String playerName) throws SQLException {
            return PlayerAppDao.fetchPlayerCareerData(playerName);
    }
    @GetMapping("/{player_name}/career-info/t20i")
    public Map<String, Map<String, Object>> fetchPlayerT20iInfoByName(@PathVariable("player_name") String  playerName) throws SQLException {
        return PlayerAppDao.fetchPlayerT20iInfoByName(playerName);
    }
    @GetMapping("/{player_name}/career-info/odi")
    public Map<String, Map<String, Object>> fetchPlayerODIInfoByName(@PathVariable("player_name") String  playerName) throws SQLException {
            return PlayerAppDao.fetchPlayerODIInfoByName(playerName);
    }
    @GetMapping("/{player_name}/career-info/test")
    public static Map<String, Map<String, Object>> fetchPlayerTestInfoByName(@PathVariable("player_name") String  playerName) throws SQLException {
            return PlayerAppDao.fetchPlayerTestInfoByName(playerName);
    }
    @GetMapping("/{player_name}")
    public Map<List<String>, List<Map<String, Object>>> fetchAnyNoOfPlayerInfo(@PathVariable("player_name") List<String> playerName) throws SQLException {
            return PlayerAppDao.fetchAnyNoOfPlayerInfo(playerName);
    }
}

