import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConnectTheDots extends JFrame {
    private int prevX = -1, prevY = -1;
    private boolean gameOver = false;

    public ConnectTheDots() {
        setTitle("Connect the Dots");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLUE);
                g.fillOval(100, 100, 50, 50);
                g.fillOval(200, 100, 50, 50);
                g.fillOval(300, 100, 50, 50);
                g.fillOval(150, 200, 50, 50);
                g.fillOval(250, 200, 50, 50);
                g.fillOval(100, 300, 50, 50);
                g.fillOval(200, 300, 50, 50);
                g.fillOval(300, 300, 50, 50);
            }
        };

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (gameOver) {
                    return;
                }

                int x = e.getX();
                int y = e.getY();

                if (prevX == -1 || prevY == -1) {
                    prevX = x;
                    prevY = y;
                } else {
                    Graphics g = canvas.getGraphics();
                    g.setColor(Color.RED);
                    g.drawLine(prevX, prevY, x, y);
                    prevX = x;
                    prevY = y;
                }

                if (isGameComplete()) {
                    JOptionPane.showMessageDialog(canvas, "Congratulations! You have completed the game.");
                    gameOver = true;
                }
            }
        });

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameOver = false;
                prevX = -1;
                prevY = -1;
                canvas.repaint();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(resetButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(canvas, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private boolean isGameComplete() {
        // Implement your logic for checking if the game is complete here
        return false;
    }

    public static void main(String[] args) {
        new ConnectTheDots();
    }
}
