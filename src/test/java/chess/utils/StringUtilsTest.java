package chess.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringUtilsTest {

    @DisplayName("문자열에 개행 문자를 추가할 수 있다")
    @ParameterizedTest(name = "대상 문자열: {0}")
    @ValueSource(strings = {"abc", "가나다"})
    void appendNewLine(String target) {
        // given & when
        String result = StringUtils.appendNewLine(target);

        // then
        Assertions.assertAll(
                "StringUtils의 appendNewLine 기능을 사용하면 개행 문자가 추가된다",
                () -> assertThat(target).doesNotContain(StringUtils.NEWLINE),
                () -> assertThat(result).contains(StringUtils.NEWLINE)
        );
    }
}