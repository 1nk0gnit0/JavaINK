package One;

public class Team {
    public static int[] person;
    private String nameTeam;

    public Team() {
        this.nameTeam = "Team";
        this.person = new int[]{90, 120, 110, 150};
    }

    public void Info(){
        System.out.println("Команда: " + nameTeam);
        for(int i = 0; i < person.length; i++){
            System.out.println("Участник " + (i + 1) + ". Выносливость: " + person[i] + ".");
        }
        System.out.println();
    }

    public void showResults(){
        for (int i = 0; i < person.length; i++){
            if(person[i] <= 0) System.out.println("Участник " + (i + 1) + " выбыл.");
            else System.out.println("Участник " + (i + 1) + " финишировал!");
        }
    }
}
