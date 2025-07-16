/**
 * The InvalidSquareException class extends the Exception class and represents
 * an exception that is thrown when an invalid square is encountered in the game
 * of chess.
 */
public class InvalidSquareException extends Exception {
	/**
	 * Constructs a new InvalidSquareException with the given square.
	 *
	 * @param square the square that caused the exception
	 */
	public InvalidSquareException(String square) {
		super("Invalid square " + square);
	}
}
