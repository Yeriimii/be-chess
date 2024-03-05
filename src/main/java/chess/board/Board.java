package chess.board;

import static chess.utils.StringUtils.*;

import chess.common.Color;
import chess.pieces.Pawn;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;

public class Board <T extends Pawn> {
    private static final int INIT_PAWN_COUNT = 8;
    private final BiConsumer<Color, Color> PIECE_CONSUMER = (color1, color2) -> {
        this.pieces.add((T) new Pawn(color1));
        this.pieces.add((T) new Pawn(color2));
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
                    PIECE_CONSUMER.accept(Color.WHITE, Color.BLACK);
                });
    }

    public String getWhitePawnsResult() {
        StringBuilder builder = new StringBuilder();

        pieces.stream()
                .filter(piece -> piece.getColor().equals(Color.WHITE))
                .forEach(piece -> builder.append(piece.getRepresentation()));

        return builder.toString();
    }
    public String getBlackPawnsResult() {
        StringBuilder builder = new StringBuilder();

        pieces.stream()
                .filter(piece -> piece.getColor().equals(Color.BLACK))
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
