package main;

import game.GameManager;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*; 
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

@SuppressWarnings("removal")
public class MainMenu extends JFrame {
    private static final long serialVersionUID = 1L;

    public MainMenu() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super("Sky Hunter");

        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon(getClass().getResource("/assets/cursor.png")).getImage(),
                new Point(0, 0), "custom cursor"));

        Color c = new Color(251, 251, 127);
        Color c2 = new Color(40, 39, 38);

        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon(getClass().getResource("/assets/menu_background.png"))));
        
        Box left = Box.createVerticalBox();

        JButton newGame = new JButton("Start"), exit = new JButton("Exit");
        left.setPreferredSize(new Dimension(355, 350));

        JPanel secondPanel = new JPanel();
        secondPanel.setOpaque(false);
        secondPanel.setLayout(new GridLayout(0, 1, 0, 0));
        secondPanel.setPreferredSize(new Dimension(330, 380));
        secondPanel.setBorder(BorderFactory.createEmptyBorder(0, 103, 40, 0));

        newGame.setFocusPainted(false);
        newGame.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, new Color(97, 93, 92)));
        newGame.setForeground(new Color(230, 230, 229));
        newGame.setFont(new Font("Arial", Font.PLAIN, 20));
        newGame.setBackground(c2);
        newGame.setOpaque(false);
        newGame.setContentAreaFilled(false);
        newGame.setBorderPainted(false);

        exit.setFocusPainted(false);
        exit.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, new Color(97, 93, 92)));
        exit.setForeground(new Color(230, 230, 229));
        exit.setFont(new Font("Arial", Font.PLAIN, 20));
        exit.setBackground(c2);
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);

        MouseAdapter ml = new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                AudioClip sound = null;
                try {
                    sound = Applet.newAudioClip(getClass().getResource("/assets/button_hover.wav"));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                sound.play();
                ((AbstractButton) e.getSource()).setBorderPainted(true);
                ((JComponent) e.getSource()).setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, c));
            }

            public void mouseExited(MouseEvent e) {
                ((AbstractButton) e.getSource()).setBorderPainted(false);
                ((JComponent) e.getSource()).setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, Color.GRAY));
            }
        };

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            GameStart();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                dispose();
            }

            private void GameStart() throws InterruptedException {
                GameManager game = new GameManager();
                game.GameStart();
            }
        });

        secondPanel.add(Box.createVerticalStrut(1));
        JLabel label = new JLabel("<html><b>Sky Hunter<b></html>", SwingConstants.CENTER);
        label.setForeground(new Color(247, 247, 247));
        label.setFont(new Font("X-Files", Font.PLAIN, 35));
        secondPanel.add(label);
        secondPanel.add(Box.createVerticalStrut(1));
        newGame.addMouseListener(ml);
        exit.addMouseListener(ml);

        secondPanel.add(newGame);
        secondPanel.add(exit);

        left.add(secondPanel);
        Box top = Box.createHorizontalBox();
        top.add(left);

        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        content.add(top, BorderLayout.WEST);

        setSize(894, 599);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        setLocation((int) width / 2 - 427, (int) height / 2 - 336);
        setUndecorated(true);
        setVisible(true);
    }

}
