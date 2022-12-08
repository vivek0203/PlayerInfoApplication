package PlayerInfoApplication.PlayerInfoApplication.entity;

public class PlayerPersonalInfo {
    private Integer player_id;
    private String name;
    private Integer age;
    private String gender;
    private String state;

    @Override
    public String toString() {
        return "PlayerDetails{" +
                "player_id=" + player_id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}