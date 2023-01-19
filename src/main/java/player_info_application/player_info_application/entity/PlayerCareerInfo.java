package player_info_application.player_info_application.entity;

public class PlayerCareerInfo {
    private final Integer id;
    private final String player_name;
    private final String player_specification;
    private final Integer  player_total_matches;
    private final Integer player_centuries;
    private final Integer player_half_centuries;
    private final Integer player_five_wickets;
    private final Integer player_total_hatricks;
    private final Integer total_ODI_matches;
    private final Integer total_Test_matches;
    private final Integer total_T20i_matches;
    private final Integer total_odi_wickets;
    private final Integer total_t20i_wickets;
    private final Integer total_test_wickets;
    private final Integer player_odi_runs;
    private final Integer player_t20i_runs;
    private final Integer player_test_runs;

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
        return "PlayerCareerInfo{" +
                "id=" + id +
                ", player_name='" + player_name + '\'' +
                ", player_specification='" + player_specification + '\'' +
                ", player_total_matches=" + player_total_matches +
                ", player_centuries=" + player_centuries +
                ", player_half_centuries=" + player_half_centuries +
                ", player_five_wickets=" + player_five_wickets +
                ", player_total_hatricks=" + player_total_hatricks +
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
