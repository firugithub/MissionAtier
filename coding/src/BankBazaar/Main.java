package BankBazaar;

/* package workspace; // don't place package name! */

import java.util.Scanner;
import java.util.Stack;

/* Name of the class has to be "Main" only if the class is public. */
public class Main {
	public static void main(String[] args) throws java.lang.Exception {

		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < testCase; i++) {
			String str[] = sc.nextLine().split(",");
			int n = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[0]);
			char[][] matrix = new char[m][n];
			for (int j = 0; j < n; j++) {
				String mArr[] = sc.nextLine().split(",");
				for (int k = 0; k < mArr.length; k++) {
					matrix[k][j] = mArr[k].charAt(0);
				}
			}
			Main sp = new Main(matrix);

			Position[] path = sp.getPathDFS();
			if (path != null) {
				System.out.println(path.length);
			} else {
				System.out.println("-1");
			}
		}

	}

	private static class Position {
		public int x;
		public int y;
		public Position predecessor;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Position(int x, int y, Position predecessor) {
			this(x, y);
			this.predecessor = predecessor;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Position other = (Position) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "[" + x + "," + y + "]";
		}
	}

	private char[][] matrix;

	private Position[] shortestPath;

	private Stack<Position> path;

	private Position start;

	public Main(char[][] matrix) {
		this.matrix = matrix;
	}

	public Position[] getPathDFS() {
		findStart();
		path = new Stack<Position>();
		shortestPath = null;

		if (start != null) {
			next(start);
		}

		return shortestPath;
	}

	private void next(Position position) {
		stepForward(position);

		if (shortestPath == null || path.size() < shortestPath.length) {
			if (!endFound(position)) {
				Position nextPosition = new Position(position.x + 1, position.y);
				if (isVisitable(nextPosition)) {
					next(nextPosition);
				}

				nextPosition = new Position(position.x, position.y + 1);
				if (isVisitable(nextPosition)) {
					next(nextPosition);
				}

				nextPosition = new Position(position.x - 1, position.y);
				if (isVisitable(nextPosition)) {
					next(nextPosition);
				}

				nextPosition = new Position(position.x, position.y - 1);
				if (isVisitable(nextPosition)) {
					next(nextPosition);
				}
			} else {
				shortestPath = path.toArray(new Position[0]);
			}
		}

		stepBack();
	}

	private boolean isVisitable(Position position) {
		return position.y >= 0 && position.x >= 0 && position.y < matrix.length
				&& position.x < matrix[position.y].length
				&& (matrix[position.y][position.x] == '.' || endFound(position));
	}

	private boolean endFound(Position position) {
		return matrix[position.y][position.x] == 'C';
	}

	private void stepForward(Position position) {
		path.push(position);
		if (matrix[position.y][position.x] == '.') {
			matrix[position.y][position.x] = 'D';
		}
	}

	private void stepBack() {
		Position position = path.pop();
		if (matrix[position.y][position.x] == 'D') {
			matrix[position.y][position.x] = '.';
		}
	}

	private void visit(Position position) {
		if (matrix[position.y][position.x] == '.') {
			matrix[position.y][position.x] = 'D';
		}
	}

	private void findStart() {
		if (start != null) {
			return;
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 'B') {
					start = new Position(j, i);
				}
			}
		}
	}

	private void cleanUp() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 'D') {
					matrix[i][j] = '.';
				}
			}
		}
	}
}