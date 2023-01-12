package player_info_application.player_info_application.dao;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.sql.SQLException;
import java.util.Map;
import static org.testng.Assert.*;

public class TestPlayerAppDao {

    private static final Logger log = LoggerFactory.getLogger(TestPlayerAppDao.class);

    @Test(priority = 1)
    public void testFetchPlayerCareerDataByName()  {
        log.debug("Executing testFetchPlayerCareerDataByName()...");
        try {
            Map<String , Object>  getPlayerData = PlayerAppDao.fetchPlayerCareerData("Hardik Pandya");

            assertNotNull(getPlayerData);
            assertThat(getPlayerData).hasSize(1);
            log.info("PlayerCareerInfo : {}",getPlayerData);
        } catch (SQLException | IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
        log.info("Exiting from TestPlayerAppDao.testFetchPlayerCareerDataByName()");
    }
    @Test(priority = 2)
    public void testFetchPlayerCareerDataByInvalidName()  {
        log.debug("Executing testFetchPlayerCareerDataByInvalidName()...");
        try {
            PlayerAppDao.fetchPlayerCareerData("Hark Pandya");
        }catch (IllegalArgumentException | SQLException e){
            assert true;
            log.info("Invalid playerName");
        }
    }
    @Test(priority = 3)
    public void testFetchPlayerCareerDataByNameNull() {
        log.debug("Executing testFetchPlayerCareerDataByNameNull()...");
        try {
            PlayerAppDao.fetchPlayerCareerData(null);
        } catch (IllegalArgumentException| SQLException Exception ) {
            assert true;
        }
    }
    @Test(priority = 4)
    public void testFetchPlayerCareerDataByNameEmpty() {
        log.debug("Executing testFetchPlayerCareerDataByNameEmpty()...");

        try {
            PlayerAppDao.fetchPlayerCareerData("");
        } catch (IllegalArgumentException | SQLException e) {
            assert true;
        }
    }
    @Test(priority = 5)
    public void testGet10PlayerData() {
        log.debug("Executing testGet10PlayerData()...");
        JSONObject list10Players;
        try {
            list10Players = PlayerAppDao.get10PlayerData();
            assertThat(list10Players)
                    .isNotNull()
                    .hasSize(1);
            log.info("PlayerFullInfo : {}", list10Players);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 6)
    public void testFetchPlayerT20iInfoByName() {
        log.debug("Executing testFetchPlayerT20iInfoByName()...");
        Map<String,Object> getPlayerT20Info ;
        try {
            getPlayerT20Info = PlayerAppDao.fetchPlayerT20iInfoByName("Suryakumar yadav");
            assertThat(getPlayerT20Info).isNotNull();
            assertThat(getPlayerT20Info).hasSize(1);
            log.info("PlayerT20Data : {}",getPlayerT20Info);
        } catch (SQLException | IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }

    }

    @Test(priority = 7)
    public void testFetchPlayerT20iInfoByInvalidName() {
        log.debug("Executing testFetchPlayerT20iInfoByInvalidName()...");
        try {
            PlayerAppDao.fetchPlayerT20iInfoByName("Sur dav");
        }catch (IllegalArgumentException | SQLException e){
            assert true;
            log.info("Invalid playerName");
        }

    }
    @Test(priority = 8)
    public void testFetchPlayerT20iInfoByNameNull() {
        log.debug("Executing testFetchPlayerT20iInfoByNameNull()...");
        try {
            PlayerAppDao.fetchPlayerT20iInfoByName(null);
        } catch (IllegalArgumentException| SQLException Exception ) {
            assert true;
        }
    }

    @Test(priority = 9)
    public void testFetchPlayerT20iInfoByNameEmpty() {
        log.debug("Executing testFetchPlayerT20iInfoByNameEmpty()...");

        try {
            PlayerAppDao.fetchPlayerT20iInfoByName("");
        } catch (IllegalArgumentException| SQLException Exception ) {
            assert true;
        }
    }

    @Test(priority = 10)
    public void testFetchPlayerODIInfoByName() {
        log.debug("Executing testFetchPlayerODIInfoByName()...");
        Map<String,Object> getPlayerODIInfo;
        try {
            getPlayerODIInfo = PlayerAppDao.fetchPlayerODIInfoByName("Mithali Raj");
            assertThat(getPlayerODIInfo).isNotNull();
            assertThat(getPlayerODIInfo).hasSize(1);
            log.info("playerOdiData : {}",getPlayerODIInfo);
        } catch (SQLException | IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }

    }

    @Test(priority = 11)
    public void testFetchPlayerODIInfoByInvalidName() {
        log.debug("Executing testFetchPlayerODIInfoByInvalidName()...");
        try {
            PlayerAppDao.fetchPlayerODIInfoByName("Mita rj");
        }catch (IllegalArgumentException | SQLException e){
            assert true;
            log.info("Invalid playerName");
        }
    }
    @Test(priority = 12)
    public void testFetchPlayerODIInfoByNameNull() {
        log.debug("Executing testFetchPlayerODIInfoByNameNull()...");
        try {
            PlayerAppDao.fetchPlayerODIInfoByName(null);
        } catch (IllegalArgumentException| SQLException Exception ) {
            assert true;
        }
    }
    @Test(priority = 13)
    public void testFetchPlayerODIInfoByNameEmpty() {
        log.debug("Executing testFetchPlayerODIInfoByNameEmpty()...");

            try {
            PlayerAppDao.fetchPlayerODIInfoByName("");
            } catch (IllegalArgumentException| SQLException Exception ) {
                assert true;
            }
    }

    @Test(priority = 14)
    public void testFetchPlayerTestInfoByName() {
        log.debug("Executing testFetchPlayerTestInfoByName()...");
        Map<String,Object> getPlayerTestInfo ;
        try {
            getPlayerTestInfo = PlayerAppDao.fetchPlayerTestInfoByName("Rohit Sharma");
            assertThat(getPlayerTestInfo).isNotNull();
            assertThat(getPlayerTestInfo).hasSize(1);
            log.info("PlayerTestData : {}",getPlayerTestInfo);
        } catch (SQLException | IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }

    }

    @Test(priority = 15)
    public void testFetchPlayerTestInfoByNameNull() {
        log.debug("Executing testFetchPlayerTestInfoByNameNull()...");

        try {
            PlayerAppDao.fetchPlayerTestInfoByName(null);
        }catch (IllegalArgumentException | SQLException e){
            assert true;
        }
    }
    @Test(priority = 16)
    public void testFetchPlayerTestInfoByInvalidName() {
        log.debug("Executing testFetchPlayerTestInfoByInvalidName()...");

        try {
            PlayerAppDao.fetchPlayerTestInfoByName("yuzvend chal");
        } catch (IllegalArgumentException| SQLException Exception ) {
            assert true;
            log.info("Invalid playerName");
        }
    }
    @Test(priority = 17)
    public void testFetchPlayerTestInfoByNameEmpty() {
        log.debug("Executing testFetchPlayerTestInfoByNameEmpty()...");

        try {
           PlayerAppDao.fetchPlayerTestInfoByName("");
        } catch (IllegalArgumentException| SQLException Exception ) {
            assert true;
        }
    }

    @Test(priority = 18)
    public void testFetchPlayerPersonalDataByName() {
        log.debug("Executing testFetchPlayerPersonalDataByName()...");
        Map<String,Object>  getPlayerPersonalInfo;
        try {
            getPlayerPersonalInfo = PlayerAppDao.fetchPlayerPersonalDataByName("Rishabh Pant");
            assertThat(getPlayerPersonalInfo).isNotNull();
            assertThat(getPlayerPersonalInfo).hasSize(1);
            log.info("PlayerPersonalInfo : {}",getPlayerPersonalInfo);
        } catch (SQLException | IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }

    }
    @Test(priority = 19)
    public void testFetchPlayerPersonalDataByNameInvalidName() {
        log.debug("Executing testFetchPlayerCareerDataByInvalidName()...");

        try {
            PlayerAppDao.fetchPlayerPersonalDataByName("Vir Koli");
        } catch (IllegalArgumentException| SQLException Exception ) {
            assert true;
            log.info("Invalid playerName");
        }


    }
    @Test(priority = 20)
    public void testFetchPlayerPersonalDataByNameNull() {
        log.debug("Executing testFetchPlayerPersonalDataByNameNul()...");
        try {
            PlayerAppDao.fetchPlayerPersonalDataByName(null);
        } catch (IllegalArgumentException| SQLException Exception ) {
            assert true;
        }

    }

    @Test(priority = 21)
    public void testFetchPlayerPersonalDataByNameEmpty() {
        log.debug("Executing testFetchPlayerPersonalDataByNameEmpty()...");
        try {
            PlayerAppDao.fetchPlayerPersonalDataByName("");
        } catch (IllegalArgumentException| SQLException Exception ) {
            assert true;
        }
    }

    @Test(priority = 22)
    public void testFetch5PlayerDataByGender() {
        log.debug("Executing testFetch5PlayerDataByGender()...");
        Map<String,Object>get5PlayerInfo;
        try{
            get5PlayerInfo = PlayerAppDao.fetch5PlayerDataByGender("male");
            assertThat(get5PlayerInfo).isNotNull();
            assertThat(get5PlayerInfo).hasSize(1);
            log.info("Top5ExperiencedPlayerInfo : {} ",get5PlayerInfo);
        } catch (SQLException | IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }


    }
    @Test(priority = 23)
    public void testFetch5PlayerDataByInvalidGender() {
        log.debug("Executing testFetch5PlayerDataByInvalidGender()...");
        try {
            PlayerAppDao.fetch5PlayerDataByGender("me");
        } catch (IllegalArgumentException| SQLException Exception ) {
            assert true;
            log.info("Invalid Gender");
        }
    }
    @Test(priority = 24)
    public void testFetch5PlayerDataByGenderNull() {
        log.debug("Executing testFetch5PlayerDataByGender()...");

        try{
            PlayerAppDao.fetch5PlayerDataByGender(null);
        } catch (IllegalArgumentException| SQLException Exception ) {
            assert true;
        }
    }
    @Test(priority = 25)
    public void testFetch5PlayerDataByGenderEmpty() {
        log.debug("Executing testFetch5PlayerDataByGender()...");
        try{
            PlayerAppDao.fetch5PlayerDataByGender("");
        } catch (IllegalArgumentException| SQLException Exception ) {
            assert true;
        }

    }
    @Test(priority = 26)
    public void testFetch5PlayerInfoByGender() {
        log.debug("Executing testFetch5PlayerInfoByGender()...");
        Map<String, Object>get5PlayersData ;
        try
        {
            get5PlayersData = PlayerAppDao.fetch5PlayerInfoByGender("female");
            assertThat(get5PlayersData).isNotNull();
            assertThat(get5PlayersData).hasSize(1);
            log.info("Top5CenturyScorerInfo : {}",get5PlayersData);
        } catch (SQLException | IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }

    }
    @Test(priority = 27)
    public void testFetch5PlayerInfoByInvalidGender() {
        log.debug("Executing testFetch5PlayerInfoByInvalidGender()...");
        try {
            PlayerAppDao.fetch5PlayerDataByGender("fmael");
        } catch (IllegalArgumentException| SQLException Exception ) {
            assert true;
            log.info("Invalid Gender");
        }
    }
    @Test(priority = 28)
    public void testFetch5PlayerInfoByGenderNull() {
        log.debug("Executing testFetch5PlayerInfoByGenderNull()...");
        try
        {
            PlayerAppDao.fetch5PlayerInfoByGender(null);
        } catch (IllegalArgumentException| SQLException Exception ) {
            assert true;
        }

    }
    @Test(priority = 29)
    public void testFetch5PlayerInfoByGenderEmpty() {
        log.debug("Executing testFetch5PlayerInfoByGenderEmpty()...");

        try
        {
            PlayerAppDao.fetch5PlayerInfoByGender("");
        } catch (IllegalArgumentException| SQLException Exception ) {
            assert true;
        }
    }
    @Test(priority = 30)
    public void testFetch3PlayerInfoByGender() {
        log.debug("Executing testFetch3PlayerInfoByGender()...");
        Map<String, Object> get3PlayerData ;
        try{
            get3PlayerData = PlayerAppDao.fetch3PlayerInfoByGender("female");
            assertNotNull(get3PlayerData);
            assertThat(get3PlayerData).hasSize(1);

            log.info(" Top3OdiWicketTakers : {}",get3PlayerData);
        } catch (SQLException | IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }
    @Test(priority = 31)
    public void testFetch3PlayerInfoByInvalidGender() {
        log.debug("Executing testFetch3PlayerInfoByInvalidGender()...");
        try {
            PlayerAppDao.fetch5PlayerDataByGender("mael");
        } catch (IllegalArgumentException| SQLException Exception ) {
            assert true;
            log.info("Invalid Gender");
        }
    }
    @Test(priority = 32)
    public void testFetch3PlayerInfoByGenderNull() {
        log.debug("Executing testFetch3PlayerInfoByGenderNull()...");

        try{
            PlayerAppDao.fetch3PlayerInfoByGender(null);
        } catch (IllegalArgumentException| SQLException Exception ) {
            assert true;
        }

    }
    @Test(priority = 33)
    public void testFetch3PlayerInfoByGenderEmpty() {
        log.debug("Executing testFetch3PlayerInfoByGenderEmpty()...");
        try{
            PlayerAppDao.fetch3PlayerInfoByGender("");
        } catch (IllegalArgumentException| SQLException Exception ) {
            assert true;
        }

    }

}
