package unit;

import java.util.Objects;

public class Edge{
    public Point a;
    public Point b;

    public Edge() {
        this.a = new Point();
        this.b = new Point();
    }

    public Edge(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return (Objects.equals(a, edge.a) && Objects.equals(b, edge.b)) ||
                (Objects.equals(a, edge.b) && Objects.equals(b, edge.a));
    }

    //set集合不允许重复会先调用hashCode
    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
