package chart;
/*
import unit.Point;
import unit.Triangle;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
*/
public class DelaunayTriangulation {
/*
    static final double EPSILON = Math.pow(1,-6);

    static Triangle hugeTri(List<Point> points){
        //先得到外接矩形,得到外接矩形的外接三角形
        double x_min = Double.MAX_VALUE;
        double x_max = Double.MIN_VALUE;
        double y_min = Double.MAX_VALUE;
        double y_max = Double.MIN_VALUE;
        double x_mid;
        double dx;
        double dy;
        double d_max;

        for(Point point: points){
            if(point.x > x_max)
                x_max = point.x;
            if(point.x < x_min)
                x_min = point.x;
            if(point.y > y_max)
                y_max = point.y;
            if(point.y < y_min)
                y_min = point.y;
        }

        dx = x_max - x_min;
        dy = y_max - y_min;
        x_mid = (int)((x_max + x_min) / 2.0);

        Triangle suTri = new Triangle();

        d_max = Math.max(dx, dy);

        suTri.a.y = y_min - 5;
        suTri.b.y = y_min - 5;

        suTri.a.x = x_mid - d_max - 5;
        suTri.b.x = x_mid + d_max + 5;

        suTri.p.x = x_mid;
        suTri.p.y = y_max + d_max + 5;

        return suTri;
    }

    static double getArea(Triangle tri){
        double x1  =  tri.a.x;
        double x2  =  tri.b.x;
        double x3  =  tri.p.x;
        double y1  =  tri.a.y;
        double y2  =  tri.b.y;
        double y3  =  tri.p.y;

        double a=Math.sqrt( (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2) );
        double b=Math.sqrt( (x1-x3)*(x1-x3)+(y1-y3)*(y1-y3) );
        double c=Math.sqrt( (x2-x3)*(x2-x3)+(y2-y3)*(y2-y3) );
        double p=(a+b+c)/2.0;


        return Math.sqrt( p*(p-a)*(p-b)*(p-c) );
    }

    static boolean inTriangle(Point point,Triangle tri){
        return Math.abs(getArea(tri) - getArea(new Triangle(tri.a,tri.b,point))-getArea(new Triangle(tri.a,tri.p,point))-getArea(new Triangle(tri.b,tri.p,point))) < EPSILON;
    }

    static Triangle outerTri(Point point,List<Triangle> tris){
        Triangle outer=null;
        for (Triangle tri: tris){
            if(inTriangle(point,tri)){
                outer = tri;
                break;
            }
        }
        return outer;
    }

    public static void triangulation(List<Point> points,List<Triangle> tris){
        Triangle suTri = hugeTri(points);
        tris.add(suTri);
        for(Point point: points){
            Triangle outerTri = outerTri(point,tris);
            //如果在内部
            if(outerTri != null){
                tris.add(new Triangle(outerTri.a,outerTri.b,point));
                tris.add(new Triangle(outerTri.a,outerTri.p,point));
                tris.add(new Triangle(outerTri.b,outerTri.p,point));
                tris.remove(outerTri);
                System.out.println(tris.size());
            }
            //如果落在边上
        }


        //删除和大三角形有关的边
        tris.removeIf(tri -> tri.a.equals(suTri.a) || tri.a.equals(suTri.b) || tri.a.equals(suTri.p)
                || tri.b.equals(suTri.a) || tri.b.equals(suTri.b) || tri.b.equals(suTri.p)
                || tri.p.equals(suTri.a) || tri.p.equals(suTri.b) || tri.p.equals(suTri.p));

    }

    public static void test(List<Point> points){
        List<Triangle> tris = new LinkedList<>();
        tris.add(hugeTri(points));
        Triangle outer = outerTri(points.get(0),tris);
        System.out.println(outer.a);
    }

*/
}
