package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import knapsack.Item;
import knapsack.Solution;

public class File {
	Path fileInPath = Paths.get("src/fileIn.txt");
	Path fileOutPath = Paths.get("src/fileOut.txt");

	public List<Item> readFile() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fileInPath.toString()));

		String line = bufferedReader.readLine();
		int tam = Integer.parseInt(line);
		List<Item> items = new ArrayList<Item>(Integer.parseInt(line));
		while ((line = bufferedReader.readLine()) != null) {

			String lines[] = line.split(" ");
			items.add(new Item(lines[0], Integer.parseInt(lines[1]), Integer.parseInt(lines[2])));
			
			if (items.size() == tam)
				break;
		}

		bufferedReader.close();

		return items;
	}
	
	public int getLastLine() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fileInPath.toString()));

		List<String> lines = new ArrayList<String>();
		String line = bufferedReader.readLine();

		while ((line = bufferedReader.readLine()) != null) {
			lines.add(line);
		}

		bufferedReader.close();

		return Integer.parseInt(lines.get(lines.size() - 1));
	}
	
	public void writeFile(Solution solution) throws IOException {

		FileWriter file = new FileWriter(fileOutPath.toString(), false);

		PrintWriter printWriter = new PrintWriter(file);

		printWriter.println(solution.getItems().size());
		for(Item item : solution.getItems()) {
			printWriter.println(item.getLabel());
		}
		
		printWriter.close();

	}

}
