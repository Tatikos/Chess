package hw4.chess;

/**
 * The Square class represents a square on a chessboard.
 */
public class Square {
	private char row;
	private char col;
	private String name;

	/**
	 * Constructs a new Square with the given row and column.
	 *
	 * @param row the row of the square
	 * @param col the column of the square
	 * @throws InvalidSquareException if the row or column is not valid
	 */
	public Square(char col, char row) throws InvalidSquareException {
		if (!isValidSquare(col, Character.toLowerCase(row))) {
			throw new InvalidSquareException(String.valueOf(col) + Character.toLowerCase(row));
		}
		this.col = Character.toLowerCase(col);
		this.row = row;
	}

	/**
	 * Constructs a new Square with the given name.
	 *
	 * @param name the name of the square
	 * @throws InvalidSquareException if the name is not valid
	 */
	public Square(String name) throws InvalidSquareException {
		if (name.length() != 2 || !isValidSquare(name.charAt(1), Character.toLowerCase(name.charAt(0)))) {
			throw new InvalidSquareException(name);
		}
		this.col = Character.toLowerCase(name.charAt(0));
		this.row = name.charAt(1);
	}

	/**
	 * Checks if the given row and column form a valid square.
	 *
	 * @param row the row to check
	 * @param col the column to check
	 * @return true if the row and column form a valid square, false otherwise
	 */
	public boolean isValidSquare(char row, char col) {
		return col >= 'a' && col <= 'h' && row >= '1' && row <= '8';
	}

	/**
	 * Returns the row of the square.
	 *
	 * @return the row of the square
	 */
	public char getRow() {
		return row;
	}

	/**
	 * Returns the column of the square.
	 *
	 * @return the column of the square
	 */
	public char getCol() {
		return col;
	}

	/**
	 * Returns a string representation of the square.
	 *
	 * @return a string representation of the square
	 */
	public String toString() {
		return row + Character.toString(col);
	}

	/**
	 * Checks if this Square is equal to the given object.
	 *
	 * @param object the object to compare this Square to
	 * @return true if the object is a Square and its row and column are equal to
	 *         this Square's row and column, false otherwise
	 */
	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		Square square = (Square) object;
		return row == square.row && col == square.col;
	}
}
