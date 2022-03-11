package unit;

import java.util.Objects;

public class Triangle {
    public Point a;
    public Point b;
    public Point p;

    public Triangle(){
        a = new Point();
        b = new Point();
        p = new Point();
    }

    public Triangle(Point a,Point b,Point p){
        this.a = a;
        this.b = b;
        this.p = p;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle tri = (Triangle) o;

        return  (tri.a.equals(this.a) && tri.b.equals(this.b) && tri.p.equals(this.p) ) ||
                (tri.a.equals(this.a) && tri.b.equals(this.p) && tri.p.equals(this.b) ) ||

                (tri.a.equals(this.b) && tri.b.equals(this.a) && tri.p.equals(this.p) ) ||
                (tri.a.equals(this.b) && tri.b.equals(this.p) && tri.p.equals(this.a) ) ||

                (tri.a.equals(this.p) && tri.b.equals(this.b) && tri.p.equals(this.a) ) ||
                (tri.a.equals(this.p) && tri.b.equals(this.a) && tri.p.equals(this.b) );
    }
}
