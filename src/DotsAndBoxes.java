import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConnectTheDots extends JFrame {
    private int prevX = -1, prevY = -1;
    private boolean gameOver = false;
    private int[][] boxes = new int[3][3];
    private int player = 1;

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

                g.setColor(Color.RED);
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (boxes[i][j] == 1) {
                            g.drawLine(125 + i * 100, 125 + j * 100, 175 + i * 100, 125 + j * 100);
                            g.drawLine(175 + i * 100, 125 + j * 100, 175 + i * 100, 175 + j * 100);
                            g.drawLine(175 + i * 100, 175 + j * 100, 125 + i * 100, 175 + j * 100);
                            g.drawLine(125 + i * 100, 175 + j * 100, 125 + i * 100, 125 + j * 100);
                        } else if (boxes[i][j] == 2) {
                            g.drawLine(125 + i * 100, 125 + j * 100, 175 + i * 100, 125 + j * 100);
                            g.drawLine(175 + i * 100, 125 + j * 100, 175 + i * 100, 175 + j * 100);
                            g.drawLine(175 + i * 100, 175 + j * 100, 125 + i * 100, 175 + j * 100);
                            g.drawLine(125 + i * 100, 175 + j * 100, 125 + i * 100, 125 + j * 100);
                        }
                    }
                }
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

                int col = -1, row = -1;

                if (x >= 100 && x <= 150) {
                    col = 0;
                } else if (x >= 200 && x <= 250) {
                    col = 1;
                } else if (x >= 300 && x = 350) {
                    col = 2;
                    }
                    if (y >= 100 && y <= 150) {
                        row = 0;
                    } else if (y >= 200 && y <= 250) {
                        row = 1;
                    } else if (y >= 300 && y <= 350) {
                        row = 2;
                    }
        
                    if (col != -1 && row != -1) {
                        if (prevX == -1 && prevY == -1) {
                            prevX = col;
                            prevY = row;
                        } else if (prevX == col && prevY == row) {
                            // do nothing
                        } else if (prevX == col && prevY == row - 1) {
                            makeLine(prevX, prevY, col, row, player);
                            prevX = col;
                            prevY = row;
                        } else if (prevX == col && prevY == row + 1) {
                            makeLine(prevX, row, col, prevY, player);
                            prevX = col;
                            prevY = row;
                        } else if (prevX == col - 1 && prevY == row) {
                            makeLine(prevX, prevY, col, row, player);
                            prevX = col;
                            prevY = row;
                        } else if (prevX == col + 1 && prevY == row) {
                            makeLine(col, row, prevX, prevY, player);
                            prevX = col;
                            prevY = row;
                        } else {
                            // invalid move
                        }
                    }
        
                    canvas.repaint();
                }
            });
        
            add(canvas);
            setVisible(true);
        }
        
        private void makeLine(int x1, int y1, int x2, int y2, int player) {
            if (boxes[x1][y1] == 0 && boxes[x2][y2] == 0) {
                boxes[x1][y1] = player;
                boxes[x2][y2] = player;
                if (checkForBox(x1, y1, x2, y2)) {
                    JOptionPane.showMessageDialog(this, "Player " + player + " has made a box!");
                    boxes[x1][y1] = player;
                    boxes[x2][y2] = player;
                    if (player == 1) {
                        player = 2;
                    } else {
                        player = 1;
                    }
                } else {
                    if (player == 1) {
                        player = 2;
                    } else {
                        player = 1;
                    }
                }
            }
            checkForGameOver();
        }
        
        private boolean checkForBox(int x1, int y1, int x2, int y2) {
            if (x1 == x2) {
                if (y1 > y2) {
                    int temp = y1;
                    y1 = y2;
                    y2 = temp;
                }
                if (y1 > 0 && boxes[x1][y1 - 1] != 0 && boxes[x1][y1 - 1] != player) {
                    if (y1 < 2 && boxes[x1][y1 + 1] != 0 && boxes[x1][y1 + 1] != player) {
                        if (boxes[x1][y1 - 1] == boxes[x1][y1 + 1]) {
                            boxes[x1][y1 - 1] = player;
                            boxes[x1][y1 + 1] = player;
                            return true;
                        }
                    }
                }
                if (y1 < 2 && boxes[x1][y1 + 2] != 0 && boxes[x1][y1 + 2] != player) {
                    if (boxes[x1][y1 + 1] == boxes[x1][y1 + 2]) {
                    boxes[x1][y1 + 1] = player;
                    boxes[x1][y1 + 2] = player;
                    return true;
                    }
                    }
                    } else {
                    if (x1 > x2) {
                    int temp = x1;
                    x1 = x2;
                    x2 = temp;
                    }
                    if (x1 > 0 && boxes[x1 - 1][y1] != 0 && boxes[x1 - 1][y1] != player) {
                    if (x1 < 2 && boxes[x1 + 1][y1] != 0 && boxes[x1 + 1][y1] != player) {
                    if (boxes[x1 - 1][y1] == boxes[x1 + 1][y1]) {
                    boxes[x1 - 1][y1] = player;
                    boxes[x1 + 1][y1] = player;
                    return true;
                    }
                    }
                    }
                    if (x1 < 2 && boxes[x1 + 2][y1] != 0 && boxes[x1 + 2][y1] != player) {
                    if (boxes[x1 + 1][y1] == boxes[x1 + 2][y1]) {
                    boxes[x1 + 1][y1] = player;
                    boxes[x1 + 2][y1] = player;
                    return true;
                    }
                    }
                    }
                    return false;
                    }

                    private void checkForGameOver() {
                        boolean gameOver = true;
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                if (boxes[i][j] == 0) {
                                    gameOver = false;
                                    break;
                                }
                            }
                            if (!gameOver) {
                                break;
                            }
                        }
                        if (gameOver) {
                            int player1Score = 0;
                            int player2Score = 0;
                            for (int i = 0; i < 3; i++) {
                                for (int j = 0; j < 3; j++) {
                                    if (boxes[i][j] == 1) {
                                        player1Score++;
                                    } else if (boxes[i][j] == 2) {
                                        player2Score++;
                                    }
                                }
                            }
                            if (player1Score > player2Score) {
                                JOptionPane.showMessageDialog(this, "Player 1 wins!");
                            } else if (player2Score > player1Score) {
                                JOptionPane.showMessageDialog(this, "Player 2 wins!");
                            } else {
                                JOptionPane.showMessageDialog(this, "It's a tie!");
                            }
                            System.exit(0);
                        }
                    }
                    
                    public static void main(String[] args) {
                        new DotsAndBoxes();
                    }
                }
        
