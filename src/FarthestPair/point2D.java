package FarthestPair;

import java.util.Comparator;

public class point2D implements Comparable<point2D>{
	public static Comparator<point2D> X_ORDER = new xOrder();
	public static Comparator<point2D> Y_ORDER = new yOrder();
	public static Comparator<point2D> R_ORDER = new rOrder();
	private double x;   
    private double y;
    public point2D(double x, double y) {
        if (Double.isInfinite(x) || Double.isInfinite(y))
            throw new IllegalArgumentException("Coordinates must be finite");
        if (Double.isNaN(x) || Double.isNaN(y))
            throw new IllegalArgumentException("Coordinates cannot be NaN");
        if (x == 0.0) this.x = 0.0;
        else          this.x = x;

        if (y == 0.0) this.y = 0.0;
        else          this.y = y;
    }
	public double X() {
		return x;
	}
	public double Y() {
		return y;
	}
	public double R() {
		return Math.sqrt(x*x + y*y);
	}
	public double theta() {
		return Math.atan2(y, x);
	}
	public double angleTo(point2D other) {
		double dx = other.x - this.x;
		double dy = other.y - this.y;
		return Math.atan2(dy, dx);
	}
	public static int ccw(point2D a, point2D b, point2D c) {
        double area2 = (b.x-a.x)*(c.y-a.y) - (b.y-a.y)*(c.x-a.x);
        if      (area2 < 0) return -1;
        else if (area2 > 0) return +1;
        else                return  0;
    }
	public static double area2(point2D a, point2D b, point2D c) {
        return (b.x-a.x)*(c.y-a.y) - (b.y-a.y)*(c.x-a.x);
    }
	public double distanceTo(point2D other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx*dx + dy*dy);
    }
	public double distanceSquaredTo(point2D other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx*dx + dy*dy);
    }
	@Override
	public int compareTo(point2D o) {
		if(this.y < o.y) return -1;
		if(this.y > o.y) return 1;
		if(this.x < o.x) return -1;
		if(this.x > o.x) return 1;
		return 0;
	}
	private static class xOrder implements Comparator<point2D>{
		@Override
		public int compare(point2D o1, point2D o2) {
			if(o1.x < o2.x) return -1;
			if(o1.x > o2.x) return 1;
			return 0;
		}
	}
	private static class yOrder implements Comparator<point2D>{
		@Override
		public int compare(point2D o1, point2D o2) {
			if(o1.y < o2.y) return -1;
			if(o1.y > o2.y) return 1;
			return 0;
		}
	}
	private static class rOrder implements Comparator<point2D>{
		@Override
		public int compare(point2D o1, point2D o2) {
			double tmp = (o1.x*o1.x + o1.y*o1.y) - (o2.x*o2.x + o2.y*o2.y);
			if(tmp < 0) return -1;
			if(tmp > 0) return 1;
			return 0;
		}
	}
	private class DistanceToOrder implements Comparator<point2D> {
        public int compare(point2D p, point2D q) {
            double dist1 = distanceSquaredTo(p);
            double dist2 = distanceSquaredTo(q);
            if      (dist1 < dist2) return -1;
            else if (dist1 > dist2) return +1;
            else return  0;
        }
    }
	private class Atan2Order implements Comparator<point2D> {
        public int compare(point2D q1, point2D q2) {
            double angle1 = angleTo(q1);
            double angle2 = angleTo(q2);
            if      (angle1 < angle2) return -1;
            else if (angle1 > angle2) return +1;
            else                      return  0;
        }
    }
	private class PolarOrder implements Comparator<point2D> {
        public int compare(point2D q1, point2D q2) {
            double dx1 = q1.x - x;
            double dy1 = q1.y - y;
            double dx2 = q2.x - x;
            double dy2 = q2.y - y;

            if      (dy1 >= 0 && dy2 < 0) return -1;    
            else if (dy2 >= 0 && dy1 < 0) return +1;    
            else if (dy1 == 0 && dy2 == 0) {        
                if      (dx1 >= 0 && dx2 < 0) return -1;
                else if (dx2 >= 0 && dx1 < 0) return +1;
                else                          return  0;
            }
            else return -ccw(point2D.this, q1, q2);  
        }
    }
	public Comparator<point2D> polarOrder() {
        return new PolarOrder();
    }
    public Comparator<point2D> atan2Order() {
        return new Atan2Order();
    }
    public Comparator<point2D> distanceToOrder() {
        return new DistanceToOrder();
    }
    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        point2D that = (point2D) other;
        return this.x == that.x && this.y == that.y;
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    @Override
    public int hashCode() {
        int hashX = ((Double) x).hashCode();
        int hashY = ((Double) y).hashCode();
        return 31*hashX + hashY;
    }
}
