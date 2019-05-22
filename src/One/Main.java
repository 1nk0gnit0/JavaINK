package One;

public class Main {
    public static void main(String[] args) {

        Course c = new Course();
        Team team = new Team();

        c.Info();
        team.Info();
        c.doIt(Team.person);
        team.showResults();
    }

}
