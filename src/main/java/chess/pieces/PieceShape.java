package chess.pieces;

import static chess.pieces.Piece.*;

import chess.common.Color;
import java.util.Arrays;

public enum PieceShape {
    PAWN_WHITE("♙", Piece.class, Color.WHITE),
    PAWN_BLACK("♟", Piece.class, Color.BLACK),
    PAWN_WHITE("♙", ALLOWED_PAWN_NAME, Color.WHITE),
    PAWN_BLACK("♟", ALLOWED_PAWN_NAME, Color.BLACK),
    ;

    private final String unicode;
    private final String name;
    private final Color color;

    PieceShape(String unicode, String name, Color color) {
        this.unicode = unicode;
        this.name = name;
        this.color = color;
    }

    public String getUnicode() {
        return unicode;
    }

    public Color getColor() {
        return color;
    }

    public static PieceShape find(Piece targetPiece) {
        return Arrays.stream(PieceShape.values())
                .filter(piece -> isSameName(piece, targetPiece) && isSameColor(piece, targetPiece))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 찾을 수 없는 기물입니다."));
    }

    private static boolean isSameName(PieceShape piece, Piece pawn) {
        return piece.name.equals(pawn.getName());
    }

    private static boolean isSameColor(PieceShape piece, Piece pawn) {
        return piece.color.equals(pawn.getColor());
    }
}
