package unit;

import java.util.Objects;

public class Point implements Comparable<Point>{
    public double x;
    public double y;
    public double cos = 0;
    public double power =0;
    public boolean isBeside = false;

    public Point(){
    }

    public Point(double x,double y){
        this.x = x;
        this.y = y;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public String toString() {
        return "[" + String.format("%.2f",x) + "," + String.format("%.2f",y) + ']';
    }


    @Override
    public int compareTo(Point p) {
        if (this.x == p.x && this.y == p.y)
            return 0;

        if (this.x == p.x)
            return this.y > p.y ? 1 : -1;
        else
            return this.x > p.x ? 1 : -1;
    }
}
