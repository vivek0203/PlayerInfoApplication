package PlayerInfoApplication.PlayerInfoApplication.controller;

import PlayerInfoApplication.PlayerInfoApplication.dao.PlayerAppDao;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Map;

@RestController
public class PlayerAppController {

    private static PlayerAppDao playerAppDao;
    public static void setPlayerAppDao(PlayerAppDao playerAppDao) {
        PlayerAppController.playerAppDao = playerAppDao;
    }

    @GetMapping("/player_career_info")
    public static Map<String, Object> GetPlayerCareerInfo(@RequestParam String player_name) throws SQLException {
        return playerAppDao.fetchPlayerCareerData(player_name);
    }
    @GetMapping("/player_full_info")
    public static JSONObject GetFirst10PlayerData() throws SQLException{
        return playerAppDao.get10PlayerData();
    }
    @GetMapping("/player_t20i_info")
    public static Map<String, Object> fetchPlayerT20iInfoByName(@RequestParam String  player_name) throws SQLException {

        return playerAppDao.fetchPlayerT20iInfoByName(player_name);
    }
    @GetMapping("/players_odi_info")
    public static Map<String, Object> fetchPlayerODIInfoByName(@RequestParam String  player_name) throws SQLException {
      return playerAppDao.fetchPlayerODIInfoByName(player_name);
    }
    @GetMapping("/players_test_info")
    public static Map<String, Object> fetchPlayerTestInfoByName(@RequestParam String  player_name) throws SQLException {
        return playerAppDao.fetchPlayerTestInfoByName(player_name);
    }
    @GetMapping("/players_personal_info")
    public static Map<String, Object> fetchPlayerPersonalInfoByName(@RequestParam String  name) throws SQLException {
        return playerAppDao.fetchPlayerPersonalDataByName(name);
    }

    @GetMapping("/top_5_experienced_players_data")
    public static Map<String, Object> fetchTop5ExperiencedPlayerDataByGender(@RequestParam String gender) throws SQLException {
        return playerAppDao.fetch5PlayerDataByGender(gender);
    }
    @GetMapping("/top_5_century_scorer_info")
    public static Map<String, Object> fetchTop5CenturyScorerInfoByGender(@RequestParam String gender) throws SQLException {
        return playerAppDao.fetch5PlayerInfoByGender(gender);
    }
    @GetMapping("/top_3_ODI_wicket_takers_info")
    public static Map<String, Object> fetchTop3ODIWicketTakersInfoByGender(@RequestParam String gender) throws SQLException {
        return playerAppDao.fetch3PlayerInfoByGender(gender);
    }

}

