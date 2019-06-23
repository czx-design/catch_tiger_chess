package tigerDogs;

import java.util.ArrayList;
import java.util.List;

public class Game {
    boolean flag = false;                               //判断走棋顺序，当flag为true时，虎走棋；flag为false时，狗走棋
    boolean moveFlag;
    List<Integer> eatenDogs = new ArrayList<>();        //被吃掉的狗的id们
    int[][] array = {
            {-1, -1, 0, -1, -1},
            {-1, 0, 0, 0, -1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 2, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1}
    };                      //存放棋盘及棋子的数组
    int[][] ID = {
            {-1, -1, 0, -1, -1},
            {-1, 0, 0, 0, -1},
            {1, 2, 3, 4, 5},
            {6, 0, 0, 0, 7},
            {8, 0, 0, 0, 9},
            {10, 0, 0, 0, 11},
            {12, 13, 14, 15, 16}
    };
    int[][] arrayPre = {
            {-1, -1, 0, -1, -1},
            {-1, 0, 0, 0, -1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 2, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1}
    };                      //存放棋盘及棋子的数组
    int[][] IDPre = {
            {-1, -1, 0, -1, -1},
            {-1, 0, 0, 0, -1},
            {1, 2, 3, 4, 5},
            {6, 0, 0, 0, 7},
            {8, 0, 0, 0, 9},
            {10, 0, 0, 0, 11},
            {12, 13, 14, 15, 16}
    };

    //存放棋盘中狗的位置和id


    void tryGame(Game ab, int x1, int y1, int x2, int y2) {
        //根据组件绑定的鼠标点击事件获取组件坐标及目的地位置
        System.out.println("想要移动的棋子坐标、目的地坐标：");//调试
        System.out.println(x1 + "" + y1 + "" + x2 + "" + y2);//调试
        //根据组件原坐标和目的落点地坐标判断是否可以移动
        this.moveFlag = Move.move(this.array, x1, y1, x2, y2, this.flag);
        //可以移动 -> 移动&&更新棋盘数组和id数组 or 不可以移动 -> 将棋子弹回原坐标
        if (this.moveFlag) {
            //存储棋盘数组和id数组的上一个状态用于悔棋
            CopyChessBoard.copy(ab.array, ab.arrayPre);
            CopyChessBoard.copy(ab.ID, ab.IDPre);
            //交换棋子
            CopyChessBoard.swap(this.array,x1,y1,x2,y2);
            //封装的swap函数为：
            /*int temp = this.array[x2][y2];
            this.array[x2][y2] = this.array[x1][y1];
            this.array[x1][y1] = temp;*/
            //交换存狗id的数组
            CopyChessBoard.swap(this.ID,x1,y1,x2,y2);
            //交换选手
            this.flag = !this.flag;
            //落子的声音
            new magicMusic.Play0("src/tigerDogs/BGMs/chessDown.mp3").start();
        }
        if (this.flag) {
            System.out.println("请虎走棋");
        } else {
            System.out.println("请狗走棋");
        }
    }

}