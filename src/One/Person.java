package One;

public class Person extends Team {

    private String name;
    private int toRun;
    private double toJump;

    public Person(String nameTeam, String name, int toRun, double toJump) {
        super(nameTeam);
        this.name = name;
        this.toRun = toRun;
        this.toJump = toJump;
    }

    public void Info(){
        System.out.println(this.name + " пробегает " + toRun + "м., перепрыгивает препятсвия высотой " + toJump + "м.");
    }
}
