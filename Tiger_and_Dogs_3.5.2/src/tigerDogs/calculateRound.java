package tigerDogs;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class calculateRound {       //四舍五入除法
    double temp = 0, gap;
    int integer;
    double lx, ly;

    public int roundingOff(int n, double a) {           //n为被除数，a为除数，integer=n/a
        gap=a;
        temp = n / gap;
        BigDecimal deal = new BigDecimal(temp);
        integer = deal.setScale(0, RoundingMode.HALF_UP).intValue();
        return integer;

    }

    public int changeXToboard(int a) {
        if (a < 0 || a > 5) {
            System.out.println("添加棋子x坐标获取错误");
            return 0;
        } else {
            lx = a * 117.5;
            return (int) lx;
        }
    }

    public int changeYToboard(int b) {
        if (b == 0) {
            ly = b * 117.5;
        } else if (b == 1) {
            ly = 120;
        } else if (b == 2) {
            ly = 120 + 135;
        } else if (b > 2 && b < 7) {
            ly = b * 117.5 + (120 - 117.5) + (135 - 117.5);
        } else {
            System.out.println("添加棋子y坐标获取错误");
            return 0;
        }
        return (int) ly;
    }       //根据数组坐标获取像素位置

}


