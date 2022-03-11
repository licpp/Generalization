import chart.Delaunay;
import chart.DelaunayTriangulation;
import file.LoadFile;
import unit.Point;
import unit.Triangle;
import view.Draw;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        File file = new File("points.txt");
        LoadFile.load(file, points);

        List<Triangle> tris = new LinkedList<>();

        //DelaunayTriangulation.triangulation(points,tris);

        Delaunay.get_net(points,tris);

        new Draw().draw(points,tris);

    }
}
