package tigerDogs;

import javax.swing.*;

public class Rules {

    public  static void rules(chessBoard game, boolean MoveFlag,boolean ChessmanFlag,int [][]chessBoard, int [][]idBoard){
        if (MoveFlag && !ChessmanFlag) {
            //虎走棋
            // flag先改变了 再取个反//判断狗的数量是否小于4 -> 小于等于2
            if (TigerWin.tigerWin(chessBoard)) {
                game.startSign=false;
                int n = JOptionPane.showConfirmDialog(null, "重新开始？", "游戏结束老虎胜利",JOptionPane.YES_NO_OPTION);//返回的是按钮的index  i=0或者1
                if (n==0){
                    //重绘棋盘
                    game.ia.initialize();
                }
                System.out.println("游戏结束，虎取得胜利！");
                /*ab.gameContinue = false;*/
            }
            //判断虎是否在陷阱中
            if (TigerInTrap.TigerInTrap(chessBoard)) {
                game.startSign=false;
                int n = JOptionPane.showConfirmDialog(null, "重新开始？", "游戏结束狗胜利",JOptionPane.YES_NO_OPTION);//返回的是按钮的index  i=0或者1
                if (n==0){
                    game.ia.initialize();
                }
                System.out.println("游戏结束，狗取得胜利！");
                /*ab.gameContinue = false;*/
            }
        }
        else {//狗走棋
            if (DogsWin.Dwin(chessBoard)) {
                game.startSign=false;
                int n = JOptionPane.showConfirmDialog(null, "重新开始？", "游戏结束狗胜利",JOptionPane.YES_NO_OPTION);//返回的是按钮的index  i=0或者1
                if (n==0){
                    game.ia.initialize();
                }
                System.out.println("游戏结束，狗取得胜利！");
                /*ab.gameContinue = false;*/
            }
        }

    }
}
