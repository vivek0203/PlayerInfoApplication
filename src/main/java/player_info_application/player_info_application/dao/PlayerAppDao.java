package player_info_application.player_info_application.dao;

import player_info_application.player_info_application.connect.Connect;
import player_info_application.player_info_application.pojo.PlayersData;
import player_info_application.player_info_application.dbutil.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.*;

@Repository
public class PlayerAppDao {
    private static final Logger log = LoggerFactory.getLogger(PlayerAppDao.class);
    public static Map<String, Map<String,Object>> fetchPlayerCareerData(String playerName) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String, Map<String,Object>> playerCareerInfo = new LinkedHashMap<>();
        try {
            if (playerName == null || playerName.isEmpty()) {
                log.error("Please provide a valid Player Name, invalid Player Name null or empty..");
                throw new IllegalArgumentException("Please provide a valid Player Name, invalid Player Name null or empty..");
            }
            conn = Connect.getDataSource().getConnection();
            String query = "Select * from player_career_info where player_name like ? ";
            log.debug("Executing fetchPlayerCareerData Query : {} ", query);
            log.debug("Parameters : { PlayerName : {}} ", playerName);

            ps = conn.prepareStatement(query);
            ps.setString(1,'%'+ playerName + '%');
            rs = ps.executeQuery();

            Map<String, Object> playerData = new LinkedHashMap<>();
            while (rs.next()) {
                playerData.put(PlayersData.RANK, rs.getInt("ranking"));

                playerData.put(PlayersData.PLAYERSPECIFICATION, rs.getString("player_specification"));

                playerData.put(PlayersData.TOTALMATCHES, rs.getInt("player_total_matches"));

                playerData.put(PlayersData.TOTALCENTURIES, rs.getInt("player_centuries"));

                playerData.put(PlayersData.TOTALHALFCENTURIES, rs.getInt("player_half_centuries"));

                playerData.put(PlayersData.TOTAL5WICKETSHAUL, rs.getInt("player_five_wickets"));

                playerData.put(PlayersData.TOTALHATTRICKS, rs.getInt("player_total_hatricks"));

                playerData.put(PlayersData.TOTALODIMATCHES, rs.getInt("total_ODI_matches"));

                playerData.put(PlayersData.TOTALTESTMATCHES, rs.getInt("total_Test_matches"));

                playerData.put(PlayersData.TOTALT20IMATCHES, rs.getInt("total_T20i_matches"));

                playerData.put(PlayersData.TOTALODIWICKETS, rs.getInt("total_odi_wickets"));

                playerData.put(PlayersData.TOTALT20IWICKETS, rs.getInt("total_t20i_wickets"));

                playerData.put(PlayersData.TOTALTESTWICKETS, rs.getInt("total_test_wickets"));

                playerData.put(PlayersData.TOTALODIRUNS, rs.getInt("player_odi_runs"));

                playerData.put(PlayersData.TOTALT20IRUNS, rs.getInt("player_t20i_runs"));

                playerData.put(PlayersData.TOTALTESTRUNS, rs.getInt("player_test_runs"));

                playerCareerInfo.put(rs.getString("player_name"), playerData);
            }
            if (playerData.isEmpty()) {
                log.error("player is not available with this name : {}", playerName);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName :" + playerName);
            }
        } finally {
            DBUtil.close(rs, ps, conn);
        }
        return playerCareerInfo;
    }
    public static Map<String, Map<String, Object>> get10PlayerData() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Map<String, Map<String, Object>> playerFullInfo = new LinkedHashMap<>();
        try {
            conn = Connect.getDataSource().getConnection();
            stmt = conn.createStatement();
            String query = "Select pci.*,ppi.* from player_career_info pci inner join player_personal_info ppi on pci.ranking = ppi.player_ranking  where ranking <= 10  ";
            log.debug("Executing get10PlayerData Query : {} ", query);

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Map<String, Object> playerData = new LinkedHashMap<>();

                playerData.put(PlayersData.RANK, rs.getInt("ranking"));

                playerData.put(PlayersData.PLAYERSPECIFICATION, rs.getString("player_specification"));

                playerData.put(PlayersData.TOTALMATCHES, rs.getInt("player_total_matches"));

                playerData.put(PlayersData.TOTALCENTURIES, rs.getInt("player_centuries"));

                playerData.put(PlayersData.TOTALHALFCENTURIES, rs.getInt("player_half_centuries"));

                playerData.put(PlayersData.TOTAL5WICKETSHAUL, rs.getInt("player_five_wickets"));

                playerData.put(PlayersData.TOTALHATTRICKS, rs.getInt("player_total_hatricks"));

                playerData.put(PlayersData.TOTALODIMATCHES, rs.getInt("total_ODI_matches"));

                playerData.put(PlayersData.TOTALTESTMATCHES, rs.getInt("total_Test_matches"));

                playerData.put(PlayersData.TOTALT20IMATCHES, rs.getInt("total_T20i_matches"));

                playerData.put(PlayersData.TOTALODIWICKETS, rs.getInt("total_odi_wickets"));

                playerData.put(PlayersData.TOTALT20IWICKETS, rs.getInt("total_t20i_wickets"));

                playerData.put(PlayersData.TOTALTESTWICKETS, rs.getInt("total_test_wickets"));

                playerData.put(PlayersData.TOTALODIRUNS, rs.getInt("player_odi_runs"));

                playerData.put(PlayersData.TOTALT20IRUNS, rs.getInt("player_t20i_runs"));

                playerData.put(PlayersData.TOTALTESTRUNS, rs.getInt("player_test_runs"));

                playerData.put(PlayersData.AGE, rs.getInt("age"));

                playerData.put(PlayersData.GENDER, rs.getString("gender"));

                playerData.put(PlayersData.STATE, rs.getString("state"));

               playerFullInfo.put(rs.getString("player_name"),playerData);
            }
        } finally {
            DBUtil.close(rs,stmt, conn);
        }
        return playerFullInfo;
    }
    public static Map<String, Map<String, Object>> fetchPlayerT20iInfoByName(String playerName) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        Map<String, Map<String, Object>> playerT20iInfo = new HashMap<>();
        ResultSet rs = null;

        try {
            if (playerName == null || playerName.isEmpty()) {
                log.error("Please provide a valid playerName, invalid playerName null or empty :{}", playerName);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName null or empty :{}" + playerName);
            }
            conn = Connect.getDataSource().getConnection();

            String query = "Select player_name,player_specification,total_T20i_matches,total_t20i_wickets,player_t20i_runs  from player_career_info where player_name like ? ";
            log.debug("Executing fetchPlayerT20iInfoByName Query : {} ", query);
            log.debug("Parameters : { Player Name : {}} ", playerName);

            ps = conn.prepareStatement(query);
            ps.setString(1, '%'+playerName+'%');
            rs = ps.executeQuery();

            Map<String, Object> playerData = new LinkedHashMap<>();
            while (rs.next()) {

                playerData.put(PlayersData.PLAYERSPECIFICATION, rs.getString("player_specification"));

                playerData.put(PlayersData.TOTALT20IMATCHES, rs.getInt("total_T20i_matches"));

                playerData.put(PlayersData.TOTALT20IWICKETS, rs.getInt("total_t20i_wickets"));

                playerData.put(PlayersData.TOTALT20IRUNS, rs.getInt("player_t20i_runs"));
                playerT20iInfo.put(rs.getString("player_name"), playerData);
            }

            if (playerData.isEmpty()) {
                log.error("player is not available with this name:{} ", playerName);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName :" + playerName);
            }
        } finally {
            DBUtil.close(rs,ps, conn);
        }
        return playerT20iInfo;
    }
    public static Map<String, Map<String, Object>> fetchPlayerODIInfoByName(String playerName) throws SQLException {
        Map<String, Map<String, Object>> playerOdiInfo = new HashMap<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (playerName == null || playerName.isEmpty()) {
                log.error("Please provide a valid playerName, invalid playerName null or empty ::{}", playerName);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName null or empty :" + playerName);
            }
            conn = Connect.getDataSource().getConnection();

            String query = "Select pci.ranking, pci.player_name, pci.player_specification, pci.total_ODI_matches,pci.total_odi_wickets,pci.player_odi_runs, ppi.age,ppi.gender  from player_career_info pci left join player_personal_info ppi on pci.ranking = ppi.player_ranking  where player_name like ? ";
            log.debug("Executing fetchPlayerODIInfoByName Query : {} ", query);
            log.debug("Parameters : { Player_Name : {}} ", playerName);
            ps = conn.prepareStatement(query);
            ps.setString(1, '%'+playerName+'%');
            rs = ps.executeQuery();

            Map<String, Object> playerData = new LinkedHashMap<>();
            while (rs.next()) {
                playerData.put(PlayersData.RANK, rs.getInt("ranking"));

                playerData.put(PlayersData.PLAYERSPECIFICATION, rs.getString("player_specification"));

                playerData.put(PlayersData.TOTALODIMATCHES, rs.getInt("total_ODI_matches"));

                playerData.put(PlayersData.TOTALODIWICKETS, rs.getInt("total_odi_wickets"));

                playerData.put(PlayersData.TOTALODIRUNS, rs.getInt("player_odi_runs"));

                playerData.put(PlayersData.AGE, rs.getInt("age"));

                playerData.put(PlayersData.GENDER, rs.getString("gender"));
                playerOdiInfo.put(rs.getString("player_name"), playerData);
            }

            if (playerData.isEmpty()) {
                log.error("player is not available with this name : {}", playerName);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName :" + playerName);
            }
        } finally {
            DBUtil.close(rs,ps, conn);
        }
        return playerOdiInfo;
    }
    public static Map<String, Map<String, Object>> fetchPlayerTestInfoByName(String playerName) throws SQLException {
        Map<String, Map<String, Object>> playerTestInfo = new HashMap<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (playerName == null || playerName.isEmpty()) {
                log.error("Please provide a valid playerName, invalid playerName null or empty ::{}", playerName);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName null or empty :" + playerName);
            }
            conn = Connect.getDataSource().getConnection();

            String query = "Select pci.ranking, pci.player_name, pci.player_specification, pci.total_Test_matches,pci.total_test_wickets,pci.player_test_runs, ppi.age,ppi.gender,ppi.state  from player_career_info pci left join player_personal_info ppi on pci.ranking = ppi.player_ranking  where player_name like ? ";
            log.debug("Executing fetchPlayerTestInfoByName2 Query : {} ", query);
            log.debug("Parameter : { PlayerName : {}} ", playerName);
            ps = conn.prepareStatement(query);
            ps.setString(1, '%'+playerName+'%');
            rs = ps.executeQuery();

            Map<String, Object> playerData = new LinkedHashMap<>();
            while (rs.next()) {

                playerData.put(PlayersData.RANK, rs.getInt("ranking"));

                playerData.put(PlayersData.PLAYERSPECIFICATION, rs.getString("player_specification"));

                playerData.put(PlayersData.TOTALMATCHES, rs.getInt("total_Test_matches"));

                playerData.put(PlayersData.TOTALTESTWICKETS, rs.getInt("total_test_wickets"));

                playerData.put(PlayersData.TOTALTESTRUNS, rs.getInt("player_test_runs"));

                playerData.put(PlayersData.AGE, rs.getInt("age"));

                playerData.put(PlayersData.GENDER, rs.getString("gender"));

                playerData.put(PlayersData.STATE, rs.getString("state"));
                playerTestInfo.put(rs.getString("player_name"), playerData);
            }

            if (playerData.isEmpty()) {
                log.error("player is not available with this name : {}", playerName);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName :" + playerName);
            }
        } finally {
            DBUtil.close(rs, ps, conn);
        }
        return playerTestInfo;
    }
    public static Map<String, Map<String, Object>> fetchPlayerPersonalDataByName(String name) throws SQLException {
        Map<String, Map<String, Object>> playerPersonalInfo = new HashMap<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (name == null || name.isEmpty()) {
                log.error("Please provide a valid playerName, invalid playerName null or empty ::{}", name);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName null or empty :" + name);
            }
            conn = Connect.getDataSource().getConnection();

            String query = "Select * from player_personal_info  where name like ?";
            log.debug("Executing fetchPlayerPersonalData Query : {} ", query);
            log.debug("Parameter : { Name : {}  } ", name);
            ps = conn.prepareStatement(query);
            ps.setString(1,  '%'+ name + '%');
            rs = ps.executeQuery();
            Map<String, Object> playerData = new LinkedHashMap<>();
            while (rs.next()) {
                playerData.put(PlayersData.RANK, rs.getInt("player_ranking"));

                playerData.put(PlayersData.AGE, rs.getInt("age"));

                playerData.put(PlayersData.GENDER, rs.getString("gender"));

                playerData.put(PlayersData.STATE, rs.getString("state"));

                playerPersonalInfo.put(rs.getString("name"), playerData);
            }
           if (playerData.isEmpty()) {
                log.error("player is not available with this name : {}", name);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName :" + name);
            }
        } finally {
            DBUtil.close(rs, ps, conn);
        }
        return playerPersonalInfo;
    }
    public static Map<String, Map<String, Object>> fetch5PlayerDataByGender(String gender) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String, Map<String, Object>> top5experiencedPlayerInfo = new LinkedHashMap<>();
        try {
            if (gender == null || gender.isEmpty()) {
                log.error("Please provide a valid playerName, invalid gender null or empty ::{}", gender);
                throw new IllegalArgumentException("Please provide a valid gender, invalid gender null or empty :" + gender);
            }
            conn = Connect.getDataSource().getConnection();

            String query = "Select pci.ranking,pci.player_name,pci.player_specification,pci.player_total_matches,ppi.age,ppi.gender,ppi.state from player_career_info pci inner join player_personal_info ppi on pci.ranking = ppi.player_ranking where gender like ? order by player_total_matches desc limit 5 ";
            log.debug("Executing get10PlayerData Query : {} ", query);
            log.debug("Parameter : { Gender : {}} ", gender);

            ps = conn.prepareStatement(query);
            ps.setString(1, gender+'%');
            rs = ps.executeQuery();
            while (rs.next()) {

                Map<String, Object> playerData = new LinkedHashMap<>();

                playerData.put(PlayersData.RANK, rs.getInt("ranking"));

                playerData.put(PlayersData.PLAYERSPECIFICATION, rs.getString("player_specification"));

                playerData.put(PlayersData.TOTALMATCHES, rs.getInt("player_total_matches"));

                playerData.put(PlayersData.AGE, rs.getInt("age"));

                playerData.put(PlayersData.GENDER, rs.getString("gender"));

                playerData.put(PlayersData.STATE, rs.getString("state"));

                top5experiencedPlayerInfo.put(rs.getString("player_name"), playerData);
            }
            if(top5experiencedPlayerInfo.isEmpty()){
                log.error("Player is not present with gender : {}",gender);
                throw new IllegalArgumentException("Please provide valid gender,invalid gender:"+gender);
            }
        } finally {
            DBUtil.close(rs, ps, conn);
        }
        return top5experiencedPlayerInfo;
    }
    public static Map<String, Map<String, Object>> fetch5PlayerInfoByGender(String gender) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String, Map<String, Object>> top5CenturyScorerInfo = new LinkedHashMap<>();
        try {
            if (gender == null || gender.isEmpty()) {
                log.error("Please provide a valid playerName, invalid playerName null or empty ::{}", gender);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName null or empty :" + gender);
            }
            conn = Connect.getDataSource().getConnection();

            String query = "Select pci.ranking,pci.player_name,pci.player_specification,pci.player_total_matches,pci.player_centuries,ppi.age from player_career_info pci inner join player_personal_info ppi on pci.ranking = ppi.player_ranking  where gender like ? order by player_centuries desc limit 5 ";
            log.debug("Executing get10PlayerData Query : {} ", query);
            log.debug("Parameters : { Gender : {}} ", gender);
            ps = conn.prepareStatement(query);
            ps.setString(1, gender+'%');
            rs = ps.executeQuery();
            while (rs.next()) {

                Map<String, Object> playerData = new LinkedHashMap<>();

                playerData.put(PlayersData.RANK, rs.getInt("ranking"));

                playerData.put(PlayersData.PLAYERSPECIFICATION, rs.getString("player_specification"));

                playerData.put(PlayersData.TOTALMATCHES, rs.getInt("player_total_matches"));

                playerData.put(PlayersData.TOTALCENTURIES, rs.getInt("player_centuries"));

                playerData.put(PlayersData.AGE, rs.getInt("age"));

                top5CenturyScorerInfo.put(rs.getString("player_name"),playerData);
            }
            if(top5CenturyScorerInfo.isEmpty()){
                log.error("Player is not present with gender : {}",gender);
                throw new IllegalArgumentException("Please provide valid gender,invalid gender:"+gender);
            }
        } finally {
            DBUtil.close(rs, ps, conn);
        }
        return top5CenturyScorerInfo;
    }
    public static Map<String, Map<String, Object>> fetch3PlayerInfoByGender(String gender) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String, Map<String, Object>> top3OdiWicketTakers = new LinkedHashMap<>();
        try {
            if (gender == null || gender.isEmpty()) {
                log.error("Please provide a valid gender, invalid gender null or empty ::{}", gender);
                throw new IllegalArgumentException("Please provide a valid gender, invalid gender null or empty :" + gender);
            }
            conn = Connect.getDataSource().getConnection();

            String query = "Select pci.ranking,pci.player_name,pci.player_specification,pci.total_ODI_matches,pci.total_odi_wickets,ppi.age from player_career_info pci inner join player_personal_info ppi on pci.ranking = ppi.player_ranking  where gender like ? order by total_odi_wickets desc limit 3";
            log.debug("Executing get10PlayerData Query : {} ", query);
            log.debug("Parameters : { Gender : {}} ", gender);
            ps = conn.prepareStatement(query);
            ps.setString(1, gender+'%');
            rs = ps.executeQuery();

            while (rs.next()) {

                Map<String, Object> playerData = new LinkedHashMap<>();

                playerData.put(PlayersData.RANK, rs.getInt("ranking"));

                playerData.put(PlayersData.PLAYERSPECIFICATION, rs.getString("player_specification"));

                playerData.put(PlayersData.TOTALODIMATCHES, rs.getInt("total_ODI_matches"));

                playerData.put(PlayersData.TOTALODIWICKETS, rs.getInt("total_odi_wickets"));

                playerData.put(PlayersData.AGE, rs.getInt("age"));

                top3OdiWicketTakers.put(rs.getString("player_name"), playerData);

            }
            if(top3OdiWicketTakers.isEmpty()){
                log.error("Player is not present with gender : {}",gender);
                throw new IllegalArgumentException("Please provide valid gender,invalid gender:"+gender);
            }

        } finally {
            DBUtil.close(rs, ps, conn);
        }
        return top3OdiWicketTakers;
    }
    public static Map<List<String>, List<Map<String, Object>>> fetchAnyNoOfPlayerInfo(List<String> playerName) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<List<String>, List<Map<String, Object>>> playerDetails = new HashMap<>();
        try {
            conn = Connect.getDataSource().getConnection();
            String query = createQuery(playerName.size());
            log.debug("Executing fetchAnyNoOfPlayerInfo Query : {} ", query);
            log.debug(" Parameter: {}", playerName);
            ps = conn.prepareStatement(query);

            int parameterIndex = 1;
            for (Iterator < String > iterator = playerName.iterator(); iterator.hasNext();) {
                String name = iterator.next();
                ps.setString(parameterIndex++,name);
            }
            rs = ps.executeQuery();
            List<Map<String, Object>> players = new ArrayList<>();

            while (rs.next()) {
                Map<String, Object> playerData = new LinkedHashMap<>();

                playerData.put(PlayersData.PLAYERNAME, rs.getString("player_name"));

                playerData.put(PlayersData.RANK, rs.getInt("ranking"));

                playerData.put(PlayersData.PLAYERSPECIFICATION, rs.getString("player_specification"));

                playerData.put(PlayersData.TOTALMATCHES, rs.getInt("player_total_matches"));

                playerData.put(PlayersData.TOTALCENTURIES, rs.getInt("player_centuries"));

                playerData.put(PlayersData.TOTALHALFCENTURIES, rs.getInt("player_half_centuries"));

                playerData.put(PlayersData.TOTAL5WICKETSHAUL, rs.getInt("player_five_wickets"));

                playerData.put(PlayersData.TOTALHATTRICKS, rs.getInt("player_total_hatricks"));

                playerData.put(PlayersData.TOTALODIMATCHES, rs.getInt("total_ODI_matches"));

                playerData.put(PlayersData.TOTALTESTMATCHES, rs.getInt("total_Test_matches"));

                playerData.put(PlayersData.TOTALT20IMATCHES, rs.getInt("total_T20i_matches"));

                playerData.put(PlayersData.TOTALODIWICKETS, rs.getInt("total_odi_wickets"));

                playerData.put(PlayersData.TOTALT20IWICKETS, rs.getInt("total_t20i_wickets"));

                playerData.put(PlayersData.TOTALTESTWICKETS, rs.getInt("total_test_wickets"));

                playerData.put(PlayersData.TOTALODIRUNS, rs.getInt("player_odi_runs"));

                playerData.put(PlayersData.TOTALT20IRUNS, rs.getInt("player_t20i_runs"));

                playerData.put(PlayersData.TOTALTESTRUNS, rs.getInt("player_test_runs"));

                playerData.put(PlayersData.AGE, rs.getInt("age"));

                playerData.put(PlayersData.GENDER, rs.getString("gender"));

                playerData.put(PlayersData.STATE, rs.getString("state"));

                players.add(playerData);

                playerDetails.put(playerName, players);
            }
            if (players.isEmpty()) {
                log.error(" Players are not available with this names : {}", playerName);
                throw new IllegalArgumentException("Please provide a valid playerName, invalid playerName :" + playerName);
            }
        } finally {
            DBUtil.close(rs, ps, conn);
        }
        return playerDetails;
    }
    private static String createQuery(int length) {
        String query = "Select pci.*,ppi.* from player_career_info pci inner join player_personal_info ppi on pci.ranking = ppi.player_ranking where player_name in(";
        StringBuilder queryBuilder = new StringBuilder(query);
        for (int i = 0; i < length; i++) {
            queryBuilder.append("?");
            if (i != length - 1)
                queryBuilder.append(",");
        }
        queryBuilder.append(")");
        return queryBuilder.toString();
    }
}


