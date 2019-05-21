package One;

public class Main {
    public static void main(String[] args) {

        Course c = new Course(distRun, distJump);
        Team team = new Team("Humans");
        Person[] arrPerson = new Person[4];

        arrPerson[0] = new Person("Humans", "Hum 1", 500, 0.5);
        arrPerson[1] = new Person("Humans", "Hum 2", 750, 1);
        arrPerson[2] = new Person("Humans", "Hum 3", 1000, 1.5);
        arrPerson[3] = new Person("Humans", "Hum 4", 1250, 2);

        team.Info();

        for (Person person : arrPerson){
            person.Info();
        }

        c.Info();
    }

}
