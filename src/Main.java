import java.util.Arrays;
public class Main {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        //              4 строка - невалидная
        String [][] twoArr1 = {{"1","2","3","4"},{"a","b","c","d"},{"2","3","4","5"},{"а","б","в"}};
        System.out.println("Массив 1\n"+Arrays.deepToString(twoArr1).replace("], ", "]\n"));
        try {
            System.out.println("Результат " + checkingSizeArray(twoArr1));
        }
        catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e);
        }

        //              невалидный массив 3*4
        String [][] twoArr2 = {{"1","2","3","4"},{"a","b","c","d"},{"2","3","4","5"}};
        System.out.println("Массив 2\n"+Arrays.deepToString(twoArr2).replace("], ", "]\n"));
        try {
            System.out.println("Результат " + checkingSizeArray(twoArr2));
        }
        catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e);
        }

        //              невалидный массив 4*4
        String [][] twoArr3 = {{"1", "2","3","4"},{"3", "333","545","12"},{"a","b","c","d"},{"+","-","=","8"}};
        System.out.println("Массив 3\n"+Arrays.deepToString(twoArr3).replace("], ", "]\n"));
        try {
            System.out.println("Результат: " + checkingSizeArray(twoArr3));
        }
        catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e);
        }

        //              валидный массив 4*4
        String [][] twoArr4 = {{"1","2","3","4"},{"a","b","c","d"},{"2","3","4","5"},{"4","3","2","1"}};
        System.out.println("Массив 4\n"+Arrays.deepToString(twoArr4).replace("], ", "]\n"));
        try {
            System.out.println("Сумма элементов массива " + checkingSizeArray(twoArr4));
        }
        catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e);
        }

    }


    static int checkingSizeArray(String[][] a) throws MyArraySizeException, MyArrayDataException {
        if (a.length != 4) {
            throw new MyArraySizeException( "Массив не 4x4!" );
        }
        for (int i = 0; i < 4; i++)
            if (a[i].length != 4) {
                throw new MyArraySizeException( "Массив не симметричный!" );
            }

        int sum = 0;
        for (int l = 0; l < 4 ; l++) {
            for (int m = 0; m < 4 ; m++) {
                try {
                    int x = Integer.parseInt(a[l][m]);
                    sum += x;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException( "Элемент массива("+ l +", "+ m + ") некорректный " + e );
                }

            }

        }
        return sum;
    }
}

