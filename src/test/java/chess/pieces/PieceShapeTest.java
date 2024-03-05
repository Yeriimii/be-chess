package chess.pieces;

import static chess.pieces.Piece.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PieceShapeTest {

    @DisplayName("폰은 출력용 모양과 매핑될 수 있다")
    @Test
    void find_success() {
        // given
        Piece white = createWhitePawn();
        Piece black = createBlackPawn();

        // when
        PieceShape whiteShape = PieceShape.find(white);
        PieceShape blackShape = PieceShape.find(black);

        // then
        assertAll(
                "하얀색과 검정색 폰은 각각 출력용 문자를 갖는 PieceShape와 매핑된다",
                () -> assertThat(whiteShape.getColor()).isEqualTo(white.getColor()),
                () -> assertThat(blackShape.getColor()).isEqualTo(black.getColor()),
                () -> assertThat(whiteShape.getUnicode()).isEqualTo("♙"),
                () -> assertThat(blackShape.getUnicode()).isEqualTo("♟")
        );
    }
}