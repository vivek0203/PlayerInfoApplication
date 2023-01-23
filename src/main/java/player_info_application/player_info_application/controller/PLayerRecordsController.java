package player_info_application.player_info_application.controller;

import org.springframework.web.bind.annotation.*;
import player_info_application.player_info_application.dao.PlayerAppDao;

import java.sql.SQLException;
import java.util.Map;

@RestController
@RequestMapping("/application.com/international/records")
public class PLayerRecordsController {

    @GetMapping("/top-experienced-players/{gender}")
    public Map<String, Map<String, Object>> fetchTop5ExperiencedPlayerDataByGender(@PathVariable("gender") String gender)
    {
        try {
            return PlayerAppDao.fetch5PlayerDataByGender(gender);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
    @GetMapping("/top-century-scorer/{gender}")
    public Map<String, Map<String, Object>> fetchTop5CenturyScorerInfoByGender(@PathVariable("gender") String gender) {
        try {
            return PlayerAppDao.fetch5PlayerInfoByGender(gender);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
    @GetMapping("/top-ODI-wicket-takers/{gender}")
    public Map<String,Map<String,Object>> fetchTop3ODIWicketTakersInfoByGender(@PathVariable("gender") String gender) {
        try {
            return PlayerAppDao.fetch3PlayerInfoByGender(gender);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
