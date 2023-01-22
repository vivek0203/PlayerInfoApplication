package player_info_application.player_info_application.controller;

import org.springframework.web.bind.annotation.*;
import player_info_application.player_info_application.dao.PlayerAppDao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/application.com")
public class PlayerAppController {
    @GetMapping()
    public static Map<String, Map<String, Object>> getFirst10PlayerData() {
        try {
            return PlayerAppDao.get10PlayerData();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

