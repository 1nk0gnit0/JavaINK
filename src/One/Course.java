package One;

public class Course {
    private int[] distRun = new int[3];
    private double[] distJump  = new double[3];


    public Course() {
        distRun[0] = (int) ((Math.random()*(1250-500))+500);
    }




    public void Info(){
        System.out.println("Дистанция: " + this.distRun + " м. Высота препятсвия: " + distJump + " м.");
    }
}
//this.distRun = (int) ((Math.random()*(1250-500))+500);
       // this.distJump = Math.random()*(2-0.5)*0.5;