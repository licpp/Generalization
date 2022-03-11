package view;

import unit.Point;
import unit.Triangle;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Draw {

    public static final int WIDTH = 600;
    public static final int LENGTH = 600;
    public static final int RIM = 100;//边框
    public static final int RADIUS = 2;

    JFrame frame = new JFrame();
    List<Point> points;
    List<Triangle> triangles;

    class myCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            g.setColor(Color.BLUE);
            for (Triangle tri: triangles){
               g.drawLine((int)tri.a.x+ RIM / 2,(int)tri.a.y+ RIM / 2,(int)tri.b.x+ RIM / 2,(int)tri.b.y+ RIM / 2);
               g.drawLine((int)tri.a.x+ RIM / 2,(int)tri.a.y+ RIM / 2,(int)tri.p.x+ RIM / 2,(int)tri.p.y+ RIM / 2);
               g.drawLine((int)tri.b.x+ RIM / 2,(int)tri.b.y+ RIM / 2,(int)tri.p.x+ RIM / 2,(int)tri.p.y+ RIM / 2);
            }
            g.setColor(Color.RED);
            for (Point point:points)
                g.fillOval((int)point.x + RIM / 2 - RADIUS, (int)point.y + RIM / 2 - RADIUS, RADIUS * 2, RADIUS * 2);
        }
    }
    private void initPoint(List<Point> points){
        for(Point point: points){
            point.x =WIDTH / 100.0 * point.x;
            point.y =LENGTH / 100.0 * point.y;
        }

    }
    public void draw(List<Point> points,List<Triangle> tris){
        this.points = points;
        this.triangles = tris;
        initPoint(points);


        myCanvas drawArea = new myCanvas();
        drawArea.setSize(WIDTH+RIM,LENGTH+RIM);
        frame.add(drawArea);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
