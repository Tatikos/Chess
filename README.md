# Chess Piece Movement Calculator

A Java implementation of chess pieces and their movement logic.

## Features

- **Piece Classes**: Bishop, King, Knight, Pawn, Queen, Rook
- **Square Representation**: Algebraic notation (e.g., "d4", "e5")
- **Movement Calculation**: Generate all possible moves for each piece from any square
- **Color Support**: White and black pieces with proper FEN notation

## Classes

- `Piece` - Abstract base class for all chess pieces
- `Square` - Represents a square on the chessboard
- `Color` - Enum for piece colors (WHITE, BLACK)
- `InvalidSquareException` - Exception for invalid square positions

## Usage

```java
Square square = new Square("d4");
Piece queen = new Queen(Color.WHITE);
Square[] moves = queen.movesFrom(square);
```

## Testing

Run `ChessTest.java` to see piece movements from the d4 square.

```
java ChessTest
```

## Notes

- Movement calculation ignores piece collisions (returns all theoretically possible moves)
- Uses standard chess algebraic notation
- Supports FEN notation for piece representation