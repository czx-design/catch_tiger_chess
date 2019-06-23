package tigerDogs;

public class NewGame {

    public  NewGame(int[][] array, int[][] id) {
        int dog = 0;
        int[][] start = {
                {-1, -1, 0, -1, -1},
                {-1, 0, 0, 0, -1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 2, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };

        for (int a = 0; a < array.length; a++) {
            array[a] = start[a].clone();     //深拷贝
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <5; j++) {
                if(array[i][j]==1){
                    id[i][j] = ++dog;
                }
            }
        }
        Print.print(array);
    }
}
