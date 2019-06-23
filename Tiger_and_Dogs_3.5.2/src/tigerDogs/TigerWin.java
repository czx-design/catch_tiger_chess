package tigerDogs;

public class TigerWin {

    public static boolean tigerWin(int[][] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                sum = sum + a[i][j];
        if (sum < 0) {
            System.out.println("sum is:" + sum);
            return true;
        } else {
            System.out.println("sum is:" + sum);
            return false;
        }
    }
}
