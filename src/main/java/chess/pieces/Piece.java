package chess.pieces;

import chess.common.Color;

public class Pawn {
public class Piece {
    public static final String ALLOWED_PAWN_NAME = "pawn";
    public static final String ALLOWED_KNIGHT_NAME = "knight";
    private final Color color;
    private final String name;

    private Piece(Color color, String name) {
        this.color = color;
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String getRepresentation() {
        return PieceShape.find(this).getUnicode();
    }
}
