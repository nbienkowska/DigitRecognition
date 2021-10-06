package recognition;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = processInput();
        findDigit(list);

    }

    public static ArrayList<Integer> processInput() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        for (int x = 0; x < 5; x++) {
            String input = sc.next();
            System.out.println(input);
            for (int i = 0; i < 3; i++) {
                if (input.charAt(i) == 'X') {
                    list.add(1);
                } else {
                    list.add(0);
                }
            }
        }

        return list;
    }

    public static void findDigit(ArrayList<Integer> list) {
        final int[][] weights = {
                {1, 1, 1, 1, -1, 1, 1, -1, 1, 1, -1, 1, 1, 1, 1},  //0
                {-1, 1, -1, -1, 1, -1, -1, 1, -1, -1, 1, -1, -1, 1, -1},  //1
                {1, 1, 1, -1, -1, 1, 1, 1, 1, 1, -1, -1, 1, 1, 1},  //2
                {1, 1, 1, -1, -1, 1, 1, 1, 1, -1, -1, 1, 1, 1, 1},  //3
                {1, -1, 1, 1, -1, 1, 1, 1, 1, -1, -1, 1, -1, -1, 1},  //4
                {1, 1, 1, 1, -1, -1, 1, 1, 1, -1, -1, 1, 1, 1, 1},  //5
                {1, 1, 1, 1, -1, -1, 1, 1, 1, 1, -1, 1, 1, 1, 1},  //6
                {1, 1, 1, -1, -1, 1, -1, -1, 1, -1, -1, 1, -1, -1, 1},  //7
                {1, 1, 1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1},  //8
                {1, 1, 1, 1, -1, 1, 1, 1, 1, -1, -1, 1, 1, 1, 1}}; //9
        final int[] biases =  {-1, 6, 1, 0, 2, 0, -1, 3, -2, -1};
        int[] a =  new int[10];
        for (int j = 0; j < 10; j++) {            //neurons
            for (int i = 0; i < 15; i++) {        //inputs
                a[j] += list.get(i) * weights[j][i];
            }
            a[j] += biases[j];
        }
        List<Integer> aList = new ArrayList<Integer>(a.length);

        for (int i : a) {
            aList.add(i);
        }
        Integer max = Collections.max(aList);
        String output = String.format("This number is %d", aList.indexOf(max));
        System.out.println(output);
    }
}
