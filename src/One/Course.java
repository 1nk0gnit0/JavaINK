package One;

public class Course extends Team{
    private int[] disincentive;

    public Course() {
        this.disincentive = new int[]{0, 1, 0, 1, 0, 1, 0};
    }

    public void Info() {
        System.out.print("Стар -> ");
        for (int i = 0; i < disincentive.length; i++) {
            if (disincentive[i] == 0) System.out.print("Дистанция 25 м.");
            else System.out.print(" -> Препятствие -> ");
        }
        System.out.println(" -> Финиш");
        System.out.println();
    }

    public void doIt(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int stamina = arr[i];
            for (int j = 0; j < disincentive.length; j++) {
                    if (disincentive[j] == 0) stamina = stamina - 20;
                    else stamina = stamina - 10;
                    arr[i] = stamina;
                    if (stamina <= 0) break;
                }
            }
        }
    }


