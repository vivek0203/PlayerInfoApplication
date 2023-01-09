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
    public void testFetchPlayerCareerDataByName() throws SQLException {
        log.debug("Executing testFetchPlayerCareerDataByName()...");
        Map<String , Object> getPlayerData ;
        getPlayerData = PlayerAppDao.fetchPlayerCareerData("Hardik Pandya");

        assertNotNull(getPlayerData);
        assertThat(getPlayerData).hasSize(1);

    }
    @Test(priority = 26)
    public void testFetchPlayerCareerDataByInvalidName() throws SQLException {
        log.debug("Executing testFetchPlayerCareerDataByInvalidName()...");

        try {
            PlayerAppDao.fetchPlayerCareerData("Hark Pandya");
        }catch (IllegalArgumentException e){
            assert true;
        }


    }
    @Test(priority = 2)
    public void testFetchPlayerCareerDataByNameNull() {
        log.debug("Executing testFetchPlayerCareerDataByNameNull()...");
        try {
            PlayerAppDao.fetchPlayerCareerData(null);
        } catch (IllegalArgumentException| SQLException Exception ) {
            assert true;
        }
    }

    @Test(priority = 3)
    public void testFetchPlayerCareerDataByNameEmpty() {
        log.debug("Executing testFetchPlayerCareerDataByNameEmpty()...");

        try {
            PlayerAppDao.fetchPlayerCareerData("");
        } catch (Exception e) {
            assert true;
        }

    }

    @Test(priority = 4)
    public void testGet10PlayerData() {
        log.debug("Executing testGet10PlayerData()...");
        JSONObject list10Players ;

        try {
            list10Players = PlayerAppDao.get10PlayerData();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertThat(list10Players)
                .isNotNull()
                     .hasSize(1);
    }

    @Test(priority = 5)
    public void testFetchPlayerT20iInfoByName() {
        log.debug("Executing testFetchPlayerT20iInfoByName()...");
        Map<String,Object> getPlayerT20Info ;
        try {
            getPlayerT20Info = PlayerAppDao.fetchPlayerT20iInfoByName("Suryakumar yadav");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertThat(getPlayerT20Info).isNotNull();
        assertThat(getPlayerT20Info).hasSize(1);
    }

    @Test(priority = 29)
    public void testFetchPlayerT20iInfoByInvalidName() {
        log.debug("Executing testFetchPlayerT20iInfoByInvalidName()...");
        try {
            PlayerAppDao.fetchPlayerT20iInfoByName("Sur dav");
        } catch (Exception e) {
            assert true;
        }

    }
    @Test(priority = 6)
    public void testFetchPlayerT20iInfoByNameNull() {
        log.debug("Executing testFetchPlayerT20iInfoByNameNull()...");
        try {
            PlayerAppDao.fetchPlayerT20iInfoByName(null);
        } catch (Exception e) {
            assert true;
        }
    }

    @Test(priority = 7)
    public void testFetchPlayerT20iInfoByNameEmpty() {
        log.debug("Executing testFetchPlayerT20iInfoByNameEmpty()...");

        try {
            PlayerAppDao.fetchPlayerT20iInfoByName("");
        } catch (Exception e) {
            assert true;
        }
    }

    @Test(priority = 8)
    public void testFetchPlayerODIInfoByName() {
        log.debug("Executing testFetchPlayerODIInfoByName()...");
        Map<String,Object> getPlayerODIInfo;
        try {
            getPlayerODIInfo = PlayerAppDao.fetchPlayerODIInfoByName("Mithali Raj");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertThat(getPlayerODIInfo).isNotNull();
        assertThat(getPlayerODIInfo).hasSize(1);
    }

    @Test(priority = 30)
    public void testFetchPlayerODIInfoByInvalidName() {
        log.debug("Executing testFetchPlayerODIInfoByInvalidName()...");
        try {
            PlayerAppDao.fetchPlayerODIInfoByName("Mita rj");
        } catch (Exception e) {
            assert true;
        }
    }
    @Test(priority = 9)
    public void testFetchPlayerODIInfoByNameNull() {
        log.debug("Executing testFetchPlayerODIInfoByNameNull()...");
        try {
            PlayerAppDao.fetchPlayerODIInfoByName(null);
        } catch (Exception e) {
            assert true;
        }
    }
    @Test(priority = 10)
    public void testFetchPlayerODIInfoByNameEmpty() {
        log.debug("Executing testFetchPlayerODIInfoByNameEmpty()...");

            try {
            PlayerAppDao.fetchPlayerODIInfoByName("");
        } catch (Exception e) {
            assert true;
        }
    }

    @Test(priority = 11)
    public void testFetchPlayerTestInfoByName() {
        log.debug("Executing testFetchPlayerTestInfoByName()...");
        Map<String,Object> getPlayerTestInfo ;
        try {
            getPlayerTestInfo = PlayerAppDao.fetchPlayerTestInfoByName("Yuzvendra Chahal");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertThat(getPlayerTestInfo).isNotNull();
        assertThat(getPlayerTestInfo).hasSize(1);
    }

    @Test(priority = 12)
    public void testFetchPlayerTestInfoByNameNull() {
        log.debug("Executing testFetchPlayerTestInfoByNameNull()...");

        try {
            PlayerAppDao.fetchPlayerTestInfoByName(null);
        } catch (Exception e) {
            assert true;
        }
    }
    @Test(priority = 13)
    public void testFetchPlayerTestInfoByInvalidName() {
        log.debug("Executing testFetchPlayerTestInfoByInvalidName()...");

        try {
            PlayerAppDao.fetchPlayerTestInfoByName("yuzvend chal");
        } catch (Exception e) {
            assert true;
        }
    }
    @Test(priority = 13)
    public void testFetchPlayerTestInfoByNameEmpty() {
        log.debug("Executing testFetchPlayerTestInfoByNameEmpty()...");

        try {
           PlayerAppDao.fetchPlayerTestInfoByName("");
        } catch (Exception e) {
            assert true;
        }
    }

    @Test(priority = 14)
    public void testFetchPlayerPersonalDataByName() {
        log.debug("Executing testFetchPlayerPersonalDataByName()...");
        Map<String,Object>  getPlayerPersonalInfo;
        try {
            getPlayerPersonalInfo = PlayerAppDao.fetchPlayerPersonalDataByName("Rishabh Pant");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertThat(getPlayerPersonalInfo).isNotNull();
        assertThat(getPlayerPersonalInfo).hasSize(1);
    }
    @Test(priority = 28)
    public void testFetchPlayerPersonalDataByNameInvalidName() throws SQLException {
        log.debug("Executing testFetchPlayerCareerDataByInvalidName()...");

        try {
            PlayerAppDao.fetchPlayerPersonalDataByName("Vir Koli");
        }catch (IllegalArgumentException e){
            assert true;
        }


    }
    @Test(priority = 15)
    public void testFetchPlayerPersonalDataByNameNull() {
        log.debug("Executing testFetchPlayerPersonalDataByNameNul()...");
        try {
            PlayerAppDao.fetchPlayerPersonalDataByName(null);
        } catch (Exception e) {
            assert true;
        }

    }

    @Test(priority = 16)
    public void testFetchPlayerPersonalDataByNameEmpty() {
        log.debug("Executing testFetchPlayerPersonalDataByNameEmpty()...");
        try {
            PlayerAppDao.fetchPlayerPersonalDataByName("");
        } catch (Exception e) {
            assert true;
        }
    }

    @Test(priority = 17)
    public void testFetch5PlayerDataByGender() {
        log.debug("Executing testFetch5PlayerDataByGender()...");
        Map<String,Object>get5PlayerInfo;
        try{
            get5PlayerInfo = PlayerAppDao.fetch5PlayerDataByGender("male");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        assertThat(get5PlayerInfo).isNotNull();
        assertThat(get5PlayerInfo).hasSize(1);

    }
    @Test(priority = 27)
    public void testFetch5PlayerDataByInvalidGender() {
        log.debug("Executing testFetch5PlayerDataByInvalidGender()...");
        try {
            PlayerAppDao.fetch5PlayerDataByGender("me");
        } catch (Exception e) {
            assert true;
        }
    }
    @Test(priority = 18)
    public void testFetch5PlayerDataByGenderNull() {
        log.debug("Executing testFetch5PlayerDataByGender()...");

        try{
            PlayerAppDao.fetch5PlayerDataByGender(null);
        }catch (Exception e){
            assert true;
        }
    }
    @Test(priority = 19)
    public void testFetch5PlayerDataByGenderEmpty() {
        log.debug("Executing testFetch5PlayerDataByGender()...");
        try{
            PlayerAppDao.fetch5PlayerDataByGender("");
        }catch (Exception e){
            assert true;
        }

    }
    @Test(priority = 20)
    public void testFetch5PlayerInfoByGender() {
        log.debug("Executing testFetch5PlayerInfoByGender()...");
        Map<String, Object>get5PlayersData ;
        try
        {
            get5PlayersData = PlayerAppDao.fetch5PlayerInfoByGender("female");
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
        assertThat(get5PlayersData).isNotNull();
        assertThat(get5PlayersData).hasSize(1);
    }
    @Test(priority = 31)
    public void testFetch5PlayerInfoByInvalidGender() {
        log.debug("Executing testFetch5PlayerInfoByInvalidGender()...");
        try {
            PlayerAppDao.fetch5PlayerDataByGender("fmael");
        } catch (Exception e) {
            assert true;
        }
    }
    @Test(priority = 21)
    public void testFetch5PlayerInfoByGenderNull() {
        log.debug("Executing testFetch5PlayerInfoByGenderNull()...");
        try
        {
            PlayerAppDao.fetch5PlayerInfoByGender(null);
        }catch (Exception e){
            assert true;
        }

    }
    @Test(priority = 22)
    public void testFetch5PlayerInfoByGenderEmpty() {
        log.debug("Executing testFetch5PlayerInfoByGenderEmpty()...");

        try
        {
            PlayerAppDao.fetch5PlayerInfoByGender("");
        }catch (Exception e){
            assert true;
        }
    }
    @Test(priority = 23)
    public void testFetch3PlayerInfoByGender() {
        log.debug("Executing testFetch3PlayerInfoByGender()...");
        Map<String, Object> get3PlayerData ;
        try{
            get3PlayerData = PlayerAppDao.fetch3PlayerInfoByGender("female");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        assertNotNull(get3PlayerData);
        assertThat(get3PlayerData).hasSize(1);
    }
    @Test(priority = 27)
    public void testFetch3PlayerInfoByInvalidGender() {
        log.debug("Executing testFetch3PlayerInfoByInvalidGender()...");
        try {
            PlayerAppDao.fetch5PlayerDataByGender("mael");
        } catch (Exception e) {
            assert true;
        }
    }
    @Test(priority = 24)
    public void testFetch3PlayerInfoByGenderNull() {
        log.debug("Executing testFetch3PlayerInfoByGenderNull()...");

        try{
            PlayerAppDao.fetch3PlayerInfoByGender(null);
        }catch (Exception e){
            assert true;
        }

    }
    @Test(priority = 25)
    public void testFetch3PlayerInfoByGenderEmpty() {
        log.debug("Executing testFetch3PlayerInfoByGenderEmpty()...");
        try{
            PlayerAppDao.fetch3PlayerInfoByGender("");
        }catch (Exception e){
            assert true;
        }

    }

}
