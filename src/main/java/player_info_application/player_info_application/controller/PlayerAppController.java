package player_info_application.player_info_application.controller;

import org.springframework.web.bind.annotation.*;
import player_info_application.player_info_application.dao.PlayerAppDao;
import java.sql.SQLException;
import java.util.Map;

@RestController
@RequestMapping("/application.com")
public class PlayerAppController {
    @GetMapping()
    public Map<String, Map<String, Object>> getFirst10PlayerData() {
        try {
            return PlayerAppDao.get10PlayerData();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
    @GetMapping("/personal-info")
    public Map<String, Map<String, Object>> fetchPlayerPersonalInfoByName(@RequestParam String name)
    {
        try {
            return PlayerAppDao.fetchPlayerPersonalDataByName(name);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

