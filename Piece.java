package hw4.chess;

/**
 * The Piece class is an abstract class that represents a piece in the game of
 * chess.
 */
public abstract class Piece {
	private Color colour;

	/**
	 * Constructs a new Piece with the given color.
	 *
	 * @param colour the color of the piece
	 */
	public Piece(Color colour) {
		this.colour = colour;
	}

	/**
	 * Returns the color of the piece.
	 *
	 * @return the color of the piece
	 */
	public Color getColor() {
		return this.colour;
	}

	/**
	 * Returns the FEN (Forsyth-Edwards Notation) name of the piece. The FEN name is
	 * the algebraic name in uppercase for white pieces and in lowercase for black
	 * pieces.
	 *
	 * @return the FEN name of the piece
	 */
	public String fenName() {
		return colour == Color.WHITE ? algebraicName().toUpperCase() : algebraicName().toLowerCase();
	}

	/**
	 * Returns the algebraic name of the piece. This method is abstract and must be
	 * implemented by subclasses.
	 *
	 * @return the algebraic name of the piece
	 */
	public abstract String algebraicName();

	/**
	 * Returns an array of the squares that the piece can move to from the given
	 * square. This method is abstract and must be implemented by subclasses.
	 *
	 * @param square the square that the piece is currently on
	 * @return an array of the squares that the piece can move to
	 */
	public abstract Square[] movesFrom(Square square);
}
