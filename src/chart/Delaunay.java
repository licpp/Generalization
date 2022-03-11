package chart;

import unit.Edge;
import unit.Point;
import unit.Triangle;

import java.util.*;

public class Delaunay {
    //删除不合法的三角形
    public static boolean isLegal(Triangle tri,List<Point> points){
        Point center = new Point();
        double r;
        r = get_circle(tri,center);
        for(Point point: points){
            if(point.x > center.x+r)
                return true;
            if(point.equals(tri.a) || point.equals(tri.b) || point.equals(tri.p))
                continue;
            if(inCircle(point,center,r))
                return false;
        }
        return true;
    }

    public static void getSuTri(List<Point> points, List<Triangle> triangles){


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

            triangles.add(suTri);

    }
    //判断是否在圆内
    private static boolean inCircle(Point p, Point center, double r) {

        return Math.sqrt(Math.pow(p.x - center.x,2) + Math.pow(p.y - center.y, 2)) < r;
    }

    private static double get_circle(Triangle tri, Point center) {

        double x1  =  tri.a.x;
        double x2  =  tri.b.x;
        double x3  =  tri.p.x;
        double y1  =  tri.a.y;
        double y2  =  tri.b.y;
        double y3  =  tri.p.y;

        //求外接圆圆心
        double t1=x1*x1+y1*y1;
        double t2=x2*x2+y2*y2;
        double t3=x3*x3+y3*y3;
        double temp=x1*y2+x2*y3+x3*y1-x1*y3-x2*y1-x3*y2;
        center.x=(t2*y3+t1*y2+t3*y1-t2*y1-t3*y2-t1*y3)/temp/2;
        center.y=(t3*x2+t2*x1+t1*x3-t1*x2-t2*x3-t3*x1)/temp/2;

        //求外接圆半径
        double a=Math.sqrt( (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2) );
        double b=Math.sqrt( (x1-x3)*(x1-x3)+(y1-y3)*(y1-y3) );
        double c=Math.sqrt( (x2-x3)*(x2-x3)+(y2-y3)*(y2-y3) );
        double p=(a+b+c)/2.0;
        double S=Math.sqrt( p*(p-a)*(p-b)*(p-c) );

        return a*b*c/(4*S);
    }

    public static void get_net(List<Point> points, List<Triangle> triangles) {
        if(points.size()<3)
            return;
        List<Triangle> tempTri = new LinkedList<>();
        //不可重复
        Set<Edge> edges = new HashSet<>();
        Point center = new Point();
        double r;
        ListIterator<Triangle> iter;

        //点坐标排序
        points.sort(Comparator.naturalOrder());

        //得到大三角形
        getSuTri(points,tempTri);
        triangles.add(tempTri.get(0));

        //遍历点集
        for(Point point: points){

            edges.clear();
            iter = tempTri.listIterator();
            //遍历三角形集合
            while(iter.hasNext()){
                Triangle tri = iter.next();
                r = get_circle(tri,center);
                //在圆的右侧
                if(center.x+r<point.x && isLegal(tri,points)){
                    triangles.add(tri);
                    iter.remove();
                    continue;
                }
                if(inCircle(point,center,r)) {
                    edges.add(new Edge(tri.a, tri.b));
                    edges.add(new Edge(tri.a, tri.p));
                    edges.add(new Edge(tri.b, tri.p));
                    iter.remove();
                }

            }
            //组成新的三角形
            System.out.println(edges.size());
            for(Edge edge: edges){
                Triangle tri = new Triangle(edge.a,edge.b,point);
                tempTri.add(tri);
            }
        }
        //合并
        for(Triangle tri:tempTri){
            if(isLegal(tri,points))
                triangles.add(tri);
        }
        //去除与大三角形相关的三角形和不合法的三角形
        Triangle suTri = triangles.get(0);
        triangles.removeIf(tri -> tri.a.equals(suTri.a) || tri.a.equals(suTri.b) || tri.a.equals(suTri.p)
                || tri.b.equals(suTri.a) || tri.b.equals(suTri.b) || tri.b.equals(suTri.p)
                || tri.p.equals(suTri.a) || tri.p.equals(suTri.b) || tri.p.equals(suTri.p));
    }
}
