package main;

import java.io.IOException;
import java.util.List;

import file.File;
import knapsack.Item;
import knapsack.Knapsack;
import knapsack.Solution;

public class Main {
	public static void main(String[] args) throws IOException {
		
		File file = new File();

		List<Item> items = file.readFile();
		int capacity = file.getLastLine();
		
		Item[] itemsArray = new Item[items.size()];
		
		for(int i = 0; i < items.size(); i++) {
			itemsArray[i] = items.get(i);
		}
		
		Knapsack knapsack = new Knapsack(itemsArray, capacity);
		
		Solution solution = knapsack.solve();
		
		file.writeFile(solution);
		
	}
}
