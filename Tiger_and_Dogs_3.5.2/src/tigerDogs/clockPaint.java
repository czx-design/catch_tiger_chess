package tigerDogs;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

class clockPaint extends JPanel implements Runnable {
    int h, m, s, x, y, r, m1, s1;
    int sm,ss;
    double rad = Math.PI / 180;
    chessBoard cb;

    public clockPaint(int x, int y, int r, int lx, int ly,chessBoard cb) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.cb=cb;
        Calendar time = new GregorianCalendar();
        h = (time.get(Calendar.HOUR_OF_DAY) - 12) * 30 + (time.get(Calendar.MINUTE) / 60 * 30);      //时针
        m = time.get(Calendar.MINUTE) * 6;        //分针
        s = time.get(Calendar.SECOND) * 6;        //秒针
        Thread t = new Thread(this);
        t.start();
        setBounds(lx, ly, 170, 235);
        setBackground(null);
        setOpaque(false);

        this.ss=0;
        this.sm=0;
        this.m1 = 3;
        this.s1 = 0;

    }


    public void paint(Graphics g2) {
        Graphics2D g = (Graphics2D) g2;
        int x1, y1;
        super.paint(g);
        g.setStroke(new BasicStroke(3.0f));
        g.setColor(Color.BLACK);
        g.drawOval(x, y, r * 2, r * 2);        //画圆

        //g.setColor(Color.BLACK);
        x1 = (int) ((r - 10) * Math.sin(rad * s));
        y1 = (int) ((r - 10) * Math.cos(rad * s));
        g.drawLine(x + r, y + r, x + x1 + r, y - y1 + r);      //画秒针

        //g.setColor(Color.BLACK);
        x1 = (int) ((r - r / 2.5) * Math.sin(rad * m));
        y1 = (int) ((r - r / 2.5) * Math.cos(rad * m));
        g.drawLine(x + r, y + r, x + r + x1, y + r - y1);       //分针

        //g.setColor(Color.BLACK);
        x1 = (int) ((r - r / 1.5) * Math.sin(rad * h));
        y1 = (int) ((r - r / 1.5) * Math.cos(rad * h));
        g.drawLine(x + r, y + r, x + r + x1, y + r - y1);       //时针

        //g.setColor(Color.BLACK);
        int d = 29;
        for (int i = 1; i <= 12; i++) {
            x1 = (int) ((r - 10) * Math.sin(rad * d));
            y1 = (int) ((r - 10) * Math.cos(rad * d));
            g.drawString(i + " ", x + r + x1 - 4, x + r - y1 + 5);       //显示数字*
            d += 30;
        }

        d = 0;
        for (int i = 0; i < 60; i++) {
            x1 = (int) ((r - 2) * Math.sin(rad * d));
            y1 = (int) ((r - 2) * Math.cos(rad * d));
            g.drawString(".", x + r + x1 - 1, x + r - y1 + 1);      //分钟小点
            d += 6;
        }
        g.drawString("游戏已进行时间",40,190);
        g.drawString("倒计时:",40,230);
        if (cb.startSign) {
            g.drawString( sm + " : " + ss, 75, 210);
            g.drawString( m1 + " : " + s1, 85, 230);        //左上角数字时间显示
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
            }
            s += 6;
            if (s >= 360) {
                s = 0;
                m += 6;
                if ((m == 72) || (m == 144) || (m == 216) || (m == 288)) {
                    h += 6;
                }
                if (m >= 360) {
                    m = 0;
                    h += 6;
                }
                if (h >= 360) {
                    h = 0;
                }
            }
            if (cb.startSign) {
                ss++;
                s1--;
                if (ss>=60){
                    sm++;
                    ss=0;
                }
                if (s1 <= 0) {
                    m1--;
                    s1 = 59;
                    if (m1<=0){
                        cb.startSign=false;
                        int gameOver=JOptionPane.showConfirmDialog(null, "重新开始？", "游戏时间到了！",JOptionPane.YES_NO_OPTION);
                        if (gameOver==0){
                            cb.ia.initialize();
                        }
                    }
                }
            }
            this.repaint();
        }
    }
}

