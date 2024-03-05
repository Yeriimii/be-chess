package chess;

import chess.board.Board;
import chess.pieces.Piece;
import java.util.Scanner;

public class ChessSimulator {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final Board<Piece> BOARD = new Board<>();

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        BOARD.initialize();
        while (true) {
            String command = inputCommand();
            if (command.equals("start")) {
                BOARD.print();
            }
            if (command.equals("end")) {
                break;
            }
        }
    }

    public static String inputCommand() {
        System.out.println("명령어를 입력해주세요. [start] / [end]");
        return INPUT.nextLine();
    }
}
