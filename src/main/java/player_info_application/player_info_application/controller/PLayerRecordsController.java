package player_info_application.player_info_application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import player_info_application.player_info_application.dao.PlayerAppDao;

import java.sql.SQLException;
import java.util.Map;

@RestController
@RequestMapping("/application.com/international/records")
public class PLayerRecordsController {

    @GetMapping("/top-experienced-players")
    public Map<String, Map<String, Object>> fetchTop5ExperiencedPlayerDataByGender(@RequestParam String gender)
    {
        try {
            return PlayerAppDao.fetch5PlayerDataByGender(gender);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
    @GetMapping("/top-century-scorer")
    public Map<String, Map<String, Object>> fetchTop5CenturyScorerInfoByGender(@RequestParam String gender) {
        try {
            return PlayerAppDao.fetch5PlayerInfoByGender(gender);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
    @GetMapping("/top-ODI-wicket-takers")
    public Map<String,Map<String,Object>> fetchTop3ODIWicketTakersInfoByGender(@RequestParam String gender) {
        try {
            return PlayerAppDao.fetch3PlayerInfoByGender(gender);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
