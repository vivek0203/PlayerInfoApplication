

CREATE  TABLE IF NOT EXISTS player_career_info (
  ranking int(6) NOT NULL AUTO_INCREMENT,
  player_name varchar(20) NOT NULL,
  player_specification varchar(20) DEFAULT NULL,
  player_total_matches int(6) DEFAULT NULL,
  player_centuries int(6) DEFAULT NULL,
  player_half_centuries int(6) DEFAULT NULL,
  player_five_wickets int(6) DEFAULT NULL,
  player_total_hatricks int(6) DEFAULT NULL,
  total_ODI_matches int(5) NOT NULL,
  total_Test_matches int(5) NOT NULL,
  total_T20i_matches int(5) NOT NULL,
  total_odi_wickets int(6) DEFAULT NULL,
  total_t20i_wickets int(6) DEFAULT NULL,
  total_test_wickets int(6) DEFAULT NULL,
  player_odi_runs int(7) DEFAULT NULL,
  player_t20i_runs int(7) DEFAULT NULL,
  player_test_runs int(7) DEFAULT NULL,
  PRIMARY KEY (ranking)
)



CREATE TABLE IF NOT EXISTS player_personal_info(
  player_ranking int(6) NOT NULL AUTO_INCREMENT,
  name varchar(20) NOT NULL,
  age int(2) NOT NULL,
  gender varchar(7) NOT NULL,
  state varchar(20) NOT NULL,
  PRIMARY KEY (player_ranking)
)
