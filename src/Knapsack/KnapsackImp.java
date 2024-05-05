package Knapsack;

public class KnapsackImp {
	private int capacity;
	private Item[] item;
	private boolean[][] sol;
	public KnapsackImp(int cap, Item[] item) {
		this.capacity = cap;
		this.item = item;
	}
	public int maxProfit() {
		int n = item.length;
		int[][] tmp = new int[n + 1][this.capacity + 1];
		this.sol = new boolean[n + 1][this.capacity + 1];
		for(int i = 1; i <= this.capacity; i++) {
			tmp[0][i] = 0;
		}
		Item[] temp = new Item[n + 1];
		for(int i = 0; i < n; i++) {
			temp[i + 1] = item[i];
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= this.capacity; j++) {
				int t1 = tmp[i - 1][j];
				int t2 = Integer.MIN_VALUE;
				if(temp[i].getWeight() <= j) {
					t2 = temp[i].getProfit() + tmp[i - 1][j-temp[i].getWeight()];
				}
				tmp[i][j] = Math.max(t1, t2);
				sol[i][j] = t2>t1;
			}
		}
		return tmp[n][this.capacity];
	}
	public void inBag() {
		maxProfit();
		boolean[] taken = new boolean[item.length + 1];
		for(int i = item.length - 1, w = this.capacity; i >= 0; i--) {
			if(sol[i + 1][w]) {
				taken[i] = true;
				w = w - item[i].getWeight();
			} else {
				taken[i] = false;
			}
		}
		for(int i = 0; i < item.length; i++) {
			System.out.println((i + 1) + " " + item[i].getProfit() + " " + item[i].getWeight() + " " + taken[i]);
		}
	}
	public static void main(String[] args) {
		Item[] items = new Item[6];
		items[0] = new Item(874, 580);
		items[1] = new Item(620, 1616);
		items[2] = new Item(345, 1906);
		items[3] = new Item(369, 1942);
		items[4] = new Item(360, 50);
		items[5] = new Item(470, 294);
		KnapsackImp knapsack = new KnapsackImp(2000, items);
		knapsack.inBag();
	}
}
