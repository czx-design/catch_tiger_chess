package tigerDogs;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Path {
    public static List<Integer> path(int x, int y) {
        List<Integer> optionalPath = new ArrayList<>();
        int m = 10 * x + y;

        List<Integer> aUp = Arrays.asList(12, 22, 30, 31, 32, 33, 34, 40, 41, 42, 43, 44, 50, 51, 52, 53, 54, 60, 61, 62, 63, 64);
        List<Integer> aDown = Arrays.asList(2, 12, 20, 21, 22, 23, 24, 30, 31, 32, 33, 34, 40, 41, 42, 43, 44, 50, 51, 52, 53, 54);
        List<Integer> aLeft = Arrays.asList(12, 13, 21, 22, 23, 24, 31, 32, 33, 34, 41, 42, 43, 44, 51, 52, 53, 54, 61, 62, 63, 64);
        List<Integer> aRight = Arrays.asList(11, 12, 20, 21, 22, 23, 30, 31, 32, 33, 40, 41, 42, 43, 50, 51, 52, 53, 60, 61, 62, 63);
        List<Integer> aLUp = Arrays.asList(13, 22, 31, 33, 42, 44, 51, 53, 62, 64);
        List<Integer> aLDown = Arrays.asList(2, 13, 22, 24, 31, 33, 42, 44, 51, 53);
        List<Integer> aRUp = Arrays.asList(11, 22, 31, 33, 40, 42, 51, 53, 60, 62);
        List<Integer> aRDown = Arrays.asList(2, 11, 20, 22, 31, 33, 40, 42, 51, 53);

        if (aUp.contains(m)) {
            optionalPath.add(1);
        }
        if (aRUp.contains(m)) {
            optionalPath.add(2);
        }
        if (aRight.contains(m)) {
            optionalPath.add(3);
        }
        if (aRDown.contains(m)) {
            optionalPath.add(4);
        }
        if (aDown.contains(m)) {
            optionalPath.add(5);
        }
        if (aLDown.contains(m)) {
            optionalPath.add(6);
        }
        if (aLeft.contains(m)) {
            optionalPath.add(7);
        }
        if (aLUp.contains(m))
            optionalPath.add(8);
        return optionalPath;
    }




}
