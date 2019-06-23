package tigerDogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DogsWin {

    private static List<Integer> path(int x) {
        List<Integer> optionalPath = new ArrayList<>();

        List<Integer> aUp = Arrays.asList(12, 22, 30, 31, 32, 33, 34, 40, 41, 42, 43, 44, 50, 51, 52, 53, 54, 60, 61, 62, 63, 64);
        List<Integer> aDown = Arrays.asList(2, 12, 20, 21, 22, 23, 24, 30, 31, 32, 33, 34, 40, 41, 42, 43, 44, 50, 51, 52, 53, 54);
        List<Integer> aLeft = Arrays.asList(12, 13, 21, 22, 23, 24, 31, 32, 33, 34, 41, 42, 43, 44, 51, 52, 53, 54, 61, 62, 63, 64);
        List<Integer> aRight = Arrays.asList(11, 12, 20, 21, 22, 23, 30, 31, 32, 33, 40, 41, 42, 43, 50, 51, 52, 53, 60, 61, 62, 63);
        List<Integer> aLUp = Arrays.asList(13, 22, 31, 33, 42, 44, 51, 53, 62, 64);
        List<Integer> aLDown = Arrays.asList(2, 13, 22, 24, 31, 33, 42, 44, 51, 53);
        List<Integer> aRUp = Arrays.asList(11, 22, 31, 33, 40, 42, 51, 53, 60, 62);
        List<Integer> aRDown = Arrays.asList(2, 11, 20, 22, 31, 33, 40, 42, 51, 53);

        if (aUp.contains(x)) {
            optionalPath.add(1);
        }
        if (aRUp.contains(x)) {
            optionalPath.add(2);
        }
        if (aRight.contains(x)) {
            optionalPath.add(3);
        }
        if (aRDown.contains(x)) {
            optionalPath.add(4);
        }
        if (aDown.contains(x)) {
            optionalPath.add(5);
        }
        if (aLDown.contains(x)) {
            optionalPath.add(6);
        }
        if (aLeft.contains(x)) {
            optionalPath.add(7);
        }
        if (aLUp.contains(x))
            optionalPath.add(8);
        return optionalPath;
    }

    public static int whereIsTiger (int [][]array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 2) {
                    return i * 10 + j;
                }
            }
        }
        return 0;
    }
    public static boolean Dwin (int [][]array){
        int dogWinFlag = 0 ;
        int tigerPositon = whereIsTiger(array);
        List<Integer> TigerAround = new ArrayList<>();
        List<Integer> OP = path(tigerPositon); //OP存储path返回的List
        int x = tigerPositon / 10;
        int y = tigerPositon - x * 10;
        for (int i=0;i<OP.size();i++) {
            switch (OP.get(i)){
                case 1:
                    TigerAround.add(array[x-1][y]-1);
                    break;
                case 2:
                    TigerAround.add(array[x-1][y+1]-1);
                    break;
                case 3:
                    TigerAround.add(array[x][y+1]-1);
                    break;
                case 4:
                    TigerAround.add(array[x+1][y+1]-1);
                    break;
                case 5:
                    TigerAround.add(array[x+1][y]-1);
                    break;
                case 6:
                    TigerAround.add(array[x+1][y-1]-1);
                    break;
                case 7:
                    TigerAround.add(array[x][y-1]-1);
                    break;
                case 8:
                    TigerAround.add(array[x-1][y-1]-1);
                    break;
                default:break;
            }

        }
        for (int i=0;i<TigerAround.size();i++) {
            dogWinFlag += TigerAround.get(i);
        }
        if (dogWinFlag == 0){
            System.out.println("狗胜利！");
            return true;
        }
        return false;
    }
}

