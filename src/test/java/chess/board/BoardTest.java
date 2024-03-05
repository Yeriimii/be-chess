package chess.board;

import static chess.pieces.Piece.*;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

import chess.pieces.Piece;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BoardTest {

    private Board<Piece> board;

    @BeforeEach
    void setUp() {
        board = new Board<>();
    }

    @DisplayName("체스판은 기물을 추가할 수 있다")
    @Test
    void create() {
        // given
        Piece white = createWhitePawn();

        // when
        board.add(white);

        // then
        assertEquals(1, board.size());
    }

    @DisplayName("체스판은 특정 기물의 위치를 알 수 있다")
    @Test
    void findPawn() {
        // given
        Piece white = createWhitePawn();
        Piece black = createBlackPawn();
        board.add(white);
        board.add(black);

        // when
        Piece firstFindPiece = board.findPawn(0);
        Piece secondFindPiece = board.findPawn(1);

        // then
        assertAll(
                () -> assertEquals(white, firstFindPiece),
                () -> assertEquals(black, secondFindPiece)
        );
    }

    @DisplayName("체스 기물(폰)이 아니면 체스판에 추가 할 수 없다")
    @ParameterizedTest(name = "체스판에 추가할 값 = {0}")
    @ValueSource(strings = {"1", "2", "3"})
    void add_compileError(String number) {
        assertThatCode(
                () -> {
                    Method addMethod = Board.class.getDeclaredMethod("add", Piece.class);
                    addMethod.setAccessible(true);
                    addMethod.invoke(board, Integer.parseInt(number));
                }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("흰색 폰 8개, 검정색 폰 8개로 초기화 할 수 있다")
    @Test
    void initialize() {
        // given & when
        board.initialize();

        // then
        assertEquals("♙♙♙♙♙♙♙♙", board.getWhitePawnsResult());
        assertEquals("♟♟♟♟♟♟♟♟", board.getBlackPawnsResult());
    }
}