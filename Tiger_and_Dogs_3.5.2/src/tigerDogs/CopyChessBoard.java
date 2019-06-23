package tigerDogs;

public class CopyChessBoard {
    //1、将棋子移动之前的棋盘存到pre里用于悔棋
    //该函数可以调用在移动之前

    //2、该函数可以调用在点击悔棋之后，将原数组将现数组覆盖
    //调用在监听器里
    public static void copy(int[][] origin, int[][] preState) {
        for (int i = 0; i < origin.length; i++) {
            preState[i] = origin[i].clone();
            //深拷贝数组
        }
    }

    public static void swap(int[][] array, int x1, int y1, int x2, int y2) {
        int temp = array[x2][y2];
        array[x2][y2] = array[x1][y1];
        array[x1][y1] = temp;
    }
}
