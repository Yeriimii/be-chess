package chess.pieces;

import static chess.common.Color.*;
import static chess.pieces.Piece.*;
import static chess.pieces.CreateCommand.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CreateCommandTest {

    @DisplayName("허용된 기물의 이름으로 기물을 생성할 수 있다")
    @ParameterizedTest(name = "입력 이름: {0}")
    @ValueSource(strings = {
            ALLOWED_PAWN_NAME, ALLOWED_KNIGHT_NAME, ALLOWED_BISHOP_NAME,
            ALLOWED_ROOK_NAME, ALLOWED_QUEEN_NAME, ALLOWED_KING_NAME
    })
    void create_success(String allowedName) {
        // given & when
        Piece piece = create(BLACK, allowedName);
        String pieceName = piece.getName();

        // then
        assertThat(pieceName).isEqualTo(allowedName);
    }

    @DisplayName("허용되지 않은 이름으로는 기물을 생성할 수 없다")
    @ParameterizedTest(name = "입력 이름: {0}")
    @ValueSource(strings = {
            "폰", "나이트", "비숍",
            "룩", "퀸", "킹"
    })
    void create_fail(String disallowedName) {
        assertThatThrownBy(() -> create(BLACK, disallowedName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}