package hw4.chess;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class ChessTest {
	public static void main(String[] args) throws InvalidSquareException {
		Square square = new Square("d4");

		Piece bishop = new Bishop(Color.WHITE);
		Piece king = new King(Color.BLACK);
		Piece knight = new Knight(Color.WHITE);
		Piece pawn = new Pawn(Color.BLACK);
		Piece queen = new Queen(Color.WHITE);
		Piece rook = new Rook(Color.BLACK);

		Piece[] pieces = { bishop, king, knight, pawn, queen, rook };

		for (Piece piece : pieces) {
			System.out.println("Piece: " + piece.getClass().getSimpleName());
			System.out.println("Starting position: " + square);
			System.out.println("Possible moves:");
			for (Square s : piece.movesFrom(square)) {
				System.out.println(s.toString());
			}
			System.out.println();
		}
	}
}
