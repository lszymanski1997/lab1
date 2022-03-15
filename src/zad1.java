import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class zad1 {
    public static float odch(String[][] diabetes, int number){
        float wynik, srednia, suma = 0;
        for(String a:diabetes[number]){
            suma = suma + Float.parseFloat(a);
        }
        srednia = suma / 768;
        suma = 0;
        for(String a:diabetes[number]){
            suma = suma + (Float.parseFloat(a) - srednia) * (Float.parseFloat(a) - srednia);
        }
        wynik =


        return wynik;
    }

    public static String[] list(String[][] diabetes, int number) {
        String[] arg = new String[0];
        for (String[] a : diabetes) {
            boolean is = false;
            for (String b : arg) {
                if (Objects.equals(b, a[number])) {
                    is = true;
                    break;
                }
            }
            if (!is) {
                arg = Arrays.copyOf(arg, arg.length + 1);
                arg[arg.length - 1] = a[number];
            }
        }
        return arg;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String[][] diabetes = new String[768][];
        String[] decisiveTypes = new String[0];

        int index = 0;

        File file = new File("diabetes.txt");
        Scanner input = new Scanner(file);

        while (input.hasNextLine() && index < diabetes.length) {
            diabetes[index] = input.nextLine().split(" ");
            index++;
        }
        for (String[] a : diabetes) {
            for (String s : a) System.out.print(s + ", ");
            System.out.println();
        }
        for (String[] a : diabetes){
            boolean is = false;
            for(String b: decisiveTypes){
                if (Objects.equals(b, a[8])) {
                    is = true;
                    break;
                }
            }
            if(!is){
                decisiveTypes = Arrays.copyOf(decisiveTypes,decisiveTypes.length + 1);
                decisiveTypes[decisiveTypes.length - 1] = a[8];
            }
        }
        System.out.print("decision class types: ");
        for(String a:decisiveTypes){
            System.out.print(a + ", ");
        }
        System.out.println();
        for(String a:decisiveTypes){
            int count = 0;
            for (String[] b : diabetes){
                if(Objects.equals(b[8], a)){
                    count++;
                }
            }
            System.out.println("number of decision classes that equal " + a + " = " + count);
        }
        float[] min = {9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999};
        float[] max = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        for(String[] a:diabetes){
            for(int i = 0; i<9; i++){
                float temp = Float.parseFloat(a[i]);
                if(temp <= min[i]){
                    min[i] = temp;
                }
                if(temp >= max[i]){
                    max[i] = temp;
                }
            }
        }
        System.out.print("minimalne wartosci: ");
        for(float a:min){
            System.out.print(a + ", ");
        }
        System.out.println();
        System.out.print("maksymalne wartosci: ");
        for(float a:max){
            System.out.print(a + ", ");
        }

        String[] arg1 = list(diabetes, 0);
        String[] arg2 = list(diabetes, 1);
        String[] arg3 = list(diabetes, 2);
        String[] arg4 = list(diabetes, 3);
        String[] arg5 = list(diabetes, 4);
        String[] arg6 = list(diabetes, 5);
        String[] arg7 = list(diabetes, 6);
        String[] arg8 = list(diabetes, 7);
        System.out.println();
        System.out.println();
        System.out.print("arg1 class types: ");
        for(String a:arg1){
            System.out.print(a + ", ");
        }
        System.out.println();
        System.out.println("number of arg1 class types: " + arg1.length);
        System.out.println();
        System.out.print("arg2 class types: ");
        for(String a:arg2){
            System.out.print(a + ", ");
        }
        System.out.println();
        System.out.println("number of arg2 class types: " + arg2.length);
        System.out.println();
        System.out.print("arg3 class types: ");
        for(String a:arg3){
            System.out.print(a + ", ");
        }
        System.out.println();
        System.out.println("number of arg3 class types: " + arg3.length);
        System.out.println();
        System.out.print("arg4 class types: ");
        for(String a:arg4){
            System.out.print(a + ", ");
        }
        System.out.println();
        System.out.println("number of arg4 class types: " + arg4.length);
        System.out.println();
        System.out.print("arg5 class types: ");
        for(String a:arg5){
            System.out.print(a + ", ");
        }
        System.out.println();
        System.out.println("number of arg5 class types: " + arg5.length);
        System.out.println();
        System.out.print("arg6 class types: ");
        for(String a:arg6){
            System.out.print(a + ", ");
        }
        System.out.println();
        System.out.println("number of arg6 class types: " + arg6.length);
        System.out.println();
        System.out.print("arg7 class types: ");
        for(String a:arg7){
            System.out.print(a + ", ");
        }
        System.out.println();
        System.out.println("number of arg7 class types: " + arg7.length);
        System.out.println();
        System.out.print("arg8 class types: ");
        for(String a:arg8){
            System.out.print(a + ", ");
        }
        System.out.println();
        System.out.println("number of arg8 class types: " + arg8.length);
        System.out.println();

        float odch1, odch2, odch3, odch4, odch5, odch6, odch7, odch8;

        for(String diabetes)



    }
}