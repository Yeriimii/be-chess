package chess.board;

import static chess.common.Color.*;
import static chess.pieces.Piece.*;
import static chess.utils.StringUtils.*;
import static chess.pieces.CreateCommand.*;

import chess.common.Color;
import chess.pieces.Piece;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Board <T extends Piece> {
    private static final int INIT_PAWN_COUNT = 8;
    private static final String BLANK_PIECES = ".".repeat(INIT_PAWN_COUNT);
    private List<T> pieces = new ArrayList<>();

    public T findPawn(int index) {
        return pieces.get(index);
    }

    public void add(T piece) {
        pieces.add(piece);
    }

    public int pieceCount() {
        return pieces.size();
    }

    public void initialize() {
        initializePieces(BLACK);
        initializePieces(WHITE);
    }

    private void initializePieces(Color color) {
        if (color.equals(BLACK)) {
            createMajorPieces(color);
            createPawns(color);
        } else {
            createPawns(color);
            createMajorPieces(color);
        }
    }

    private void createMajorPieces(Color color) {
        pieces.add(createPiece(color, ALLOWED_ROOK_NAME));
        pieces.add(createPiece(color, ALLOWED_KNIGHT_NAME));
        pieces.add(createPiece(color, ALLOWED_BISHOP_NAME));

        if (color.equals(BLACK)) {
            pieces.add(createPiece(color, ALLOWED_QUEEN_NAME));
            pieces.add(createPiece(color, ALLOWED_KING_NAME));
        } else {
            pieces.add(createPiece(color, ALLOWED_KING_NAME));
            pieces.add(createPiece(color, ALLOWED_QUEEN_NAME));
        }

        pieces.add(createPiece(color, ALLOWED_BISHOP_NAME));
        pieces.add(createPiece(color, ALLOWED_KNIGHT_NAME));
        pieces.add(createPiece(color, ALLOWED_ROOK_NAME));
    }

    private void createPawns(Color color) {
        IntStream.range(0, INIT_PAWN_COUNT)
                .forEach(i -> pieces.add(createPiece(color, ALLOWED_PAWN_NAME)));
    }

    private T createPiece(Color color, String pieceName) {
        return (T) create(color, pieceName);
    }

    public String getWhitePawnsResult() {
        StringBuilder builder = new StringBuilder();

        pieces.stream()
                .filter(piece -> isPawnPiece(WHITE, piece))
                .forEach(piece -> builder.append(piece.getRepresentation()));

        return builder.toString();
    }
    public String getBlackPawnsResult() {
        StringBuilder builder = new StringBuilder();

        pieces.stream()
                .filter(piece -> isPawnPiece(BLACK, piece))
                .forEach(piece -> builder.append(piece.getRepresentation()));

        return builder.toString();
    }

    private boolean isPawnPiece(Color color, T piece) {
        return piece.getColor().equals(color) && piece.getName().equals(ALLOWED_PAWN_NAME);
    }

    public String getMajorPieceResultByColor(Color color) {
        StringBuilder builder = new StringBuilder();

        pieces.stream()
                .filter(piece -> isMajorPiece(color, piece))
                .forEach(piece -> builder.append(piece.getRepresentation()));

        return builder.toString();
    }

    private boolean isMajorPiece(Color color, T piece) {
        return piece.getColor().equals(color) && !piece.getName().equals(ALLOWED_PAWN_NAME);
    }

    public void print() {
        StringBuilder builder = new StringBuilder();

        builder.append(appendNewLine(getMajorPieceResultByColor(BLACK)));
        builder.append(appendNewLine(getBlackPawnsResult()));
        builder.append(appendNewLine(BLANK_PIECES));
        builder.append(appendNewLine(BLANK_PIECES));
        builder.append(appendNewLine(BLANK_PIECES));
        builder.append(appendNewLine(BLANK_PIECES));
        builder.append(appendNewLine(getWhitePawnsResult()));
        builder.append(appendNewLine(getMajorPieceResultByColor(WHITE)));

        System.out.println(builder);
    }

    public String showBoard() {
        StringBuilder builder = new StringBuilder();

        builder.append(appendNewLine(getMajorPieceResultByColor(BLACK)));
        builder.append(appendNewLine(getBlackPawnsResult()));
        builder.append(appendNewLine(BLANK_PIECES));
        builder.append(appendNewLine(BLANK_PIECES));
        builder.append(appendNewLine(BLANK_PIECES));
        builder.append(appendNewLine(BLANK_PIECES));
        builder.append(appendNewLine(getWhitePawnsResult()));
        builder.append(appendNewLine(getMajorPieceResultByColor(WHITE)));

        return builder.toString();
    }
}
