package tigerDogs;

public class RegretNow {

    public static int whichDogMoved(int[][] pre, int[][] current, int[][] idPre) {
        //狗走起之后悔棋
        for (int i = 0; i < pre.length; i++) {
            for (int j = 0; j < pre[i].length; j++) {
                if (pre[i][j] == 1 && current[i][j] == 0) {
                    return idPre[i][j];
                }
            }
        }
        //如果没有移动 返回一个不相干值-2
        return -2;//返回一个
    }


}
