package PR5.PR5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Paint extends JFrame {

    private final List<Line> lines = new ArrayList<>();
    private Color currentColor = Color.BLACK;
    private int currentThickness = 2;

    public Paint() {
        setTitle("Simple Paint");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPanel panel = new DrawingPanel();
        add(panel, BorderLayout.CENTER);

        createMenuBar();

        pack();
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // Меню "Цвет"
        JMenu colorMenu = new JMenu("Цвет");
        String[] colors = { "Красный", "Оранжевый", "Жёлтый", "Зелёный", "Синий",
                            "Розовый", "Чёрный", "Серый", "Белый"};
        Color[] colorValues = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE,
                                Color.PINK, Color.BLACK, Color.LIGHT_GRAY, Color.WHITE};

        for (int i = 0; i < colors.length; i++) {
            JMenuItem colorItem = new JMenuItem(colors[i]);
            final Color color = colorValues[i];
            colorItem.addActionListener(e -> currentColor = color);
            colorMenu.add(colorItem);
        }

        JMenu thicknessMenu = new JMenu("Толщина");
        int[] thicknesses = {1, 2, 4, 6, 8, 10, 15, 20, 25};

        for (int thickness : thicknesses) {
            JMenuItem thicknessItem = new JMenuItem(thickness + " px");
            thicknessItem.addActionListener(e -> currentThickness = thickness);
            thicknessMenu.add(thicknessItem);
        }

        menuBar.add(colorMenu);
        menuBar.add(thicknessMenu);
        setJMenuBar(menuBar);
    }

    private class DrawingPanel extends JPanel {
        private Point startPoint;

        public DrawingPanel() {
            setPreferredSize(new Dimension(1280, 720));
            setBackground(Color.WHITE);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        startPoint = e.getPoint();
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON1 && startPoint != null) {
                        lines.add(new Line(startPoint, e.getPoint(), currentColor, currentThickness));
                        startPoint = null;
                        repaint();
                    }
                }
            });

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    if (startPoint != null) {
                        lines.add(new Line(startPoint, e.getPoint(), currentColor, currentThickness));
                        startPoint = e.getPoint();
                        repaint();
                    }
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Line line : lines) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(line.color);
                g2d.setStroke(new BasicStroke(line.thickness));
                g2d.drawLine(line.start.x, line.start.y, line.end.x, line.end.y);
            }
        }
    }

    private static class Line {
        Point start, end;
        Color color;
        int thickness;

        public Line(Point start, Point end, Color color, int thickness) {
            this.start = start;
            this.end = end;
            this.color = color;
            this.thickness = thickness;
        }
    }
}
