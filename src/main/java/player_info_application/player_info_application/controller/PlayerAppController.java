package player_info_application.player_info_application.controller;

import player_info_application.player_info_application.dao.PlayerAppDao;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;
import java.util.Map;

@RestController
public class PlayerAppController {

    @GetMapping("/player_career_info")
    public static Map<String, Object> getPlayerCareerInfo(@RequestParam String playerName) throws SQLException {
        return PlayerAppDao.fetchPlayerCareerData(playerName);

    }

    @GetMapping("/player_full_info")
    public static JSONObject getFirst10PlayerData() throws SQLException{
        return PlayerAppDao.get10PlayerData();
    }

    @GetMapping("/player_t20i_info")
    public static Map<String, Object> fetchPlayerT20iInfoByName(@RequestParam String  playerName) throws SQLException {

        return PlayerAppDao.fetchPlayerT20iInfoByName(playerName);
    }

    @GetMapping("/players_odi_info")
    public static Map<String, Object> fetchPlayerODIInfoByName(@RequestParam String  playerName) throws SQLException
    {
      return PlayerAppDao.fetchPlayerODIInfoByName(playerName);
    }

    @GetMapping("/players_test_info")
    public static Map<String, Object> fetchPlayerTestInfoByName(@RequestParam String  playerName) throws SQLException
    {
        return PlayerAppDao.fetchPlayerTestInfoByName(playerName);
    }

    @GetMapping("/players_personal_info")
    public static Map<String, Object> fetchPlayerPersonalInfoByName(@RequestParam String  name) throws SQLException
    {
        return PlayerAppDao.fetchPlayerPersonalDataByName(name);
    }

    @GetMapping("/top_5_experienced_players_data")
    public static Map<String, Object> fetchTop5ExperiencedPlayerDataByGender(@RequestParam String gender) throws SQLException
    {
        return PlayerAppDao.fetch5PlayerDataByGender(gender);
    }

    @GetMapping("/top_5_century_scorer_info")
    public static Map<String, Object> fetchTop5CenturyScorerInfoByGender(@RequestParam String gender) throws SQLException {
        return PlayerAppDao.fetch5PlayerInfoByGender(gender);
    }

    @GetMapping("/top_3_ODI_wicket_takers_info")
    public static Map<String, Object> fetchTop3ODIWicketTakersInfoByGender(@RequestParam String gender) throws SQLException {
        return PlayerAppDao.fetch3PlayerInfoByGender(gender);
    }

}

