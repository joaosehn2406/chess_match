package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.Position;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

    public Program() {

        Scanner in = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch(null);
        UI.printBoard(chessMatch.getPieces());

        while (true) {
            try {
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(in);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(in);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            } catch (ChessException e) {
                System.out.println(e.getMessage());
                in.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                in.nextLine();
            }
        }

    }

    public static void main(String[] args) {
        new Program();
    }
}