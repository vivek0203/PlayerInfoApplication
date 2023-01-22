package player_info_application.player_info_application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import player_info_application.player_info_application.dao.PlayerAppDao;

import java.sql.SQLException;
import java.util.Map;

@RestController
@RequestMapping("/application.com/personal-info")
public class PlayerPersonalInfoController {
    @GetMapping()
    public static Map<String, Map<String, Object>> fetchPlayerPersonalInfoByName(@RequestParam String name)
    {
        try {
            return PlayerAppDao.fetchPlayerPersonalDataByName(name);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
