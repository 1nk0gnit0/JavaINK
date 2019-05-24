package Two;

public class ConvertSum {
    public static int sumConvert (String[][] arr) throws MyArraySizeException, MyArrayDataException {

        if(arr.length != 4) throw new MyArraySizeException("Размерность матрицы дожна быть 4х4");
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i].length != 4) throw new MyArraySizeException("Размерность матрицы дожна быть 4х4");
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                }catch (Exception e){
                    throw new MyArrayDataException("Ошибка формата в ячейке " + i + " " + j);
                }
            }
        }
        System.out.println(sum + " " + arr.length);
        return sum;
    }
}
