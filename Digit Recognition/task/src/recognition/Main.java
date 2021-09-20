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
        for (int x = 0; x < 3; x++) {
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
        final int[] weights = {2, 1, 2, 4, -4, 4, 2, -1, 2};
        final int b = -5;
        int a10 = 0;
        for (int i = 0; i < 9; i++) {
            a10 += list.get(i) * weights[i];
        }

        a10 += b;

        if(a10 > 0) {
            System.out.println("This number is 0");
        } else {
            System.out.println("This number is 1");
        }
    }
}
