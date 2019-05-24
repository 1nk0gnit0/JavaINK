package Two;

public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

       String[][] sizeErrorMatrix = {{"1", "1", "1", "1"}, {"1", "1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};

       String[][] dataErrorMatrix = {{"l", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};

        try {
            ConvertSum.sumConvert(sizeErrorMatrix);
        }catch (MyArrayDataException | MyArraySizeException e){
            System.out.println(e);
        }
        System.out.println();
        try {
            ConvertSum.sumConvert(dataErrorMatrix);
        }catch (MyArrayDataException | MyArraySizeException e){
            System.out.println(e);
        }



    }
}
