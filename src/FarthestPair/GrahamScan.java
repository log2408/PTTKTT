package FarthestPair;

import java.util.Arrays;
import java.util.Stack;

public class GrahamScan {
	private Stack<point2D> hull = new Stack<point2D>();

    /**
     * Computes the convex hull of the specified array of points.
     *
     * @param  points the array of points
     * @throws IllegalArgumentException if {@code points} is {@code null}
     * @throws IllegalArgumentException if any entry in {@code points[]} is {@code null}
     * @throws IllegalArgumentException if {@code points.length} is {@code 0}
     */
    public GrahamScan(point2D[] points) {
        if (points == null) throw new IllegalArgumentException("argument is null");
        if (points.length == 0) throw new IllegalArgumentException("array is of length 0");
        int n = points.length;
        point2D[] a = new point2D[n];
        for (int i = 0; i < n; i++) {
            if (points[i] == null)
                throw new IllegalArgumentException("points[" + i + "] is null");
            a[i] = points[i];
        }
        Arrays.sort(a);
        Arrays.sort(a, 1, n, a[0].polarOrder());
        hull.push(a[0]);   
        int k1;
        for (k1 = 1; k1 < n; k1++)
            if (!a[0].equals(a[k1])) break;
        if (k1 == n) return;
        int k2;
        for (k2 = k1+1; k2 < n; k2++)
            if (point2D.ccw(a[0], a[k1], a[k2]) != 0) break;
        hull.push(a[k2-1]);
        for (int i = k2; i < n; i++) {
            point2D top = hull.pop();
            while (point2D.ccw(hull.peek(), top, a[i]) <= 0) {
                top = hull.pop();
            }
            hull.push(top);
            hull.push(a[i]);
        }
        assert isConvex();
    }
    public Iterable<point2D> hull() {
        Stack<point2D> s = new Stack<point2D>();
        for (point2D p : hull) s.push(p);
        return s;
    }
    private boolean isConvex() {
        int n = hull.size();
        if (n <= 2) return true;
        point2D[] points = new point2D[n];
        int k = 0;
        for (point2D p : hull()) {
            points[k++] = p;
        }
        for (int i = 0; i < n; i++) {
            if (point2D.ccw(points[i], points[(i+1) % n], points[(i+2) % n]) <= 0) {
                return false;
            }
        }
        return true;
    }
}
