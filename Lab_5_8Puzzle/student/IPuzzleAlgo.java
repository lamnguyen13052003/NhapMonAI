package puzzle_8.student;

import java.util.ArrayList;

public interface IPuzzleAlgo {
	static ArrayList<String> infoAlo = new ArrayList<String>();

	public Node execute(Puzzle model);

	public default void addInfoAlo(String name, int amount, long time){
		infoAlo.add("Thuật toán " + name + " sẽ duyệt: " + amount + " phần tử và tiêu tốn " + time + " ms để tìm ra kết quả");
	}
}
