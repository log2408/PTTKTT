package BieuThucHauTo;

import java.util.Scanner;
import java.util.Stack;

public class SimpleSuffix {
	public SimpleSuffix() {}
	public void tinhBT(String s) {
		Stack<Character> s1 = new Stack<Character>();
        Stack<Double> s2 = new Stack<Double>();
        s1.push('+');
        s2.push(0.0);
        s = s.replace(" ", "");
        System.out.println(s.toString());
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (Character.isDigit(tmp)) {
                s2.push((double) Character.getNumericValue(tmp));
            } else {
                if (tmp == 's') {
                	s1.push(tmp);
                    i = i + 3; 
                } else if (tmp == ')') {
                    while (!s1.isEmpty() && s1.peek() != '(' && s1.peek() != '*' && s1.peek() != '/') {
                        char t = s1.pop();
                        double v = 0;
                        if (t == 's') {
                            v = Math.sqrt(s2.pop());
                        } else {
                            double t1 = s2.pop();
                            double t2 = s2.pop();
                            if (t == '+') {
                                v = (!s1.isEmpty() && s1.peek() == '-') ? (t2 - t1) : (t2 + t1);
                            } else if (t == '-') {
                                v = (!s1.isEmpty() && s1.peek() == '-') ? (t2 + t1) : (t2 - t1);
                            }
                        }
                        s2.push(v);
                    }
                    s1.pop(); 
                    if(s1.peek() == 's') {
                    	double t = s2.pop();
                    	s2.push(Math.sqrt(t));
                    	s1.pop();
                    }
                    if (!s1.isEmpty() && (s1.peek() == '*' || s1.peek() == '/')) {
                        char t = s1.pop();
                        double t1 = s2.pop();
                        double t2 = s2.pop();
                        if (t == '*') {
                            s2.push(t1 * t2);
                        } else {
                            if (t1 != 0) {
                                s2.push(t2 / t1);
                            } else {
                                System.out.println("Lỗi: Chia cho 0");
                                return;
                            }
                        }
                    }
                } else {
                    s1.push(tmp);
                    if (tmp == '*' || tmp == '/') {
                        if (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                            char t = s1.pop();
                            double t1 = s2.pop();
                            double t2 = (double) Character.getNumericValue(s.charAt(i + 1));
                            if (tmp == '*') {
                                s2.push(t1 * t2);
                            } else {
                                if (t2 != 0) {
                                    s2.push(t1 / t2);
                                } else {
                                    System.out.println("Lỗi: Chia cho 0");
                                    return;
                                }
                            }
                            i = i + 1;
                        }
                    }
                }
            }
        }
        while (s2.size() > 1) {
            char t = s1.pop();
            double v = 0;
            if (t == 's') {
                v = Math.sqrt(s2.pop());
            } else {
                double t1 = s2.pop();
                double t2 = s2.pop();
                if (t == '+') {
                    v = (!s1.isEmpty() && s1.peek() == '-') ? (t2 - t1) : (t2 + t1);
                } else if (t == '-') {
                    v = (!s1.isEmpty() && s1.peek() == '-') ? (t2 + t1) : (t2 - t1);
                }
            }
            s2.push(v);
        }
        System.out.println(s2.peek());
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi s: ");
        String s = sc.nextLine();
        SimpleSuffix t = new SimpleSuffix();
        t.tinhBT(s);
	}
}
