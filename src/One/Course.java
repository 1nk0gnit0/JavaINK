package One;

public class Course extends Team{
    private int[] disincentive;

    public Course() {
        this.disincentive = new int[]{0, 1, 0, 1, 0, 1, 0};
    }

    public void Info() {
        System.out.print("С Т А Р Т -> ");
        for (int i = 0; i < disincentive.length; i++) {
            if (i != 0) System.out.print(" -> ");
            if (disincentive[i] == 0) System.out.print("Дистанция 25 м.");
            else System.out.print("Препятствие");
        }
        System.out.println(" -> Ф И Н И Ш");
        System.out.println();
    }

    public void doIt(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < disincentive.length; j++) {
                    if (disincentive[j] == 0) arr[i] = arr[i] - 20;
                    else arr[i] = arr[i] - 10;
                    arr[i] = arr[i];
                    if (arr[i] <= 0) break;
                }
            }
        }
    }


