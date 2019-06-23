package tigerDogs;

import java.util.ArrayList;
import java.util.List;


public class Eat {

    public static List<Integer> eat(int[][] map, int[][] id) {
        List<Integer> eaten = new ArrayList<>();
        upDown(map, id, eaten);
        leftRight(map, id, eaten);
        subDiago(map, id, eaten);
        mainDiago(map, id, eaten);
        System.out.println("被吃掉的狗的id为：");
        for (int i = 0; i < eaten.size(); i++) {
            System.out.print(eaten.get(i) + " ");
        }
        System.out.println();
        return eaten;
    }

    public static void leftRight(int map[][], int[][] id, List<Integer> eaten) {
        int tigerPosition = DogsWin.whereIsTiger(map);
        int x, y;
        x = tigerPosition / 10;
        y = tigerPosition - x * 10;
        List<Integer> option = Path.path(x, y);
        if (option.contains(7) && option.contains(3)) {
            if (map[x][y - 1] == 1 && map[x][y + 1] == 1) {
                map[x][y - 1] = map[x][y + 1] = 0;
                eaten.add(id[x][y - 1]);
                eaten.add(id[x][y + 1]);
                id[x][y - 1] = id[x][y + 1] = 0;
                new magicMusic.Play0("src/tigerDogs/BGMs/Tiger_eat_dogs.mp3").start();
            }
        }
    }


    public static void upDown(int map[][], int[][] id, List<Integer> eaten) {
        int tigerPosition = DogsWin.whereIsTiger(map);
        int x, y;
        x = tigerPosition / 10;
        y = tigerPosition - x * 10;
        List<Integer> option = Path.path(x, y);
        if (option.contains(1) && option.contains(5)) {
            if (map[x - 1][y] == 1 && map[x + 1][y] == 1) {
                map[x - 1][y] = map[x + 1][y] = 0;
                eaten.add(id[x - 1][y]);
                eaten.add(id[x + 1][y]);
                id[x - 1][y] = id[x + 1][y] = 0;
                new magicMusic.Play0("src/tigerDogs/BGMs/Tiger_eat_dogs.mp3").start();
            }
        }

    }

    public static void subDiago(int map[][], int[][] id, List<Integer> eaten) {
        int tigerPosition = DogsWin.whereIsTiger(map);
        int x, y;
        x = tigerPosition / 10;
        y = tigerPosition - x * 10;
        List<Integer> option = Path.path(x, y);
        if (option.contains(2) && option.contains(6)) {
            if (map[x + 1][y - 1] == 1 && map[x - 1][y + 1] == 1) {
                map[x + 1][y - 1] = map[x - 1][y + 1] = 0;
                eaten.add(id[x + 1][y - 1]);
                eaten.add(id[x - 1][y + 1]);
                id[x + 1][y - 1] = id[x - 1][y + 1] = 0;
                new magicMusic.Play0("src/tigerDogs/BGMs/Tiger_eat_dogs.mp3").start();
            }
        }
    }

    public static void mainDiago(int map[][], int[][] id, List<Integer> eaten) {
        int tigerPosition = DogsWin.whereIsTiger(map);
        int x, y;
        x = tigerPosition / 10;
        y = tigerPosition - x * 10;
        List<Integer> option = Path.path(x, y);
        if (option.contains(8) && option.contains(4)) {
            if (map[x - 1][y - 1] == 1 && map[x + 1][y + 1] == 1) {
                map[x - 1][y - 1] = map[x + 1][y + 1] = 0;
                eaten.add(id[x - 1][y - 1]);
                eaten.add(id[x + 1][y + 1]);
                id[x - 1][y - 1] = id[x + 1][y + 1] = 0;
                new magicMusic.Play0("src/tigerDogs/BGMs/Tiger_eat_dogs.mp3").start();
            }
        }
    }
}
