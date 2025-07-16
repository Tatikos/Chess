package hw4.chess;

import java.util.ArrayList;

/**
 * The Queen class extends the Piece class and represents a queen in the game of
 * chess.
 */
public class Queen extends Piece {
	/**
	 * Constructs a new Queen with the given color.
	 *
	 * @param color the color of the queen
	 */
	public Queen(Color color) {
		super(color);
	}

	/**
	 * Returns the algebraic name of the queen, which is "Q".
	 *
	 * @return the algebraic name of the queen
	 */
	@Override
	public String algebraicName() {
		return "Q";
	}

	/**
	 * Returns an array of the squares that the queen can move to from the given
	 * square. The queen can move in any direction: horizontally, vertically, or
	 * diagonally.
	 *
	 * @param square the square that the queen is currently on
	 * @return an array of the squares that the queen can move to
	 */
	@Override
	public Square[] movesFrom(Square square) {

		ArrayList<Square> attackedSquares = new ArrayList<>();

		char row = square.getRow();
		char col = square.getCol();

		int[] rowOffsets = { -1, 1, 0, 0, -1, 1, -1, 1 };
		int[] colOffsets = { 0, 0, -1, 1, -1, -1, 1, 1 };

		for (int i = 0; i < 8; i++) {

			for (int step = 1;; step++) {

				char newRow = (char) (row + step * rowOffsets[i]);
				char newCol = (char) (col + step * colOffsets[i]);

				if (newCol < 'a' || newCol > 'h' || newRow < '1' || newRow > '8') {
					break;
				}

				try {
					Square zaza = new Square(newRow,newCol);
					attackedSquares.add(zaza);
				} catch (InvalidSquareException e) {
					e.printStackTrace();
				}
			}
		}

		return attackedSquares.toArray(new Square[0]);
	}
}
