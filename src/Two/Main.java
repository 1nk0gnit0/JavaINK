package Two;

public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

       String[][] sizeErrorMatrix = {{"1", "1", "1", "1"}, {"1", "д", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};

       String[][] dataErrorMatrix = {{"1", "1", "1", "1"}, {"1", "L", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};

        try {
            ConvertSum.sumConvert(sizeErrorMatrix);
        }catch (MyArraySizeException e){
            System.out.println(e);
        }

       /* try {
            ConvertSum.sumConvert(dataErrorMatrix);
        }catch (MyArrayDataException e){
            System.out.println(e);
        }*/



    }
}
