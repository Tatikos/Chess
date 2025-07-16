package hw4.chess;

import java.util.ArrayList;
/**
 * The Knight class extends the Piece class and represents a knight in the game of chess.
 */
public class Knight extends Piece {
	/**
     * Constructs a new Knight with the given color.
     *
     * @param color the color of the knight
     */
	public Knight(Color color) {
        super(color);
    }
	/**
     * Returns the algebraic name of the knight, which is "N".
     *
     * @return the algebraic name of the knight
     */
    @Override
    public String algebraicName() {
        return "N";
    }
    /**
     * Returns an array of the squares that the knight can move to from the given square.
     * The knight can move to any square that is two squares horizontally and one square vertically away, or two squares vertically and one square horizontally away.
     *
     * @param square the square that the knight is currently on
     * @return an array of the squares that the knight can move to
     */
    @Override
    public Square[] movesFrom(Square square) {
        ArrayList<Square> attackedSquares = new ArrayList<>();
        char row = square.getRow();
        char col = square.getCol();
        int[] rowOffsets = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] colOffsets = {1, 2, 2, 1, -1, -2, -2, -1};
        for (int i = 0; i < 8; i++) {
            char newRow = (char) (row + rowOffsets[i]);
            char newCol = (char) (col + colOffsets[i]);
            if (newCol >= 'a' && newCol <= 'h' && newRow >= '1' && newRow <= '8') {
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
