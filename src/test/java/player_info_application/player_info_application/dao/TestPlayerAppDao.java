package player_info_application.player_info_application.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.testng.Assert.*;


public class TestPlayerAppDao {

    private static final Logger log = LoggerFactory.getLogger(TestPlayerAppDao.class);


    @Test(priority = 1)
    public void testFetchPlayerCareerDataByName() throws SQLException {
        log.debug("Executing testFetchPlayerCareerDataByName()...");
        Map<String, Map<String,Object>>   playerCareerInfo;

            playerCareerInfo = PlayerAppDao.fetchPlayerCareerData("Hardik pandya");
            assertNotNull(playerCareerInfo);
            assertThat(playerCareerInfo).hasSize(1);
            log.info("PlayerCareerInfo : {}",playerCareerInfo);
        log.info("Exiting from TestPlayerAppDao.testFetchPlayerCareerDataByName()");
    }
    @Test(priority = 2)
    public void testFetchPlayerCareerDataByInvalidName() throws SQLException {
        log.debug("Executing testFetchPlayerCareerDataByInvalidName()...");
        try {
            PlayerAppDao.fetchPlayerCareerData("Hark Pndya");
        }catch (IllegalArgumentException e){
            assert true;
            log.error("Invalid playerName",e);

        }
    }
    @Test(priority = 3)
    public void testFetchPlayerCareerDataByNameNull() throws SQLException {
        log.debug("Executing testFetchPlayerCareerDataByNameNull()...");
        try {
            PlayerAppDao.fetchPlayerCareerData(null);
        } catch (IllegalArgumentException e) {
            assert true;
            log.error("player name cannot be  null",e);
        }
    }
    @Test(priority = 4)
    public void testFetchPlayerCareerDataByNameEmpty() throws SQLException {
        log.debug("Executing testFetchPlayerCareerDataByNameEmpty()...");

        try {
            PlayerAppDao.fetchPlayerCareerData("");
        } catch (IllegalArgumentException e) {
            assert true;
        }
    }
    @Test(priority = 5)
    public void testGet10PlayerData() throws SQLException {
        log.debug("Executing testGet10PlayerData()...");
        Map<String, Map<String, Object>> list10Players;

            list10Players = PlayerAppDao.get10PlayerData();
            assertThat(list10Players)
                    .isNotNull()
                    .hasSize(10);
            log.info("PlayerFullInfo : {}", list10Players);

    }
    @Test(priority = 6)
    public void testFetchPlayerT20iInfoByName() throws SQLException {
        log.debug("Executing testFetchPlayerT20iInfoByName()...");
        Map<String, Map<String, Object>> playerT20Info ;

            playerT20Info = PlayerAppDao.fetchPlayerT20iInfoByName("Shubhman gill");
            assertThat(playerT20Info).isNotNull();
            assertThat(playerT20Info).hasSize(1);
            log.info("PlayerT20Data : {}",playerT20Info);
    }
    @Test(priority = 7)
    public void testFetchPlayerT20iInfoByInvalidName() throws SQLException {
        log.debug("Executing testFetchPlayerT20iInfoByInvalidName()...");
         try {
             PlayerAppDao.fetchPlayerT20iInfoByName("Sur dav");
        }catch (IllegalArgumentException e){
            assert true;
            log.error("Invalid playerName",e);
        }
    }
    @Test(priority = 8)
    public void testFetchPlayerT20iInfoByNameNull() throws SQLException {
        log.debug("Executing testFetchPlayerT20iInfoByNameNull()...");
        try {
            PlayerAppDao.fetchPlayerT20iInfoByName(null);
        } catch (IllegalArgumentException e) {
            assert true;
            log.error("player name cannot be  null",e);
        }
    }
    @Test(priority = 9)
    public void testFetchPlayerT20iInfoByNameEmpty() throws SQLException {
        log.debug("Executing testFetchPlayerT20iInfoByNameEmpty()...");
        try {
            PlayerAppDao.fetchPlayerT20iInfoByName("");
        } catch (IllegalArgumentException e) {
            assert true;
        }
    }
    @Test(priority = 10)
    public void testFetchPlayerODIInfoByName() throws SQLException {
        log.debug("Executing testFetchPlayerODIInfoByName()...");
        Map<String, Map<String, Object>> getPlayerODIInfo;

            getPlayerODIInfo = PlayerAppDao.fetchPlayerODIInfoByName("Mithali Raj");
            assertThat(getPlayerODIInfo).isNotNull();
            assertThat(getPlayerODIInfo).hasSize(1);
            log.info("playerOdiData : {}",getPlayerODIInfo);
    }
    @Test(priority = 11)
    public void testFetchPlayerODIInfoByInvalidName() throws SQLException {
        log.debug("Executing testFetchPlayerODIInfoByInvalidName()...");
        try {
            PlayerAppDao.fetchPlayerODIInfoByName("Mita rj");
        }catch (IllegalArgumentException e){
            assert true;
            log.error("Invalid playerName",e);
        }
    }
    @Test(priority = 12)
    public void testFetchPlayerODIInfoByNameNull() throws SQLException {
        log.debug("Executing testFetchPlayerODIInfoByNameNull()...");
        try {
            PlayerAppDao.fetchPlayerODIInfoByName(null);
        } catch (IllegalArgumentException e ) {
            assert true;
        }
    }
    @Test(priority = 13)
    public void testFetchPlayerODIInfoByNameEmpty() throws SQLException {
        log.debug("Executing testFetchPlayerODIInfoByNameEmpty()...");
            try {
                PlayerAppDao.fetchPlayerODIInfoByName("");
            } catch (IllegalArgumentException e ) {
                assert true;
            }
    }
    @Test(priority = 14)
    public void testFetchPlayerTestInfoByName() throws SQLException {
        log.debug("Executing testFetchPlayerTestInfoByName()...");
        Map<String, Map<String, Object>> getPlayerTestInfo ;

            getPlayerTestInfo = PlayerAppDao.fetchPlayerTestInfoByName("rohit sharma");
            assertThat(getPlayerTestInfo).isNotNull();
            assertThat(getPlayerTestInfo).hasSize(1);
            log.info("PlayerTestData : {}",getPlayerTestInfo);
    }
    @Test(priority = 15)
    public void testFetchPlayerTestInfoByNameNull() throws SQLException {
        log.debug("Executing testFetchPlayerTestInfoByNameNull()...");
        try {
            PlayerAppDao.fetchPlayerTestInfoByName(null);
        }catch (IllegalArgumentException e){
            assert true;
            log.error("player name cannot be  null",e);
        }
    }
    @Test(priority = 16)
    public void testFetchPlayerTestInfoByInvalidName() throws SQLException {
        log.debug("Executing testFetchPlayerTestInfoByInvalidName()...");
        try {
            PlayerAppDao.fetchPlayerTestInfoByName("yuzvend chal");
        } catch (IllegalArgumentException e) {
            assert true;
            log.error("Invalid playerName",e);
        }
    }
    @Test(priority = 17)
    public void testFetchPlayerTestInfoByNameEmpty() throws SQLException {
        log.debug("Executing testFetchPlayerTestInfoByNameEmpty()...");
        try {
            PlayerAppDao.fetchPlayerTestInfoByName("");
        } catch (IllegalArgumentException e) {
            assert true;
        }
    }
    @Test(priority = 18)
    public void testFetchPlayerPersonalDataByName() throws SQLException {
        log.debug("Executing testFetchPlayerPersonalDataByName()...");
        Map<String, Map<String, Object>>  getPlayerPersonalInfo;

            getPlayerPersonalInfo = PlayerAppDao.fetchPlayerPersonalDataByName("Rishabh Pant");
            assertThat(getPlayerPersonalInfo).isNotNull();
            assertThat(getPlayerPersonalInfo).hasSize(1);
            log.info("PlayerPersonalInfo : {}",getPlayerPersonalInfo);
    }
    @Test(priority = 19)
    public void testFetchPlayerPersonalDataByNameInvalidName() throws SQLException {
        log.debug("Executing testFetchPlayerCareerDataByInvalidName()...");
        try {
            PlayerAppDao.fetchPlayerPersonalDataByName("Vir Koli");
        } catch (IllegalArgumentException e ) {
            assert true;
            log.error("Invalid playerName",e);
        }
    }
    @Test(priority = 20)
    public void testFetchPlayerPersonalDataByNameNull() throws SQLException {
        log.debug("Executing testFetchPlayerPersonalDataByNameNul()...");
        try {
            PlayerAppDao.fetchPlayerPersonalDataByName(null);
        } catch (IllegalArgumentException e) {
            assert true;
            log.error("player name cannot be  null",e);
        }
    }
    @Test(priority = 21)
    public void testFetchPlayerPersonalDataByNameEmpty() throws SQLException {
        log.debug("Executing testFetchPlayerPersonalDataByNameEmpty()...");
        try {
            PlayerAppDao.fetchPlayerPersonalDataByName("");
        } catch (IllegalArgumentException e ) {
            assert true;
        }
    }
    @Test(priority = 22)
    public void testFetch5PlayerDataByGender() throws SQLException {
        log.debug("Executing testFetch5PlayerDataByGender()...");
        Map<String, Map<String, Object>>get5PlayerInfo;
            get5PlayerInfo = PlayerAppDao.fetch5PlayerDataByGender("Mal");
            assertThat(get5PlayerInfo).isNotNull();
            assertThat(get5PlayerInfo).hasSize(5);
            log.info("Top5ExperiencedPlayerInfo : {} ",get5PlayerInfo);
    }
    @Test(priority = 23)
    public void testFetch5PlayerDataByInvalidGender() throws SQLException {
        log.debug("Executing testFetch5PlayerDataByInvalidGender()...");
        try {
            PlayerAppDao.fetch5PlayerDataByGender("el");
        } catch (IllegalArgumentException e) {
            assert true;
            log.error("Invalid Gender",e);
        }
    }
    @Test(priority = 24)
    public void testFetch5PlayerDataByGenderNull() throws SQLException {
        log.debug("Executing testFetch5PlayerDataByGender()...");
        try{
            PlayerAppDao.fetch5PlayerDataByGender(null);
        } catch (IllegalArgumentException e ) {
            assert true;
        }
    }
    @Test(priority = 25)
    public void testFetch5PlayerDataByGenderEmpty() throws SQLException {
        log.debug("Executing testFetch5PlayerDataByGender()...");
        try{
            PlayerAppDao.fetch5PlayerDataByGender("");
        } catch (IllegalArgumentException e ) {
            assert true;

        }
    }
    @Test(priority = 26)
    public void testFetch5PlayerInfoByGender() throws SQLException {
        log.debug("Executing testFetch5PlayerInfoByGender()...");
        Map<String, Map<String, Object>>get5PlayersData ;
            get5PlayersData = PlayerAppDao.fetch5PlayerInfoByGender("fema");
            assertThat(get5PlayersData).isNotNull();
            assertThat(get5PlayersData).hasSize(5);
            log.info("Top5CenturyScorerInfo : {}",get5PlayersData);
    }
    @Test(priority = 27)
    public void testFetch5PlayerInfoByInvalidGender() throws SQLException {
        log.debug("Executing testFetch5PlayerInfoByInvalidGender()...");
        Map<String, Map<String, Object>>get5PlayersData ;
        try {
            get5PlayersData = PlayerAppDao.fetch5PlayerInfoByGender("fmle");
            assertThat(get5PlayersData).isNull();
        } catch (IllegalArgumentException e) {
            assert true;
            log.error("Invalid Gender",e);
        }
    }
    @Test(priority = 28)
    public void testFetch5PlayerInfoByGenderNull() throws SQLException {
        log.debug("Executing testFetch5PlayerInfoByGenderNull()...");
        try {
            PlayerAppDao.fetch5PlayerInfoByGender(null);
        } catch (IllegalArgumentException e) {
            assert true;
        }
    }
    @Test(priority = 29)
    public void testFetch5PlayerInfoByGenderEmpty() throws SQLException {
        log.debug("Executing testFetch5PlayerInfoByGenderEmpty()...");
        try
        {
            PlayerAppDao.fetch5PlayerInfoByGender("");
        } catch (IllegalArgumentException e ) {
            assert true;
        }
    }
    @Test(priority = 30)
    public void testFetch3PlayerInfoByGender() throws SQLException {
        log.debug("Executing testFetch3PlayerInfoByGender()...");
        Map<String, Map<String,Object> > get3PlayerData ;
            get3PlayerData =PlayerAppDao.fetch3PlayerInfoByGender("Female");
            assertNotNull(get3PlayerData);
            assertThat(get3PlayerData).hasSize(3);

            log.info(" Top3OdiWicketTakers : {}",get3PlayerData);
    }
    @Test(priority = 31)
    public void testFetch3PlayerInfoByInvalidGender() throws SQLException {
        log.debug("Executing testFetch3PlayerInfoInvalidByGender()...");
        Map<String, Map<String,Object> > get3PlayerData ;
        try{
            get3PlayerData =PlayerAppDao.fetch3PlayerInfoByGender("Fee");
            assertNull(get3PlayerData);
        } catch (IllegalArgumentException e) {
           assert  true;
           log.error("Invalid Gender",e);
        }
    }
    @Test(priority = 32)
    public void testFetch3PlayerInfoByGenderNull() throws SQLException {
        log.debug("Executing testFetch3PlayerInfoByGenderNull()...");
        try{
            PlayerAppDao.fetch3PlayerInfoByGender(null);
        } catch (IllegalArgumentException e) {
            assert true;
        }
    }
    @Test(priority = 33)
    public void testFetch3PlayerInfoByGenderEmpty() throws SQLException {
        log.debug("Executing testFetch3PlayerInfoByGenderEmpty()...");
        try{
            PlayerAppDao.fetch3PlayerInfoByGender("");
        } catch (IllegalArgumentException e ) {
            assert true;
        }
    }
    @Test(priority = 34)
    public void  testFetchAnyNoOfPlayerInfoByName() throws SQLException {
        log.debug("Executing testFetchAnyNoOfPlayerInfo()...");
        Map<List<String>, List<Map<String, Object>>> getPlayersInfo;
            List<String> playersName = new ArrayList<>();
            playersName.add("Vi");
            playersName.add("sharma");
            getPlayersInfo = PlayerAppDao.fetchAnyNoOfPlayerInfo(playersName);
            assertThat(getPlayersInfo).isNotNull();
            assertThat(getPlayersInfo.size()).isEqualTo(1);
            log.info("Players Information : {}",getPlayersInfo);
    }
    @Test(priority = 35)
    public void  testFetchAnyNoOfPlayerInfoByAllInvalidNames() throws SQLException {
        log.debug("Executing testFetchAnyNoOfPlayerInfoByAllInvalidNames()...");
        try {
            List<String> playersName = new ArrayList<>();
            playersName.add("Koi");
            playersName.add("Roit Srma");
            playersName.add("sryamar yv");
            playersName.add("Harmet ur");
            PlayerAppDao.fetchAnyNoOfPlayerInfo(playersName);
        } catch (IllegalArgumentException e) {
            assert true;
            log.info("invalid player name",e);
        }
    }
    @Test(priority = 36)
    public void  testFetchAnyNoOfPlayerInfoByAllNameNull() throws SQLException {
        log.debug("Executing testFetchAnyNoOfPlayerInfoByAllNameNull()...");
        try {
            List<String> playersName = new ArrayList<>();
            playersName.add(null);
            playersName.add(null);
            PlayerAppDao.fetchAnyNoOfPlayerInfo(playersName);
        } catch (IllegalArgumentException e) {
            assert true;
            log.error("player name cannot be  null",e);
        }
    }
}
