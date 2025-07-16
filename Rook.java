package hw4.chess;

import java.util.ArrayList;

/**
 * The Rook class extends the Piece class and represents a rook in the game of
 * chess.
 */
public class Rook extends Piece {
	/**
	 * Constructs a new Rook with the given color.
	 *
	 * @param color the color of the rook
	 */
	public Rook(Color color) {
		super(color);
	}

	/**
	 * Returns the algebraic name of the rook, which is "R".
	 *
	 * @return the algebraic name of the rook
	 */
	public String algebraicName() {
		return "R";
	}

	/**
	 * Returns an array of the squares that the rook can move to from the given
	 * square. The rook can move in any direction: horizontally or vertically.
	 *
	 * @param square the square that the rook is currently on
	 * @return an array of the squares that the rook can move to
	 */
	@Override
	public Square[] movesFrom(Square square) {

		ArrayList<Square> attackedSquares = new ArrayList<>();

		char row = square.getRow();
		char col = square.getCol();

		int[] rowOffsets = { -1, 1, 0, 0 };
		int[] colOffsets = { 0, 0, -1, 1 };

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
