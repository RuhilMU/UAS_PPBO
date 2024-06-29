package game.device;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Display extends JPanel implements Runnable {
    private static final long serialVersionUID = 1686728024580363756L;

    private Semaphore semp;
    private JLabel label;

    ConcurrentHashMap<String, BufferedImage> picMap;
    CopyOnWriteArrayList<DisplayInfo> displayList;

    public Display(Semaphore semp, ConcurrentHashMap<String, BufferedImage> picMap, CopyOnWriteArrayList<DisplayInfo> displayList) {
        this.setBackground(Color.white);

        this.semp = semp;
        this.picMap = picMap;
        this.displayList = displayList;

        this.label = new JLabel("<html><body><center><p>Press Enter to Replay<br>Press Esc to Exit</p></center></body></html>"); 
        this.add(label);

        loadImages(); 

        new Thread(this).start();
    }

    public final void showMessage(String message) {

    }
    

    private void loadImages() {
        try {
            BufferedImage pic_t;
            pic_t = ImageIO.read(new File("assets\\you'reDead.png"));
            if(pic_t != null) picMap.put("you-are-dead", pic_t);
            pic_t = ImageIO.read(new File("assets\\air_me_u.png"));
            if(pic_t != null) picMap.put("airMeU", pic_t);
            pic_t = ImageIO.read(new File("assets\\air_me_d.png"));
            if(pic_t != null) picMap.put("airMeD", pic_t);
            pic_t = ImageIO.read(new File("assets\\air_me_l.png"));
            if(pic_t != null) picMap.put("airMeL", pic_t);
            pic_t = ImageIO.read(new File("assets\\air_me_r.png"));
            if(pic_t != null) picMap.put("airMeR", pic_t);
            pic_t = ImageIO.read(new File("assets\\air_me_ul.png"));
            if(pic_t != null) picMap.put("airMeUL", pic_t);
            pic_t = ImageIO.read(new File("assets\\air_me_ur.png"));
            if(pic_t != null) picMap.put("airMeUR", pic_t);
            pic_t = ImageIO.read(new File("assets\\air_me_dl.png"));
            if(pic_t != null) picMap.put("airMeDL", pic_t);
            pic_t = ImageIO.read(new File("assets\\air_me_dr.png"));
            if(pic_t != null) picMap.put("airMeDR", pic_t);
            pic_t = ImageIO.read(new File("assets\\air_enemy_u.png"));
            if(pic_t != null) picMap.put("airEnemyU", pic_t);
            pic_t = ImageIO.read(new File("assets\\air_enemy_d.png"));
            if(pic_t != null) picMap.put("airEnemyD", pic_t);
            pic_t = ImageIO.read(new File("assets\\air_enemy_l.png"));
            if(pic_t != null) picMap.put("airEnemyL", pic_t);
            pic_t = ImageIO.read(new File("assets\\air_enemy_r.png"));
            if(pic_t != null) picMap.put("airEnemyR", pic_t);
            pic_t = ImageIO.read(new File("assets\\air_enemy_ul.png"));
            if(pic_t != null) picMap.put("airEnemyUL", pic_t);
            pic_t = ImageIO.read(new File("assets\\air_enemy_ur.png"));
            if(pic_t != null) picMap.put("airEnemyUR", pic_t);
            pic_t = ImageIO.read(new File("assets\\air_enemy_dl.png"));
            if(pic_t != null) picMap.put("airEnemyDL", pic_t);
            pic_t = ImageIO.read(new File("assets\\air_enemy_dr.png"));
            if(pic_t != null) picMap.put("airEnemyDR", pic_t);

            pic_t = ImageIO.read(new File("assets\\bulletU.png"));
            if(pic_t != null) picMap.put("bulletU", pic_t);
            pic_t = ImageIO.read(new File("assets\\bulletUL.png"));
            if(pic_t != null) picMap.put("bulletUL", pic_t);
            pic_t = ImageIO.read(new File("assets\\bulletUR.png"));
            if(pic_t != null) picMap.put("bulletUR", pic_t);
            pic_t = ImageIO.read(new File("assets\\bulletD.png"));
            if(pic_t != null) picMap.put("bulletD", pic_t);
            pic_t = ImageIO.read(new File("assets\\bulletDL.png"));
            if(pic_t != null) picMap.put("bulletDL", pic_t);
            pic_t = ImageIO.read(new File("assets\\bulletDR.png"));
            if(pic_t != null) picMap.put("bulletDR", pic_t);
            pic_t = ImageIO.read(new File("assets\\bulletL.png"));
            if(pic_t != null) picMap.put("bulletL", pic_t);
            pic_t = ImageIO.read(new File("assets\\bulletR.png"));
            if(pic_t != null) picMap.put("bulletR", pic_t);

            pic_t = ImageIO.read(new File("assets\\EbulletU.png"));
            if(pic_t != null) picMap.put("EbulletU", pic_t);
            pic_t = ImageIO.read(new File("assets\\EbulletUL.png"));
            if(pic_t != null) picMap.put("EbulletUL", pic_t);
            pic_t = ImageIO.read(new File("assets\\EbulletUR.png"));
            if(pic_t != null) picMap.put("EbulletUR", pic_t);
            pic_t = ImageIO.read(new File("assets\\EbulletD.png"));
            if(pic_t != null) picMap.put("EbulletD", pic_t);
            pic_t = ImageIO.read(new File("assets\\EbulletDL.png"));
            if(pic_t != null) picMap.put("EbulletDL", pic_t);
            pic_t = ImageIO.read(new File("assets\\EbulletDR.png"));
            if(pic_t != null) picMap.put("EbulletDR", pic_t);
            pic_t = ImageIO.read(new File("assets\\EbulletL.png"));
            if(pic_t != null) picMap.put("EbulletL", pic_t);
            pic_t = ImageIO.read(new File("assets\\EbulletR.png"));
            if(pic_t != null) picMap.put("EbulletR", pic_t);

            pic_t = ImageIO.read(new File("assets\\ex0.png"));
            if(pic_t != null) picMap.put("ex0", pic_t);
            pic_t = ImageIO.read(new File("assets\\ex1.png"));
            if(pic_t != null) picMap.put("ex1", pic_t);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        try {       //pengecualian :)
            semp.acquire();
            for(DisplayInfo it: displayList) {
                g.drawImage(picMap.get(it.picName), it.x, it.y, it.width, it.height, this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semp.release();
        }
    }

    // Overload
    public void paint(Graphics g, String picName, int x, int y, int width, int height) {
        try {
            semp.acquire();
            BufferedImage img = picMap.get(picName);
            if (img != null) {
                g.drawImage(img, x, y, width, height, this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semp.release();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1);
                this.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void updateLabelText(String text) {
        label.setText(text);
    }
}

