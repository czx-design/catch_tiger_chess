package tigerDogs;

import javax.swing.*;

public class initializeAll {
    chessBoard cb;
    JPanel jp;
    clockPaint cP;
    calculateRound nb;
    public initializeAll(chessBoard cb, JPanel jp,clockPaint cP){
        this.cb=cb;
        this.jp=jp;
        this.cP=cP;
        this.nb=new calculateRound();
    }

    public void changeIntializeLocal(chessBoard.chess temp) {
        jp.add(temp);
        temp.setBounds(nb.changeXToboard(temp.initializeX), nb.changeYToboard(temp.initializeY), temp.getWidth(), temp.getHeight());
        temp.x = temp.initializeX;
        temp.y = temp.initializeY;
        temp.originalX = temp.initializeX;
        temp.originalY = temp.initializeY;
    }       //初始化添加回所有棋子并还原位置
    public void initialize() {
        cb.startSign=true;
        cb.initialzeNumbers();
        changeIntializeLocal(cb.t);
        changeIntializeLocal(cb.d1);
        changeIntializeLocal(cb.d2);
        changeIntializeLocal(cb.d3);
        changeIntializeLocal(cb.d4);
        changeIntializeLocal(cb.d5);
        changeIntializeLocal(cb.d6);
        changeIntializeLocal(cb.d7);
        changeIntializeLocal(cb.d8);
        changeIntializeLocal(cb.d9);
        changeIntializeLocal(cb.d10);
        changeIntializeLocal(cb.d11);
        changeIntializeLocal(cb.d12);
        changeIntializeLocal(cb.d13);
        changeIntializeLocal(cb.d14);
        changeIntializeLocal(cb.d15);
        changeIntializeLocal(cb.d16);
        jp.repaint();
        cP.m1=3;
        cP.s1=0;
        cP.ss=0;
        cP.sm=0;
    }       //初始化函数
}
