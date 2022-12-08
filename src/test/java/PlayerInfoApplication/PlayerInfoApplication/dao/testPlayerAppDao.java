package PlayerInfoApplication.PlayerInfoApplication.dao;



import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class testPlayerAppDao {
    PlayerAppDao playerAppDao;
    private static final Logger log = LoggerFactory.getLogger(testPlayerAppDao.class);

    @Test(priority = 1,description = "Valid name is provided")
    public void testFetchPlayerCareerDataByName() {
        log.debug("Executing testFetchPlayerCareerDataByName()...");
        Map<String , Object> getPlayerData ;
        try {
            getPlayerData = playerAppDao.fetchPlayerCareerData("Suryakumar Yadav");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertNotNull(getPlayerData);
        assertThat(getPlayerData.size()).isEqualTo(1);


    }

    @Test(priority = 2)
    public void testFetchPlayerCareerDataByNameNull() {
        log.debug("Executing testFetchPlayerCareerDataByNameNull()...");
        Map<String,Object>getPlayerData;
        try {
            getPlayerData = playerAppDao.fetchPlayerCareerData("null");
        } catch (Exception e) {
            assert true;
        }

    }

    @Test(priority = 3)
    public void testFetchPlayerCareerDataByNameEmpty() {
        log.debug("Executing testFetchPlayerCareerDataByNameEmpty()...");
        Map<String,Object>getPlayerData ;
        try {
            getPlayerData = playerAppDao.fetchPlayerCareerData("1");
        } catch (Exception e) {
            assert true;
        }

    }

    @Test(priority = 4)
    public void testGet10PlayerData() {
        log.debug("Executing testGet10PlayerData()...");
        JSONObject list10Players ;

        try {
            list10Players = playerAppDao.get10PlayerData();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertThat(list10Players).isNotNull();
        assertThat(list10Players.size()).isEqualTo(1);
    }

    @Test(priority = 5)
    public void testFetchPlayerT20iInfoByName() {
        log.debug("Executing testFetchPlayerT20iInfoByName()...");
        Map<String,Object> getPlayerT20Info ;
        try {
            getPlayerT20Info = playerAppDao.fetchPlayerT20iInfoByName("Yuzvendra Chahal");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertThat(getPlayerT20Info).isNotNull();
        assertThat(getPlayerT20Info.size()).isEqualTo(1);


    }

    @Test(priority = 6)
    public void testFetchPlayerT20iInfoByNameNull() {
        log.debug("Executing testFetchPlayerT20iInfoByNameNull()...");
        Map<String,Object> getPlayerT20Info ;
        try {
            getPlayerT20Info = playerAppDao.fetchPlayerT20iInfoByName("null");
        } catch (Exception e) {
            assert true;
        }
    }

    @Test(priority = 7)
    public void testFetchPlayerT20iInfoByNameEmpty() {
        log.debug("Executing testFetchPlayerT20iInfoByNameEmpty()...");
        Map<String,Object> getPlayerT20Info;
        try {
            getPlayerT20Info = playerAppDao.fetchPlayerT20iInfoByName("");
        } catch (Exception e) {
            assert true;
        }
    }

    @Test(priority = 8)
    public void testFetchPlayerODIInfoByName() {
        log.debug("Executing testFetchPlayerODIInfoByName()...");
        Map<String,Object> getPlayerODIInfo;
        try {
            getPlayerODIInfo = playerAppDao.fetchPlayerODIInfoByName("Mithali Raj");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertThat(getPlayerODIInfo).isNotNull();
        assertThat(getPlayerODIInfo.size()).isEqualTo(1);
    }

    @Test(priority = 9)
    public void testFetchPlayerODIInfoByNameNull() {
        log.debug("Executing testFetchPlayerODIInfoByNameNull()...");
        Map<String,Object>  getPlayerODIInfo ;
        try {
            getPlayerODIInfo = playerAppDao.fetchPlayerODIInfoByName("Null");
        } catch (Exception e) {
            assert true;
        }
    }

    @Test(priority = 10)
    public void testFetchPlayerODIInfoByNameEmpty() {
        log.debug("Executing testFetchPlayerODIInfoByNameEmpty()...");
        Map<String,Object> getPlayerODIInfo ;
        try {
            getPlayerODIInfo = playerAppDao.fetchPlayerODIInfoByName("");
        } catch (Exception e) {
            assert true;
        }
    }

    @Test(priority = 11)
    public void testFetchPlayerTestInfoByName() {
        log.debug("Executing testFetchPlayerTestInfoByName()...");
        Map<String,Object> getPlayerTestInfo ;
        try {
            getPlayerTestInfo = playerAppDao.fetchPlayerTestInfoByName("Yuzvendra Chahal");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertThat(getPlayerTestInfo).isNotNull();
        assertThat(getPlayerTestInfo.size()).isEqualTo(1);
    }

    @Test(priority = 12)
    public void testFetchPlayerTestInfoByNameNull() {
        log.debug("Executing testFetchPlayerTestInfoByNameNull()...");
        Map<String,Object> getPlayerTestInfo ;
        try {
            getPlayerTestInfo = playerAppDao.fetchPlayerTestInfoByName("null");
        } catch (Exception e) {
            assert true;
        }
    }

    @Test(priority = 13)
    public void testFetchPlayerTestInfoByNameEmpty() {
        log.debug("Executing testFetchPlayerTestInfoByNameEmpty()...");
        Map<String,Object> getPlayerTestInfo ;
        try {
            getPlayerTestInfo = playerAppDao.fetchPlayerTestInfoByName("");
        } catch (Exception e) {
            assert true;
        }
    }

    @Test(priority = 14)
    public void testFetchPlayerPersonalDataByName() {
        log.debug("Executing testFetchPlayerPersonalDataByName()...");
        Map<String,Object>  getPlayerPersonalInfo;
        try {
            getPlayerPersonalInfo = playerAppDao.fetchPlayerPersonalDataByName("Rishabh Pant");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertThat(getPlayerPersonalInfo).isNotNull();
        assertThat(getPlayerPersonalInfo.size()).isEqualTo(1);
    }

    @Test(priority = 15)
    public void testFetchPlayerPersonalDataByNameNull() {
        log.debug("Executing testFetchPlayerPersonalDataByNameNul()...");
        Map<String,Object> getPlayerPersonalInfo ;
        try {
            getPlayerPersonalInfo = playerAppDao.fetchPlayerPersonalDataByName("null");
        } catch (Exception e) {
            assert true;
        }
    }

    @Test(priority = 16)
    public void testFetchPlayerPersonalDataByNameEmpty() {
        log.debug("Executing testFetchPlayerPersonalDataByNameEmpty()...");
        Map<String,Object> getPlayerPersonalInfo;
        try {
            getPlayerPersonalInfo = playerAppDao.fetchPlayerPersonalDataByName("");
        } catch (Exception e) {
            assert true;
        }

    }

    @Test(priority = 17)
    public void testFetch5PlayerDataByGender() {
        log.debug("Executing testFetch5PlayerDataByGender()...");
        Map<String,Object>get5PlayerInfo;
        try{
            get5PlayerInfo = playerAppDao.fetch5PlayerDataByGender("male");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        assertThat(get5PlayerInfo).isNotNull();
        assertThat(get5PlayerInfo.size()).isEqualTo(1);

    }
    @Test(priority = 18)
    public void testFetch5PlayerDataByGenderNull() {
        log.debug("Executing testFetch5PlayerDataByGender()...");
        Map<String,Object> get5PlayerInfo;
        try{
            get5PlayerInfo = playerAppDao.fetch5PlayerDataByGender("null");
        }catch (Exception e){
            assert true;
        }
    }
    @Test(priority = 19)
    public void testFetch5PlayerDataByGenderEmpty() {
        log.debug("Executing testFetch5PlayerDataByGender()...");
        Map<String,Object> get5PlayerInfo;
        try{
            get5PlayerInfo = playerAppDao.fetch5PlayerDataByGender("");
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
            get5PlayersData = playerAppDao.fetch5PlayerInfoByGender("female");
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
        assertThat(get5PlayersData).isNotNull();
        assertThat(get5PlayersData.size()).isEqualTo(1);
    }
    @Test(priority = 21)
    public void testFetch5PlayerInfoByGenderNull() {
        log.debug("Executing testFetch5PlayerInfoByGenderNull()...");
        Map<String, Object> get5PlayersData ;
        try
        {
            get5PlayersData = playerAppDao.fetch5PlayerInfoByGender("null");
        }catch (Exception e){
            assert true;
        }

    }
    @Test(priority = 22)
    public void testFetch5PlayerInfoByGenderEmpty() {
        log.debug("Executing testFetch5PlayerInfoByGenderEmpty()...");
        Map<String, Object> get5PlayersData;
        try
        {
            get5PlayersData = playerAppDao.fetch5PlayerInfoByGender(" ");
        }catch (Exception e){
            assert true;
        }

    }
    @Test(priority = 23)
    public void testFetch3PlayerInfoByGender() {
        log.debug("Executing testFetch3PlayerInfoByGender()...");
        Map<String, Object> get3PlayerData ;
        try{
            get3PlayerData = playerAppDao.fetch3PlayerInfoByGender("female");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        assertNotNull(get3PlayerData);
        assertThat(get3PlayerData.size()).isEqualTo(1);
    }
    @Test(priority = 24)
    public void testFetch3PlayerInfoByGenderNull() {
        log.debug("Executing testFetch3PlayerInfoByGender()...");
        Map<String, Object>get3PlayerData ;
        try{
            get3PlayerData = playerAppDao.fetch3PlayerInfoByGender("null");
        }catch (Exception e){
            assert true;
        }

    }
    @Test(priority = 25)
    public void testFetch3PlayerInfoByGenderEmpty() {
        log.debug("Executing testFetch3PlayerInfoByGender()...");
        Map<String,Object> get3PlayerData;
        try{
            get3PlayerData = playerAppDao.fetch3PlayerInfoByGender("female");
        }catch (Exception e){
            assert true;
        }

    }

}
