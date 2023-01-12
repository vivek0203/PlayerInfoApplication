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
    public static Map<String, Object> getPlayerCareerInfo(@RequestParam String playerName) {
        try {
            return PlayerAppDao.fetchPlayerCareerData(playerName);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }

    }

    @GetMapping("/player_full_info")
    public static JSONObject getFirst10PlayerData() {
        try {
            return PlayerAppDao.get10PlayerData();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @GetMapping("/player_t20i_info")
    public static Map<String, Object> fetchPlayerT20iInfoByName(@RequestParam String  playerName) {

        try {
            return PlayerAppDao.fetchPlayerT20iInfoByName(playerName);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @GetMapping("/players_odi_info")
    public static Map<String, Object> fetchPlayerODIInfoByName(@RequestParam String  playerName)
    {
        try {
            return PlayerAppDao.fetchPlayerODIInfoByName(playerName);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @GetMapping("/players_test_info")
    public static Map<String, Object> fetchPlayerTestInfoByName(@RequestParam String  playerName)
    {
        try {
            return PlayerAppDao.fetchPlayerTestInfoByName(playerName);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @GetMapping("/players_personal_info")
   public static Map<String, Object> fetchPlayerPersonalInfoByName(@RequestParam String  name)
    {
        try {
            return PlayerAppDao.fetchPlayerPersonalDataByName(name);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @GetMapping("/top_5_experienced_players_data")
    public static Map<String, Object> fetchTop5ExperiencedPlayerDataByGender(@RequestParam String gender)
    {
        try {
            return PlayerAppDao.fetch5PlayerDataByGender(gender);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @GetMapping("/top_5_century_scorer_info")
    public static Map<String, Object> fetchTop5CenturyScorerInfoByGender(@RequestParam String gender) {
        try {
            return PlayerAppDao.fetch5PlayerInfoByGender(gender);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @GetMapping("/top_3_ODI_wicket_takers_info")
    public static Map<String, Object> fetchTop3ODIWicketTakersInfoByGender(@RequestParam String gender) {
        try {
            return PlayerAppDao.fetch3PlayerInfoByGender(gender);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

}

