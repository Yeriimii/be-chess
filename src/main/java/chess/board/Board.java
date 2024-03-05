package chess.board;

import static chess.common.Color.*;
import static chess.pieces.Piece.*;
import static chess.utils.StringUtils.*;

import chess.pieces.Piece;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Board <T extends Piece> {
    private static final int INIT_PAWN_COUNT = 8;
    private final Runnable PAWN_CREATOR = () -> {
        this.pieces.add((T) createWhitePawn());
        this.pieces.add((T) createBlackPawn());
    };
    private static final String BLANK_PIECES = ".".repeat(INIT_PAWN_COUNT);
    private List<T> pieces = new ArrayList<>();

    public T findPawn(int index) {
        return pieces.get(index);
    }

    public void add(T piece) {
        pieces.add(piece);
    }

    public int size() {
        return pieces.size();
    }

    public void initialize() {
        IntStream.range(0, INIT_PAWN_COUNT)
                .forEach(i -> {
                    PAWN_CREATOR.run();
                });
    }

    public String getWhitePawnsResult() {
        StringBuilder builder = new StringBuilder();

        pieces.stream()
                .filter(piece -> piece.getColor().equals(WHITE))
                .forEach(piece -> builder.append(piece.getRepresentation()));

        return builder.toString();
    }
    public String getBlackPawnsResult() {
        StringBuilder builder = new StringBuilder();

        pieces.stream()
                .filter(piece -> piece.getColor().equals(BLACK))
                .forEach(piece -> builder.append(piece.getRepresentation()));

        return builder.toString();
    }

    public void print() {
        StringBuilder builder = new StringBuilder();

        builder.append(appendNewLine(BLANK_PIECES));
        builder.append(appendNewLine(getBlackPawnsResult()));
        builder.append(appendNewLine(BLANK_PIECES));
        builder.append(appendNewLine(BLANK_PIECES));
        builder.append(appendNewLine(BLANK_PIECES));
        builder.append(appendNewLine(BLANK_PIECES));
        builder.append(appendNewLine(getWhitePawnsResult()));
        builder.append(appendNewLine(BLANK_PIECES));

        System.out.println(builder);
    }
}
