package PlayerInfoApplication.PlayerInfoApplication.entity;

public class PlayerCareerInfo {
    private  Integer id;
    private String player_name;
    private String player_specification;
    private Integer player_total_matches;
    private Integer player_centuries;
    private Integer player_half_centuries;
    private Integer player_five_wickets;
    private Integer player_total_hatricks;
    private Integer total_ODI_matches;
    private Integer total_Test_matches;
    private Integer total_T20i_matches;
    private Integer total_odi_wickets;
    private Integer total_t20i_wickets;
    private Integer total_test_wickets;
    private Integer player_odi_runs;
    private Integer player_t20i_runs;
    private Integer player_test_runs;


    public PlayerCareerInfo(Integer id, String player_name, String player_specification, Integer player_total_matches, Integer player_centuries, Integer player_half_centuries, Integer player_five_wickets, Integer player_total_hatricks, Integer total_ODI_matches, Integer total_Test_matches, Integer total_T20i_matches, Integer total_odi_wickets, Integer total_t20i_wickets, Integer total_test_wickets, Integer player_odi_runs, Integer player_t20i_runs, Integer player_test_runs) {
        this.id = id;
        this.player_name = player_name;
        this.player_specification = player_specification;
        this.player_total_matches = player_total_matches;
        this.player_centuries = player_centuries;
        this.player_half_centuries = player_half_centuries;
        this.player_five_wickets = player_five_wickets;
        this.player_total_hatricks = player_total_hatricks;
        this.total_ODI_matches = total_ODI_matches;
        this.total_Test_matches = total_Test_matches;
        this.total_T20i_matches = total_T20i_matches;
        this.total_odi_wickets = total_odi_wickets;
        this.total_t20i_wickets = total_t20i_wickets;
        this.total_test_wickets = total_test_wickets;
        this.player_odi_runs = player_odi_runs;
        this.player_t20i_runs = player_t20i_runs;
        this.player_test_runs = player_test_runs;
    }



    @Override
    public String toString() {
        return "CricketPlayers{" +
                "id=" + id +
                ", player_name='" + player_name + '\'' +
                ", player_specification='" + player_specification + '\'' +
                ", player_total_matches='" + player_total_matches + '\'' +
                ", player_centuries='" + player_centuries + '\'' +
                ", player_half_centuries='" + player_half_centuries + '\'' +
                ", player_five_wickets='" + player_five_wickets + '\'' +
                ", player_total_hatricks='" + player_total_hatricks + '\'' +
                ", total_ODI_matches=" + total_ODI_matches +
                ", total_Test_matches=" + total_Test_matches +
                ", total_T20i_matches=" + total_T20i_matches +
                ", total_odi_wickets=" + total_odi_wickets +
                ", total_t20i_wickets=" + total_t20i_wickets +
                ", total_test_wickets=" + total_test_wickets +
                ", player_odi_runs=" + player_odi_runs +
                ", player_t20i_runs=" + player_t20i_runs +
                ", player_test_runs=" + player_test_runs +
                '}';
    }
}

