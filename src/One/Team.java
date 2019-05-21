package One;

public class Team {
    private String nameTeam;



    public Team(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public void Info(){
        System.out.println("Команда: " + nameTeam + " Участники:");
    }
}
