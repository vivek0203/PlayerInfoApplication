package player_info_application.player_info_application.dao;

import player_info_application.player_info_application.connection.Connect;
import player_info_application.player_info_application.util.DBUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PlayerAppDao {
   private PlayerAppDao() {
       super();
    }

    private static final Logger log = LoggerFactory.getLogger(PlayerAppDao.class);
    private static final String ID= "id";
    private static final String PLAYERNAME = "player_name";
    private static final String PLAYERSPECIFICATION = "player_specification";
    private static final String TOTALMATCHES = "player_total_matches";
    private static final String TOTALCENTURIES = "player_centuries";
    private static final String TOTALHALFCENTURIES = "player_half_centuries";
    private static final String TOTAL5WICKETSHAUL = "player_five_wickets";
    private static final String TOTALHATTRICKS = "player_total_hatricks";
    private static final String TOTALODIMATCHES = "total_ODI_matches";
    private static final String TOTALTESTMATCHES = "total_Test_matches";
    private static final String TOTALT20IMATCHES = "total_T20i_matches";
    private static final String TOTALODIWICKETS = "total_odi_wickets";
    private static final String TOTALT20IWICKETS = "total_t20i_wickets";
    private static final String TOTALTESTWICKETS = "total_test_wickets";
    private static final String TOTALODIRUNS = "player_odi_runs";
    private static final String TOTALT20IRUNS = "player_t20i_runs";
    private static final String TOTALTESTRUNS = "player_test_runs";
    private static final String AGE = "age";
    private static final String GENDER = "gender";
    private static final String STATE = "state";

    public static Map<String, Object> fetchPlayerCareerData(String playerName) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        Map<String, Object> playerCareerInfo = new LinkedHashMap<>();
        ResultSet rs = null;
        try {
            if (playerName == null || playerName.isEmpty()) {
                log.error("Please provide a valid Player Name, invalid Player Name null or empty..");
                throw new IllegalArgumentException("Please provide a valid Player Name, invalid Player Name null or empty..");
            }
            conn = Connect.createConnection();

            String query = "Select * from player_career_info where player_name = ? ";
            log.debug("Executing fetchPlayerCareerData Query : {} ", query);
            log.debug("Parameters : { PlayerName : {}} ", playerName);

            ps = conn.prepareStatement(query);
            ps.setString(1, playerName);
            rs = ps.executeQuery();

            Map<String, Object> playerData = new LinkedHashMap<>();
            while (rs.next()) {
                playerData.put(ID, rs.getInt("id"));

                playerData.put(PLAYERSPECIFICATION, rs.getString("player_specification"));

                playerData.put(TOTALMATCHES, rs.getInt("player_total_matches"));

                playerData.put(TOTALCENTURIES, rs.getInt("player_centuries"));

                playerData.put(TOTALHALFCENTURIES, rs.getInt("player_half_centuries"));

                playerData.put(TOTAL5WICKETSHAUL, rs.getInt("player_five_wickets"));

                playerData.put(TOTALHATTRICKS, rs.getInt("player_total_hatricks"));

                playerData.put(TOTALODIMATCHES, rs.getInt("total_ODI_matches"));

                playerData.put(TOTALTESTMATCHES, rs.getInt("total_Test_matches"));

                playerData.put(TOTALT20IMATCHES, rs.getInt("total_T20i_matches"));

                playerData.put(TOTALODIWICKETS, rs.getInt("total_odi_wickets"));

                playerData.put(TOTALT20IWICKETS, rs.getInt("total_t20i_wickets"));

                playerData.put(TOTALTESTWICKETS, rs.getInt("total_test_wickets"));

                playerData.put(TOTALODIRUNS,rs.getInt("player_odi_runs"));

                playerData.put(TOTALT20IRUNS, rs.getInt("player_t20i_runs"));

                playerData.put(TOTALTESTRUNS, rs.getInt("player_test_runs"));
            }
            playerCareerInfo.put(playerName, playerData);
            if (playerData.isEmpty()) {
                log.error("player is not available with this name : {}", playerName);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName :" + playerName);
            }

        } finally {
            DBUtil.close(ps, conn);
            DBUtil.close(rs,conn);
        }
        return playerCareerInfo;
    }

    public static JSONObject get10PlayerData() throws SQLException {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        JSONObject playerFullInfo = new JSONObject();
        try {
            conn = Connect.createConnection();
            stmt = conn.createStatement();
            String query = "Select pci.*,ppi.* from player_career_info pci inner join player_personal_info ppi on pci.id = ppi.player_id  where id <= 10  ";
            log.debug("Executing get10PlayerData Query : {} ", query);

            rs = stmt.executeQuery(query);

            JSONArray players = new JSONArray();
            while (rs.next()) {
               Map<String ,Object> playerData = new LinkedHashMap<>();

                playerData.put(ID, rs.getInt("id"));

                playerData.put(PLAYERNAME,rs.getString("player_name"));

                playerData.put(PLAYERSPECIFICATION, rs.getString("player_specification"));

                playerData.put(TOTALMATCHES,rs.getInt("player_total_matches"));

                playerData.put(TOTALCENTURIES,rs.getInt("player_centuries"));

                playerData.put(TOTALHALFCENTURIES,rs.getInt("player_half_centuries"));

                playerData.put(TOTAL5WICKETSHAUL,rs.getInt("player_five_wickets"));

                playerData.put(TOTALHATTRICKS,rs.getInt("player_total_hatricks"));

                playerData.put(TOTALODIMATCHES, rs.getInt("total_ODI_matches"));

                playerData.put(TOTALTESTMATCHES, rs.getInt("total_Test_matches"));

                playerData.put(TOTALT20IMATCHES, rs.getInt("total_T20i_matches"));

                playerData.put(TOTALODIWICKETS, rs.getInt("total_odi_wickets"));

                playerData.put(TOTALT20IWICKETS, rs.getInt("total_t20i_wickets"));

                playerData.put(TOTALTESTWICKETS, rs.getInt("total_test_wickets"));

                playerData.put(TOTALODIRUNS, rs.getInt("player_odi_runs"));

                playerData.put(TOTALT20IRUNS, rs.getInt("player_t20i_runs"));

                playerData.put(TOTALTESTRUNS, rs.getInt("player_test_runs"));

                playerData.put(AGE, rs.getInt("age"));

                playerData.put(GENDER, rs.getString("gender"));

                playerData.put(STATE, rs.getString("state"));

                players.add(playerData);
            }
            playerFullInfo.put("players" ,players);

        } finally {
            DBUtil.close(stmt, conn);
            DBUtil.close(rs,conn);
        }

        return playerFullInfo;

    }

    public static Map<String, Object> fetchPlayerT20iInfoByName(String playerName) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        Map<String, Object> playerT20iInfo = new HashMap<>();
        ResultSet rs = null;

        try {

            if (playerName == null || playerName.isEmpty()) {
                log.error("Please provide a valid playerName, invalid playerName null or empty :{}", playerName);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName null or empty :{}" +playerName);
            }

            conn = Connect.createConnection();

            String query = "Select pci.player_name, pci.player_specification, pci.total_T20i_matches,pci.total_t20i_wickets,pci.player_t20i_runs, ppi.age,ppi.gender  from player_career_info pci left join player_personal_info ppi on pci.id = ppi.player_id  where player_name = ? ";
            log.debug("Executing fetchPlayerT20iInfoByName Query : {} ", query);
            log.debug("Parameters : { Player Name : {}} ", playerName);

            ps = conn.prepareStatement(query);
            ps.setString(1, playerName);
            rs = ps.executeQuery();

            Map<String, Object> playerData = new LinkedHashMap<>();
            while (rs.next()) {

                playerData.put(PLAYERSPECIFICATION, rs.getString("player_specification"));

                playerData.put(TOTALT20IMATCHES, rs.getInt("total_T20i_matches"));

                playerData.put(TOTALT20IWICKETS, rs.getInt("total_t20i_wickets"));

                playerData.put(TOTALT20IRUNS, rs.getInt("player_t20i_runs"));

                playerData.put(AGE, rs.getInt("age"));

                playerData.put(GENDER, rs.getString("gender"));
            }
            playerT20iInfo.put(playerName, playerData);
            if (playerData.isEmpty()){
                log.error("player is not available with this name:{} ",playerName);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName :" + playerName);
            }
        } finally {
            DBUtil.close(ps, conn);
            DBUtil.close(rs,conn);

        }
        return playerT20iInfo;
    }

    public static Map<String, Object> fetchPlayerODIInfoByName(String playerName) throws SQLException {
        Map<String, Object> playerOdiInfo = new HashMap<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (playerName == null || playerName.isEmpty()) {
                log.error("Please provide a valid playerName, invalid playerName null or empty ::{}", playerName);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName null or empty :" + playerName);
            }
            conn = Connect.createConnection();

            String query = "Select pci.id, pci.player_name, pci.player_specification, pci.total_ODI_matches,pci.total_odi_wickets,pci.player_odi_runs, ppi.age,ppi.gender  from player_career_info pci left join player_personal_info ppi on pci.id = ppi.player_id  where player_name = ? ";
            log.debug("Executing fetchPlayerODIInfoByName Query : {} ", query);
            log.debug("Parameters : { Player_Name : {}} ", playerName);
            ps = conn.prepareStatement(query);
            ps.setString(1, playerName);
            rs = ps.executeQuery();

            Map<String, Object> playerData = new LinkedHashMap<>();
            while (rs.next()) {
                playerData.put(ID, rs.getInt("id"));

                playerData.put(PLAYERSPECIFICATION, rs.getString("player_specification"));

                playerData.put(TOTALODIMATCHES, rs.getInt("total_ODI_matches"));

                playerData.put(TOTALODIWICKETS, rs.getInt("total_odi_wickets"));

                playerData.put(TOTALODIRUNS, rs.getInt("player_odi_runs"));

                playerData.put(AGE, rs.getInt("age"));

                playerData.put(GENDER, rs.getString("gender"));
            }
            playerOdiInfo.put(playerName, playerData);
            if (playerData.isEmpty()){
                log.error("player is not available with this name : {}" , playerName);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName :" + playerName);
            }

        } finally {
            DBUtil.close(ps, conn);
            DBUtil.close(rs,conn);

        }
        return playerOdiInfo;

    }

    public static Map<String, Object> fetchPlayerTestInfoByName(String playerName) throws SQLException {
        Map<String, Object> playerTestInfo = new HashMap<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            if (playerName == null || playerName.isEmpty()) {
                log.error("Please provide a valid playerName, invalid playerName null or empty ::{}", playerName);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName null or empty :" + playerName);
            }
            conn = Connect.createConnection();

            String query = "Select pci.id, pci.player_name, pci.player_specification, pci.total_Test_matches,pci.total_test_wickets,pci.player_test_runs, ppi.age,ppi.gender,ppi.state  from player_career_info pci left join player_personal_info ppi on pci.id = ppi.player_id  where player_name = ? ";
            log.debug("Executing fetchPlayerTestInfoByName2 Query : {} ", query);
            log.debug("Parameter : { PlayerName : {}} ", playerName);
            ps = conn.prepareStatement(query);
            ps.setString(1, playerName);
            rs = ps.executeQuery();

            Map<String, Object> playerData = new LinkedHashMap<>();
            while (rs.next()) {

                playerData.put(ID, rs.getInt("id"));

                playerData.put(PLAYERSPECIFICATION, rs.getString("player_specification"));

                playerData.put(TOTALMATCHES, rs.getInt("total_Test_matches"));

                playerData.put(TOTALTESTWICKETS, rs.getInt("total_test_wickets"));

                playerData.put(TOTALTESTRUNS, rs.getInt("player_test_runs"));

                playerData.put(AGE, rs.getInt("age"));

                playerData.put(GENDER, rs.getString("gender"));

                playerData.put(STATE, rs.getString("state"));

            }
            playerTestInfo.put(playerName, playerData);
            if (playerData.isEmpty()){
                log.error("player is not available with this name : {}" , playerName);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName :" + playerName);
            }
        } finally {
            DBUtil.close(ps, conn);
            DBUtil.close(rs,conn);

        }
        return playerTestInfo;
    }
    public static Map<String, Object> fetchPlayerPersonalDataByName(String name) throws SQLException {
        Map<String, Object> playerPersonalInfo = new HashMap<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            if (name == null || name.isEmpty()) {
                log.error("Please provide a valid playerName, invalid playerName null or empty ::{}", name);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName null or empty :" + name);
            }

            conn = Connect.createConnection();

            String query = "Select * from player_personal_info  where name = ?";
            log.debug("Executing fetchPlayerPersonalData Query : {} ", query);
            log.debug("Parameter : { Name : {}  } ", name);

            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();

            Map<String, Object> playerData = new LinkedHashMap<>();
            while (rs.next()) {

                playerData.put(ID, rs.getInt("player_id"));

                playerData.put(AGE, rs.getInt("age"));

                playerData.put(GENDER, rs.getString("gender"));

                playerData.put(STATE, rs.getString("state"));
            }
            playerPersonalInfo.put(name, playerData);
            if (playerData.isEmpty()){
                log.error("player is not available with this name : {}" , name);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName :" + name);
            }
            }finally{
            DBUtil.close(ps, conn);
            DBUtil.close(rs,conn);

        }
        return playerPersonalInfo;

    }

    public static Map<String, Object> fetch5PlayerDataByGender(String gender) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String, Object> top5experiencedPlayerInfo = new LinkedHashMap<>();
        try {
            if (gender == null || gender.isEmpty()) {
                log.error("Please provide a valid playerName, invalid playerName null or empty ::{}", gender);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName null or empty :" + gender);
            }
            conn = Connect.createConnection();

            String query = "Select pci.id,pci.player_name,pci.player_specification,pci.player_total_matches,ppi.age,ppi.gender,ppi.state from player_career_info pci inner join player_personal_info ppi on pci.id = ppi.player_id  where gender = ? order by player_total_matches desc limit 5 ";
            log.debug("Executing get10PlayerData Query : {} ", query);
            log.debug("Parameter : { Gender : {}} ", gender);

            ps = conn.prepareStatement(query);
            ps.setString(1, gender);
            rs = ps.executeQuery();
            List<Object> players = new ArrayList<>();
            while (rs.next()) {

                Map<String,Object> playerData = new LinkedHashMap<>();

                playerData.put(ID, rs.getInt("id"));

                playerData.put(PLAYERNAME,rs.getString("player_name"));

                playerData.put(PLAYERSPECIFICATION, rs.getString("player_specification"));

                playerData.put(TOTALMATCHES, rs.getInt("player_total_matches"));

                playerData.put(AGE, rs.getInt("age"));

                playerData.put(GENDER, rs.getString("gender"));

                playerData.put(STATE, rs.getString("state"));

                players.add(playerData);
            }

            if (players.isEmpty()){
                log.error("player is not available with this gender : {}",gender);
                throw new IllegalArgumentException("Please provide a valid gender, invalid gender :" + gender);
            }
            top5experiencedPlayerInfo.put(gender, players);
        } finally {
            DBUtil.close(ps, conn);
            DBUtil.close(rs,conn);

        }
        return top5experiencedPlayerInfo;

    }

    public static Map<String, Object> fetch5PlayerInfoByGender(String gender) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Map<String, Object> top5CenturyScorerInfo = new LinkedHashMap<>();
        try {
            if (gender == null || gender.isEmpty()) {
                log.error("Please provide a valid playerName, invalid playerName null or empty ::{}", gender);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName null or empty :" + gender);
            }
            conn = Connect.createConnection();

            String query = "Select pci.id,pci.player_name,pci.player_specification,pci.player_total_matches,pci.player_centuries,ppi.age from player_career_info pci inner join player_personal_info ppi on pci.id = ppi.player_id  where gender = ? order by player_centuries desc limit 5 ";
            log.debug("Executing get10PlayerData Query : {} ", query);
            log.debug("Parameters : { Gender : {}} ", gender);
            ps = conn.prepareStatement(query);
            ps.setString(1, gender);
            rs = ps.executeQuery();
            List<Object> players = new ArrayList<>();
            while (rs.next()) {

                Map<String,Object> playerData = new LinkedHashMap<>();

                playerData.put(ID, rs.getInt("id"));

                playerData.put(PLAYERNAME,rs.getString("player_name"));

                playerData.put(PLAYERSPECIFICATION, rs.getString("player_specification"));

                playerData.put(TOTALMATCHES, rs.getInt("player_total_matches"));

                playerData.put(TOTALCENTURIES,rs.getInt("player_centuries"));

                playerData.put(AGE,rs.getInt("age"));

                players.add(playerData);
            }
            if (players.isEmpty()){
                log.error("player is not available with gender : {}" ,gender);
                throw new IllegalArgumentException("Please provide a valid gender, invalid gender :{}"+ gender);
            }
            top5CenturyScorerInfo.put(gender, players);
        } finally {
            DBUtil.close(ps, conn);
            DBUtil.close(rs,conn);

        }
        return top5CenturyScorerInfo;

    }

    public static Map<String, Object> fetch3PlayerInfoByGender(String gender) throws SQLException {
        Map<String, Object> top3OdiWicketTakers = new LinkedHashMap<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
                if (gender == null || gender.isEmpty()) {
                    log.error("Please provide a valid gender, invalid gender null or empty ::{}", gender);
                    throw new IllegalArgumentException("Please provide a valid gender, invalid gender null or empty :" + gender);
                }
                conn = Connect.createConnection();

                String query = "Select pci.id,pci.player_name,pci.player_specification,pci.total_ODI_matches,pci.total_odi_wickets,ppi.age from player_career_info pci inner join player_personal_info ppi on pci.id = ppi.player_id  where gender = ? order by total_odi_wickets desc limit 3 ";
                log.debug("Executing get10PlayerData Query : {} ", query);
                log.debug("Parameters : { Gender : {}} ", gender);
                ps = conn.prepareStatement(query);
                ps.setString(1, gender);
                rs = ps.executeQuery();

            List<Object> players = new ArrayList<>();
            while (rs.next()) {

                    Map<String,Object> playerData = new LinkedHashMap<>();

                    playerData.put(ID, rs.getInt("id"));

                    playerData.put(PLAYERNAME,rs.getString("player_name"));

                    playerData.put(PLAYERSPECIFICATION, rs.getString("player_specification"));

                    playerData.put(TOTALODIMATCHES, rs.getInt("total_ODI_matches"));

                    playerData.put(TOTALODIWICKETS, rs.getInt("total_odi_wickets"));

                    playerData.put(AGE,rs.getInt("age"));

                    players.add(playerData);
                }
                if (players.isEmpty()){
                    log.error("Players are not available with  gender : {} ",gender);
                    throw new IllegalArgumentException("Please provide a valid gender..");
                }
                top3OdiWicketTakers.put(gender, players);

            } finally {
                DBUtil.close(ps, conn);
                DBUtil.close(rs,conn);
            }
            return top3OdiWicketTakers;
        }
}

