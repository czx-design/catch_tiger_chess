package tigerDogs;

public class GameBegin {
    public static void main(String[] args) {
        //绘制棋盘
        new chessBoard();

        //播放背景音乐
        new magicMusic.Play0("src/tigerDogs/BGMs/bgm.mp3").start();
    }
}
