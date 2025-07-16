import java.util.ArrayList;

/**
 * The King class extends the Piece class and represents a king in the game of
 * chess.
 */
public class King extends Piece {
	/**
	 * Constructs a new King with the given color.
	 *
	 * @param color the color of the king
	 */
	public King(Color color) {
		super(color);
	}

	/**
	 * Returns the algebraic name of the king, which is "K".
	 *
	 * @return the algebraic name of the king
	 */
	@Override
	public String algebraicName() {
		return "K";
	}

	/**
	 * Returns an array of the squares that the king can move to from the given
	 * square. The king can move to any adjacent square.
	 *
	 * @param square the square that the king is currently on
	 * @return an array of the squares that the king can move to
	 */
	@Override
	public Square[] movesFrom(Square square) {

		ArrayList<Square> attackedSquares = new ArrayList<>();

		char row = square.getRow();
		char col = square.getCol();

		int[] rowOffsets = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] colOffsets = { -1, 0, 1, -1, 1, -1, 0, 1 };

		for (int i = 0; i < 8; i++) {

			char newRow = (char) (row + rowOffsets[i]);
			char newCol = (char) (col + colOffsets[i]);

			if (newCol >= 'a' && newCol <= 'h' && newRow >= '1' && newRow <= '8') {
				try {
					Square zaza = new Square(newCol, newRow);
					attackedSquares.add(zaza);
				} catch (InvalidSquareException e) {
					e.printStackTrace();
				}
			}
		}

		return attackedSquares.toArray(new Square[0]);
	}
}
