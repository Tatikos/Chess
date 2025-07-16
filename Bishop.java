package hw4.chess;

import java.util.ArrayList;

/**
 * The Bishop class extends the Piece class and represents a bishop in the game
 * of chess.
 */
public class Bishop extends Piece {
	/**
	 * Constructs a new Bishop with the given color.
	 *
	 * @param color the color of the bishop
	 */
	public Bishop(Color color) {
		super(color);
	}

	/**
	 * Returns the algebraic name of the bishop, which is "B".
	 *
	 * @return the algebraic name of the bishop
	 */
	@Override
	public String algebraicName() {
		return "B";
	}

	/**
	 * Returns an array of the squares that the bishop can move to from the given
	 * square. The bishop can move diagonally in any direction.
	 *
	 * @param square the square that the bishop is currently on
	 * @return an array of the squares that the bishop can move to
	 */
	@Override
	public Square[] movesFrom(Square square) {

		ArrayList<Square> attackedSquares = new ArrayList<>();

		char row = square.getRow();
		char col = square.getCol();

		int[] rowOffsets = { -1, -1, 1, 1 };
		int[] colOffsets = { -1, 1, -1, 1 };

		for (int i = 0; i < 4; i++) {

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
