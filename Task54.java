// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

package Seminar;

public class Task54 {
    
	int max = 8;
	int array[] = new int[max];
	static int count = 0;

	public static void main(String[] args) {
		Task54 queens = new Task54();
		queens.check(0);

	}

	private void check(int n) {
		if (n == max) {
			printBoard();
			count++;
			System.out.println("--" + count + " решение " + "--");
			return;
		}
		for (int i = 0; i < max; i++) {
			array[n] = i;
			if (judge(n)) {
				check(n + 1);
			}
		}
	}

	private boolean judge(int n) {
		for (int i = 0; i < n; i++) {

			if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {

				return false;
			}
		}
		return true;
	}

	private void printBoard() {
		for (int y = 0; y < max; y++) {
			for (int x = 0; x < max; x++) {

				if (array[x] == y) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}

			}
			System.out.println();

		}

	}
}