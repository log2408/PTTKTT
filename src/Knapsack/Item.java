package Knapsack;

public class Item {
	private int profit;
	private int weight;
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Item(int profit, int weight) {
		this.profit = profit;
		this.weight = weight;
	}
}
