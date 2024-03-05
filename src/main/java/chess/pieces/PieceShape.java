package chess.pieces;

import static chess.pieces.Piece.*;

import chess.common.Color;
import java.util.Arrays;

public enum PieceShape {
    PAWN_WHITE("♙", ALLOWED_PAWN_NAME, Color.WHITE),
    PAWN_BLACK("♟", ALLOWED_PAWN_NAME, Color.BLACK),
    KNIGHT_WHITE("♘", ALLOWED_KNIGHT_NAME, Color.WHITE),
    KNIGHT_BLACK("♞", ALLOWED_KNIGHT_NAME, Color.BLACK),
    BISHOP_WHITE("♗", ALLOWED_BISHOP_NAME, Color.WHITE),
    BISHOP_BLACK("♝", ALLOWED_BISHOP_NAME, Color.BLACK),
    ROOK_WHITE("♖", ALLOWED_ROOK_NAME, Color.WHITE),
    ROOK_BLACK("♜", ALLOWED_ROOK_NAME, Color.BLACK),
    QUEEN_WHITE("♕", ALLOWED_QUEEN_NAME, Color.WHITE),
    QUEEN_BLACK("♛", ALLOWED_QUEEN_NAME, Color.BLACK),
    KING_WHITE("♔", ALLOWED_KING_NAME, Color.WHITE),
    KING_BLACK("♚", ALLOWED_KING_NAME, Color.BLACK),
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
