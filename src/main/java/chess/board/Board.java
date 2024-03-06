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
            createMajor(color);
            createPawns(color);
        } else {
            createPawns(color);
            createMajor(color);
        }
    }

    private void createMajor(Color color) {
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

    public String getPawnsResultByColor(Color color) {
        StringBuilder builder = new StringBuilder();

        pieces.stream()
                .filter(piece -> isPawn(piece) && isSameColor(color, piece))
                .forEach(piece -> builder.append(piece.getRepresentation()));

        return builder.toString();
    }

    public String getMajorResultByColor(Color color) {
        StringBuilder builder = new StringBuilder();

        pieces.stream()
                .filter(piece -> !isPawn(piece) && isSameColor(color, piece))
                .forEach(piece -> builder.append(piece.getRepresentation()));

        return builder.toString();
    }

    private boolean isPawn(T piece) {
        return piece.getName().equals(ALLOWED_PAWN_NAME);
    }

    private boolean isSameColor(Color color, T piece) {
        return piece.getColor().equals(color);
    }

    public void print() {
        StringBuilder builder = new StringBuilder();

        getBoardRepresentation(builder);

        System.out.println(builder);
    }

    public String showBoard() {
        StringBuilder builder = new StringBuilder();

        getBoardRepresentation(builder);

        return builder.toString();
    }

    private void getBoardRepresentation(StringBuilder builder) {
        builder.append(appendNewLine(getMajorResultByColor(BLACK)));
        builder.append(appendNewLine(getPawnsResultByColor(BLACK)));
        IntStream.range(0, 4).forEach(i -> builder.append(appendNewLine(BLANK_PIECES)));
        builder.append(appendNewLine(getPawnsResultByColor(WHITE)));
        builder.append(appendNewLine(getMajorResultByColor(WHITE)));
    }
}
