package tigerDogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.List;


class chessBoard extends JFrame implements MouseListener {
    private JLayeredPane layeredPane;       //创建一个JLayeredPane用于分层的。
    private JPanel jp, jBoard, jbackGround;              //创建一个Panel和一个Label用于存放图片，作为背景。jb存放棋子
    private JLabel jl, backGroundPicLabel;
    private ImageIcon image, backGroundPic;
    public chess t, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16;      //棋子
    private JButton startButton, regretButton, urgeButton, rulesButton,restartButton;
    private File tigerPath = new File("src/tigerDogs/pics/tiger.png");
    private File dogsPath = new File("src/tigerDogs/pics/dogs.png");
    private File boardPath = new File("src/tigerDogs/pics/gameboard_1.png");
    private calculateRound cr = new calculateRound();                                   //四舍五入除法对象
    private calculateRound nb = new calculateRound();
    private int newX, newY;          //鼠标点下时拖动位置
    private int oldX, oldY;          //鼠标点下时在屏幕位置
    private int startX, startY;      //组件当前位置
    private String rules;
    private Game ab;                 //游戏开始时重新置数组
    private clockPaint cp;
    public boolean startSign = false;
    private boolean canRregret = true;
    private MyListener m;
    public initializeAll ia;


    public chessBoard()         //棋盘
    {
        //棋盘初始化时 数组初始化
        ab = new Game();
        //图片背景棋盘层jp，jl存放图片，jl添加到jp
        layeredPane = new JLayeredPane();
        image = new ImageIcon(String.valueOf(boardPath));
        jp = new JPanel();
        jp.setBounds(17, 13, 507, 764 + 5);
        jl = new JLabel(image);
        jp.add(jl);
        jp.setBackground(null);
        jl.setBackground(null);
        jp.setOpaque(false);
        layeredPane.add(jp, JLayeredPane.MODAL_LAYER);     //将jp放到最底层。
        //棋盘背景

        backGroundPic = new ImageIcon("src/tigerDogs/pics/backGround_1.jpg");
        jbackGround = new JPanel();
        jbackGround.setBounds(0, -5, backGroundPic.getIconWidth(), backGroundPic.getIconHeight());
        backGroundPic.getImageObserver();
        backGroundPicLabel = new JLabel(backGroundPic);
        jbackGround.add(backGroundPicLabel);
        jbackGround.setBackground(null);
        backGroundPicLabel.setBackground(null);
        jbackGround.setOpaque(false);
        layeredPane.add(jbackGround, JLayeredPane.DEFAULT_LAYER);     //将jp放到最底层。
        //落棋子层JBoard
        jBoard = new JPanel();
        jBoard.setBounds(0, 0, 545, 825);
        jBoard.setBackground(null);
        jBoard.setOpaque(false);
        jBoard.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, Color.BLACK));
        layeredPane.add(jBoard, JLayeredPane.DRAG_LAYER);

        setBackground(null);
        setTitle("捕虎棋3.3");
        this.setLayeredPane(layeredPane);
        this.setSize(550 + 200 + 25, 700+100+25+10);
        this.setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);


        cp = new clockPaint(5, 5, 80, 575, 30,this);          //时钟
        layeredPane.add(cp, JLayeredPane.MODAL_LAYER);

        ia=new initializeAll(this,jBoard,cp);
        /*
         *棋子部分
         **/
        m = new MyListener();    //鼠标监听

        t = new chess(String.valueOf(tigerPath), 2, 4, 2, this);
        d1 = new chess(String.valueOf(dogsPath), 0, 2, 1, this);
        d2 = new chess(String.valueOf(dogsPath), 1, 2, 1, this);
        d3 = new chess(String.valueOf(dogsPath), 2, 2, 1, this);
        d4 = new chess(String.valueOf(dogsPath), 3, 2, 1, this);
        d5 = new chess(String.valueOf(dogsPath), 4, 2, 1, this);
        d6 = new chess(String.valueOf(dogsPath), 0, 3, 1, this);
        d7 = new chess(String.valueOf(dogsPath), 4, 3, 1, this);
        d8 = new chess(String.valueOf(dogsPath), 0, 4, 1, this);
        d9 = new chess(String.valueOf(dogsPath), 4, 4, 1, this);
        d10 = new chess(String.valueOf(dogsPath), 0, 5, 1, this);
        d11 = new chess(String.valueOf(dogsPath), 4, 5, 1, this);
        d12 = new chess(String.valueOf(dogsPath), 0, 6, 1, this);
        d13 = new chess(String.valueOf(dogsPath), 1, 6, 1, this);
        d14 = new chess(String.valueOf(dogsPath), 2, 6, 1, this);
        d15 = new chess(String.valueOf(dogsPath), 3, 6, 1, this);
        d16 = new chess(String.valueOf(dogsPath), 4, 6, 1, this);


        startButton = new JButton("开始游戏");
        startButton.setBounds(600, 450, 100, 40);
        layeredPane.add(startButton, JLayeredPane.MODAL_LAYER);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startSign){
                    JOptionPane.showMessageDialog(null, "游戏已经开始了哦!\n如果需要重新开始的话呢\n请点击'重新开始'按钮吧 ", "不可以这样子的哦！", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "该游戏限时三分钟哦\n ", "加油！加油！加油！", JOptionPane.ERROR_MESSAGE);
                    ia.initialize();
                    startSign = true;//开始游戏标志置为true 否则不可以选中棋子
                }
            }
        });

        restartButton= new JButton("重新开始游戏");
        restartButton.setBounds(600, 500, 100, 40);
        layeredPane.add(restartButton,JLayeredPane.MODAL_LAYER);
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ia.initialize();
                startSign = true;//开始游戏标志置为true 否则不可以选中棋子
            }
        });

        regretButton = new JButton("悔棋");
        regretButton.setBounds(600, 550, 100, 40);
        layeredPane.add(regretButton, JLayeredPane.MODAL_LAYER);
        regretButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startSign) {
                    if (canRregret) {
                        canRregret = false;
                        //获取根据flag判断是谁悔棋
                        if (ab.flag) {
                            //狗悔棋
                            System.out.println("狗悔棋");//调试
                            System.out.println("上次移动的狗的id为：" + RegretNow.whichDogMoved(ab.arrayPre, ab.array, ab.IDPre));
                            chessMove(RegretNow.whichDogMoved(ab.arrayPre, ab.array, ab.IDPre));
                        } else {
                            //老虎悔棋
                            for (int i = 0; i < ab.eatenDogs.size(); i++) {
                                System.out.println("将要返还的狗的id：");
                                placeChess(ab.eatenDogs.get(i));
                            }
                            System.out.println("老虎悔棋");
                            chessMove(99);
                        }
                        //狗悔棋：将上一次移动的狗返回到原来位置
                        //虎悔棋：虎回到上一次移动的位置
                        //判断是否吃了狗 吃了 添加棋子
                        //没吃 跳过
                        ab.flag = !ab.flag;
                        CopyChessBoard.copy(ab.arrayPre, ab.array);
                        CopyChessBoard.copy(ab.IDPre, ab.ID);
                        Print.print(ab.array);
                    } else {
                        JOptionPane.showMessageDialog(null, "不可以连续悔棋哦~", "小赖皮~哼~", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "游戏还没开始哦!\n请点击'开始游戏'按钮", "提示", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        urgeButton = new JButton("催促");
        urgeButton.setBounds(600, 600, 100, 40);
        layeredPane.add(urgeButton, JLayeredPane.MODAL_LAYER);
        urgeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new magicMusic.Play0("src/tigerDogs/BGMs/urge.mp3").start();
            }
        });

        rulesButton = new JButton("规则");
        rules = "1、本棋供两人玩，四周摆猎犬，中间摆虎.\n" + "" +
                "2、由猎犬先走，双方每次只走一步。猎犬不能吃虎，只能围逼虎至陷井致死或当猎犬仅剩四只时把虎围至任何角落无法走动致死，猎犬可在陷井走动 。\n" +
                "3、当两只猎犬在一条线上，中间空位时，老虎走入中间，可以吃掉两边一对猎犬" +
                "(但如果猎犬走动形成这种局面时，虎不能吃掉两边猎犬）。老虎吃到只剩两只猎犬时算胜。";
        rulesButton.setBounds(600, 600, 100, 40);
        layeredPane.add(rulesButton, JLayeredPane.MODAL_LAYER);
        rulesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, rules, "规则", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }


    class chess extends JButton {
        int x, y, kind;
        int originalX, originalY;
        int initializeX, initializeY;

        public chess(String imagePath, int x, int y, int kind, chessBoard cb) {
            Icon icon = new ImageIcon(imagePath);
            setIcon(icon);
            setBounds(nb.changeXToboard(x), nb.changeYToboard(y), 70, 70);
            setBorder(null);
            setContentAreaFilled(false);
            addMouseListener(cb);
            addMouseMotionListener(m);
            jBoard.add(this);
            jBoard.repaint();
            this.originalX = x;
            this.originalY = y;
            this.x = x;
            this.y = y;
            this.kind = kind;//鸡肋
            this.initializeX = x;       // 棋盘初始化的xy
            this.initializeY = y;
        }
    }


    public void boardMove(chess jb, int a, int b) {
        //calculateRound temp=new calculateRound();
        jb.originalX = jb.x;
        jb.originalY = jb.y;
        jb.x = a;
        jb.y = b;
        /*System.out.println("原始坐标："+jb.originalX+" "+jb.originalY);
        System.out.println("落点坐标："+jb.x+" "+jb.y);*/
    }       //进行移动时记录下数组坐标

    /*public void */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Component cp = (Component) e.getSource();        //事件源组件
        startX = cp.getX();         //当鼠标点下的时候记录组件当前的坐标与鼠标当前在屏幕的位置
        startY = cp.getY();
        //System.out.println(startX+" "+startY);
        oldX = e.getXOnScreen();
        oldY = e.getYOnScreen();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (startSign) {
            Component cp = (Component) e.getSource();
            int x = cp.getX();
            int y = cp.getY();
            //System.out.println("执行move之前：");
            //System.out.println(((chess) cp).originalY + " " + ((chess) cp).originalX + " " + cr.roundingOff(y, 117.5) + " " + cr.roundingOff(x, 117.5));
            int nX, nY;      //落下位置对应数组坐标
            nX = cr.roundingOff(x, 117.5);
            nY = cr.roundingOff(y, 117.5);
            //double lX;       //落下位置像素坐标
            //double lY;
            //int originalX,originalY;
            //ab.tryGame(((chess) cp).originalY, ((chess) cp).originalX, cr.roundingOff(y, 117.5), cr.roundingOff(x, 117.5));

            if (x < 0) {
                cp.setBounds(nb.changeXToboard(((chess) cp).x), nb.changeYToboard(((chess) cp).y), cp.getWidth(), cp.getHeight());
            }
            if (y < 0) {
                cp.setBounds(nb.changeXToboard(((chess) cp).x), nb.changeYToboard(((chess) cp).y), cp.getWidth(), cp.getHeight());
            }
            if (x > 550) {      //getWidth为窗口长宽，cp.getWidth为组件长宽
                cp.setBounds(nb.changeXToboard(((chess) cp).x), nb.changeYToboard(((chess) cp).y), cp.getWidth(), cp.getHeight());
            }
            if (y > getHeight() - cp.getHeight()) {
                cp.setBounds(nb.changeXToboard(((chess) cp).x), nb.changeYToboard(((chess) cp).y), cp.getWidth(), cp.getHeight());
            }
            if (x > -5 && x < 550 && y > -5 && y < 800) {
                ab.tryGame(ab, ((chess) cp).y, ((chess) cp).x, cr.roundingOff(y, 117.5), cr.roundingOff(x, 117.5));
                if (ab.moveFlag) {
                    canRregret = true;
                    /*System.out.println("执行move之后：");*/
                    boardMove((chess) cp, nX, nY);
                    cp.setBounds(nb.changeXToboard(nX), nb.changeYToboard(nY), cp.getWidth(), cp.getHeight());

                    //判断吃子 并 移除控件
                    if (ab.moveFlag && !ab.flag) {
                        removeChess();
                    }
                    //虎吃子后判断胜利条件
                    Rules.rules(this, ab.moveFlag, ab.flag, ab.array, ab.ID);
                    //移动。吃子后打印棋盘
                    System.out.println("移动后的新棋盘：");
                    Print.print(ab.array);
                    /*System.out.println("落点坐标：" + nb.changeXToboard(nX) + " " + nb.changeYToboard(nY));*/
                    /*System.out.println("被移动棋子的坐标"+((chess) cp).originalY+((chess) cp).originalX+cr.roundingOff(y,117.5)+cr.roundingOff(x, 117.5));*/
                } else {
                    cp.setBounds(nb.changeXToboard(((chess) cp).x), nb.changeYToboard(((chess) cp).y), cp.getWidth(), cp.getHeight());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "快点击'开始游戏'按钮吧", "游戏还没开始的呢!", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    class MyListener extends MouseAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {        //鼠标拖动过程
            if (startSign) {
                Component cp = (Component) e.getSource();
                newX = e.getXOnScreen();        //拖动的时候记录新坐标
                newY = e.getYOnScreen();
                cp.setBounds(startX + (newX - oldX), startY + (newY - oldY), cp.getWidth(), cp.getHeight());        //设置bounds,将点下时记录的组件开始坐标与鼠标拖动的距离相加
                //System.out.println(cp.getX()+" "+cp.getY());
            } else {
            }
        }       //鼠标拖动
    }


    public void updateChessOriginalLocal(chess temp) {
        int lx, ly;
        lx = nb.changeXToboard(temp.x);
        ly = nb.changeYToboard(temp.y);
        temp.setBounds(lx, ly, 70, 70);
    }       //更新界面后棋子位置排布

    public void chessMove(int id) {
        switch (id) {
            case 99:
                System.out.println("转换坐标前老虎悔棋移动坐标：x:" + t.originalX + " y:" + t.originalY + " 面板坐标：" + nb.changeXToboard(t.originalX) + " " + nb.changeXToboard(t.originalY));
                t.setBounds(nb.changeXToboard(t.originalX), nb.changeYToboard(t.originalY), 70, 70);
                System.out.println("转换坐标后老虎悔棋移动坐标：x:" + t.originalX + " y:" + t.originalY + " 面板坐标：" + nb.changeXToboard(t.originalX) + " " + nb.changeXToboard(t.originalY));
                boardMove(t, t.originalX, t.originalY);
                break;
            case 1:
                d1.setBounds(nb.changeXToboard(d1.originalX), nb.changeYToboard(d1.originalY), 70, 70);
                boardMove(d1, d1.originalX, d1.originalY);
                break;
            case 2:
                d2.setBounds(nb.changeXToboard(d2.originalX), nb.changeYToboard(d2.originalY), 70, 70);
                boardMove(d2, d2.originalX, d2.originalY);
                break;
            case 3:
                d3.setBounds(nb.changeXToboard(d3.originalX), nb.changeYToboard(d3.originalY), 70, 70);
                boardMove(d3, d3.originalX, d3.originalY);
                break;
            case 4:
                d4.setBounds(nb.changeXToboard(d4.originalX), nb.changeYToboard(d4.originalY), 70, 70);
                boardMove(d4, d4.originalX, d4.originalY);
                break;
            case 5:
                d5.setBounds(nb.changeXToboard(d5.originalX), nb.changeYToboard(d5.originalY), 70, 70);
                boardMove(d5, d5.originalX, d5.originalY);
                break;
            case 6:
                d6.setBounds(nb.changeXToboard(d6.originalX), nb.changeYToboard(d6.originalY), 70, 70);
                boardMove(d6, d6.originalX, d6.originalY);
                break;
            case 7:
                d7.setBounds(nb.changeXToboard(d7.originalX), nb.changeYToboard(d7.originalY), 70, 70);
                boardMove(d7, d7.originalX, d7.originalY);
                break;
            case 8:
                d8.setBounds(nb.changeXToboard(d8.originalX), nb.changeYToboard(d8.originalY), 70, 70);
                boardMove(d8, d8.originalX, d8.originalY);
                break;
            case 9:
                d9.setBounds(nb.changeXToboard(d9.originalX), nb.changeYToboard(d9.originalY), 70, 70);
                boardMove(d9, d9.originalX, d9.originalY);
                break;
            case 10:
                d10.setBounds(nb.changeXToboard(d10.originalX), nb.changeYToboard(d10.originalY), 70, 70);
                boardMove(d10, d10.originalX, d10.originalY);
                break;
            case 11:
                d11.setBounds(nb.changeXToboard(d11.originalX), nb.changeYToboard(d11.originalY), 70, 70);
                boardMove(d11, d11.originalX, d11.originalY);
                break;
            case 12:
                d12.setBounds(nb.changeXToboard(d12.originalX), nb.changeYToboard(d12.originalY), 70, 70);
                boardMove(d12, d12.originalX, d12.originalY);
                break;
            case 13:
                d13.setBounds(nb.changeXToboard(d13.originalX), nb.changeYToboard(d13.originalY), 70, 70);
                boardMove(d13, d13.originalX, d13.originalY);
                break;
            case 14:
                d14.setBounds(nb.changeXToboard(d14.originalX), nb.changeYToboard(d14.originalY), 70, 70);
                boardMove(d14, d14.originalX, d14.originalY);
                break;
            case 15:
                d15.setBounds(nb.changeXToboard(d15.originalX), nb.changeYToboard(d15.originalY), 70, 70);
                boardMove(d15, d15.originalX, d15.originalY);
                break;
            case 16:
                d16.setBounds(nb.changeXToboard(d16.originalX), nb.changeYToboard(d16.originalY), 70, 70);
                boardMove(d16, d16.originalX, d16.originalY);
                break;
        }
    }       //悔棋棋子移动


    public void paint(Graphics g2) {
        Graphics2D g = (Graphics2D) g2;
        g.setStroke(new BasicStroke(3.0f));
        super.paint(g);
        g.setColor(Color.BLACK);
        g.drawLine(545, 0, 545, 850);
    }       //分界线


    public void removeChess() {
        List<Integer> eatenId = Eat.eat(ab.array, ab.ID);
        ab.eatenDogs = eatenId;
        for (int i = 0; i < eatenId.size(); i++) {
            switch (eatenId.get(i)) {
                case 1:
                    jBoard.remove(d1);
                    jBoard.repaint();
                    break;
                case 2:
                    jBoard.remove(d2);
                    jBoard.repaint();
                    break;
                case 3:
                    jBoard.remove(d3);
                    jBoard.repaint();
                    break;
                case 4:
                    jBoard.remove(d4);
                    jBoard.repaint();
                    break;
                case 5:
                    jBoard.remove(d5);
                    jBoard.repaint();
                    break;
                case 6:
                    jBoard.remove(d6);
                    jBoard.repaint();
                    break;
                case 7:
                    jBoard.remove(d7);
                    jBoard.repaint();
                    break;
                case 8:
                    jBoard.remove(d8);
                    jBoard.repaint();
                    break;
                case 9:
                    jBoard.remove(d9);
                    break;
                case 10:
                    jBoard.remove(d10);
                    break;
                case 11:
                    jBoard.remove(d11);
                    break;
                case 12:
                    jBoard.remove(d12);
                    break;
                case 13:
                    jBoard.remove(d13);
                    break;
                case 14:
                    jBoard.remove(d14);
                    break;
                case 15:
                    jBoard.remove(d15);
                    break;
                case 16:
                    jBoard.remove(d16);
                    break;
                default:
                    System.out.println("移除棋子获取参数错误");
                    break;
            }
            /*System.out.print(eatenId.get(i) + " ");*/
        }

        jBoard.repaint();
    }       //从当前位置移除棋子函数

    public void placeChess(int temp) {
        switch (temp) {
            case 1:
                jBoard.add(d1);
                break;
            case 2:
                jBoard.add(d2);
                break;
            case 3:
                jBoard.add(d3);
                break;
            case 4:
                jBoard.add(d4);
                break;
            case 5:
                jBoard.add(d5);
                break;
            case 6:
                jBoard.add(d6);
                break;
            case 7:
                jBoard.add(d7);
                break;
            case 8:
                jBoard.add(d8);
                break;
            case 9:
                jBoard.add(d9);
                break;
            case 10:
                jBoard.add(d10);
                break;
            case 11:
                jBoard.add(d11);
                break;
            case 12:
                jBoard.add(d12);
                break;
            case 13:
                jBoard.add(d13);
                break;
            case 14:
                jBoard.add(d14);
                break;
            case 15:
                jBoard.add(d15);
                break;
            case 16:
                jBoard.add(d16);
                break;
            default:
                break;
        }
        jBoard.repaint();
        jBoard.validate();
        updateChessOriginalLocal(t);
        updateChessOriginalLocal(d1);
        updateChessOriginalLocal(d2);
        updateChessOriginalLocal(d3);
        updateChessOriginalLocal(d4);
        updateChessOriginalLocal(d5);
        updateChessOriginalLocal(d6);
        updateChessOriginalLocal(d7);
        updateChessOriginalLocal(d8);
        updateChessOriginalLocal(d9);
        updateChessOriginalLocal(d10);
        updateChessOriginalLocal(d11);
        updateChessOriginalLocal(d12);
        updateChessOriginalLocal(d13);
        updateChessOriginalLocal(d14);
        updateChessOriginalLocal(d15);
        updateChessOriginalLocal(d16);
    }       //添加棋子回到原位置


    public void initialzeNumbers(){
        ab=new Game();
    }
}
