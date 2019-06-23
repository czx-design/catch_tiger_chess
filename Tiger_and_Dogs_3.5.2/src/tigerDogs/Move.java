package tigerDogs;

import javax.swing.*;
import java.util.List;

public class Move {
    /*int a1,b1,a2,b2;
    boolean flag;
    public boolean moveGetXY(int x1,int y1, int x2,int y2){
        this.a1=x1;
        this.b1=y1;
        this.a2=x2;
        this.b2=y2;
        return this.flag;
    }*/

    public static boolean move(int[][] array, int x1, int y1, int x2, int y2, boolean flag) {
        int m = 0;
        /* int x1=this.a1,y1=this.b1,x2=this.a2,y2=this.b2;*/
        List<Integer> direction = Path.path(x1, y1);
        //判断是否可移动
        if (flag)
            m = 2;
        else
            m = 1;
        if (array[x1][y1] == m) {                                     //移动条件一：（x1,y1）为狗或虎
            if (Math.abs(x1 - x2) < 2 || Math.abs(y1 - y2) < 2) {   //移动条件三：移动方向判定
                if (array[x2][y2] == 0) {
                    //移动调价二：（x2,y2）为空
                    if (x1 - x2 == 1 && y1 - y2 == 0) {
                        if (direction.contains(1)) {
                            System.out.println("移动方向是：上");
                            return true;
                        }
                    }
                    if (x1 - x2 == -1 && y1 - y2 == 0) {
                        if (direction.contains(5)) {
                            System.out.println("移动方向是：下");
                            return true;
                        }
                    }
                    if (x1 - x2 == 0 && y1 - y2 == 1) {
                        if (direction.contains(7)) {
                            System.out.println("移动方向是：左");
                            return true;
                        }
                    }
                    if (x1 - x2 == 0 && y1 - y2 == -1) {
                        if (direction.contains(3)) {
                            System.out.println("移动方向是：右");
                            return true;
                        }
                    }
                    if (x1 - x2 == 1 && y1 - y2 == 1) {
                        if (direction.contains(8)) {
                            System.out.println("移动方向是：左上");
                            return true;
                        }
                    }
                    if (x1 - x2 == -1 && y1 - y2 == 1) {
                        if (direction.contains(6)) {
                            System.out.println("移动方向是：左下");
                            return true;
                        }
                    }
                    if (x1 - x2 == 1 && y1 - y2 == -1) {
                        if (direction.contains(2)) {
                            System.out.println("移动方向是：右上");
                            return true;
                        }
                    }
                    if (x1 - x2 == -1 && y1 - y2 == -1) {
                        if (direction.contains(4)) {
                            System.out.println("移动方向是：右下");
                            return true;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "路径不存在！", "小赖皮~哼~", JOptionPane.ERROR_MESSAGE);
                        System.out.println("路径不存在！");
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "目的地不为空！", "小赖皮~哼~", JOptionPane.ERROR_MESSAGE);
                    System.out.println("目的地不为空！");
                    return false;
                }
            } else {
                System.out.println("移动跨度过大！");
                JOptionPane.showMessageDialog(null, "移动跨度过大！", "小赖皮~哼~", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "非法选取棋子！", "小赖皮~哼~", JOptionPane.ERROR_MESSAGE);
            System.out.println(m + "非法选取棋子！");
        }
        return false;
    }
}
