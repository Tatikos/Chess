public class ChessTest {
	public static void main(String[] args) throws InvalidSquareException {
		System.out.println("Starting Chess Tests...\n");
		
		// Test Square creation and basic functionality
		testSquareCreation();
		
		// Test piece movements
		testPieceMovements();
		
		System.out.println("All tests completed!");
	}
	
	private static void testSquareCreation() throws InvalidSquareException {
		System.out.println("=== Testing Square Creation ===");
		
		Square square1 = new Square("d4");
		Square square2 = new Square('d', '4');
		
		assert square1.equals(square2) : "Squares created differently should be equal";
		assert square1.getCol() == 'd' : "Column should be 'd'";
		assert square1.getRow() == '4' : "Row should be '4'";
		
		System.out.println("Square creation tests passed!\n");
	}
	
	private static void testPieceMovements() throws InvalidSquareException {
		System.out.println("=== Testing Piece Movements ===");
		
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
			System.out.println("Color: " + piece.getColor());
			System.out.println("Algebraic Name: " + piece.algebraicName());
			System.out.println("FEN Name: " + piece.fenName());
			System.out.println("Starting position: " + square);
			
			Square[] moves = piece.movesFrom(square);
			System.out.println("Number of possible moves: " + moves.length);
			System.out.println("Possible moves:");
			
			for (Square s : moves) {
				System.out.println("  " + s.toString());
			}
			System.out.println();
		}
	}
}
