package hw4.chess;

import java.util.ArrayList;

/**
 * The Pawn class extends the Piece class and represents a pawn in the game of
 * chess.
 */
public class Pawn extends Piece {
	/**
	 * Constructs a new Pawn with the given color.
	 *
	 * @param color the color of the pawn
	 */
	public Pawn(Color color) {
		super(color);
	}

	/**
	 * Returns the algebraic name of the pawn, which is an empty string.
	 *
	 * @return the algebraic name of the pawn
	 */
	@Override
	public String algebraicName() {
		return "";
	}

	/**
	 * Returns an array of the squares that the pawn can move to from the given
	 * square. The pawn can move forward one square, or two squares if it is at its
	 * initial position.
	 *
	 * @param square the square that the pawn is currently on
	 * @return an array of the squares that the pawn can move to
	 */
	@Override
	public Square[] movesFrom(Square square) {
		ArrayList<Square> possibleMoves = new ArrayList<>();
		char row = square.getRow();
		char col = square.getCol();

		int rowOffset = (getColor() == Color.WHITE) ? 1 : -1;

		char oneSquareForwardRow = (char) (row + rowOffset);
		if (oneSquareForwardRow >= '1' && oneSquareForwardRow <= '8') {
			Square oneSquareForward = null;
			try {
				oneSquareForward = new Square(oneSquareForwardRow, col);
			} catch (InvalidSquareException e) {

				e.printStackTrace();
			}
			possibleMoves.add(oneSquareForward);

			if ((getColor() == Color.WHITE && row == '2') || (getColor() == Color.BLACK && row == '7')) {
				char twoSquaresForwardRow = (char) (oneSquareForwardRow + rowOffset);
				if (twoSquaresForwardRow >= '1' && twoSquaresForwardRow <= '8') {
					Square twoSquaresForward = null;
					try {
						twoSquaresForward = new Square(twoSquaresForwardRow, col);
					} catch (InvalidSquareException e) {

						e.printStackTrace();
					}
					possibleMoves.add(twoSquaresForward);
				}
			}
		}

		return possibleMoves.toArray(new Square[0]);
	}
}
