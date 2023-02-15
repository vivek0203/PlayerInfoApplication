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
import java.util.Map;

@RestController
@RequestMapping("/Players")

public class PlayerAppController {

@GetMapping
    public Map<String, Map<String, Object>> getFirst10PlayerData() {
        try {
            return PlayerAppDao.get10PlayerData();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

