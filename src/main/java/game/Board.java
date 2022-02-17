package game;

import launchPattern.UnContexte;
import servPattern.IContext;
import servPattern.ServeurTCP;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board implements IBoard{
    final int size;
    Cell[][] myBoard;

    public Board(int size) {

        if (size <= 0)
            throw new InvalidParameterException("C'est quoi ça une taille négative de plateau?");
        this.size = size;

        generateBoard();
    }



    public void generateBoard() {
        Fleet fleet = new Fleet();
        for (int i =0; i < 5; i++) {
            Boat boat = new Boat(i+1,i,size/5);// destiné à être demandé proprement au joueur concerné
            fleet.add(boat);
        }


        myBoard = new Cell[size][size];
        List<Cell> cells = new ArrayList<Cell>(size * size);

        for (int row = 0; row < myBoard.length; row++) {
            for (int col = 0; col < myBoard.length; col++) {
                Cell cell = new Cell();
                cell.setState(Cell.CellState.CLEAR);
                myBoard[row][col] = cell;
                cells.add(cell);
            }
        }

        for (Boat boat: fleet) {
            int x = boat.getx();
            int y = boat.gety();
            for (int j = 0; j < boat.size; j++) {
                if (boat.direction) {
                    Cell cell = myBoard[y + j][x];
                    cell.setState(Cell.CellState.SHIP);
                }
                else {
                    Cell cell = myBoard[y][x + j];
                    cell.setState(Cell.CellState.SHIP);
                }

            }
        }

    }


    public boolean shoot(int x, int y) {
        Cell shootedCell = myBoard[x][y];
        switch (shootedCell.getState()) {
            case CLEAR:
            case SHOOTED_WATER:
                shootedCell.setState(Cell.CellState.SHOOTED_WATER);
                return false;
            case SHIP:
            case SHOOTED_SHIP:
                shootedCell.setState(Cell.CellState.SHOOTED_SHIP);
                return true;
            default:
                throw new InvalidParameterException("Aucun CellState correspondant");
        }
    }

    public String print() {
        String echiquier = "";
        echiquier += "  X ";
        for (int i = 0; i < myBoard.length; i++) {
            echiquier += "  " + String.valueOf(i);
        }
//        System.out.println(echiquier);
        echiquier += "\n";
        echiquier +="Y  ";
        for (int i = 0; i < myBoard.length; i++) {
            echiquier +="---";
        }
        echiquier += "\n";

        for (int row = 0; row < myBoard.length; row++) {
            for (int col = 0; col < myBoard[row].length; col++) {
                if (col == 0) echiquier += String.valueOf(row) + " | ";
                Cell cell = myBoard[row][col];
                echiquier += "  " + cell.getState().getRepresentation();
//                echiquier += "\n";
            }
            echiquier += "\n";
        }
        return echiquier;
//        display(myBoard);
    }

    private void display(Cell[][] board) {

        System.out.print("  X ");
        for (int i = 0; i < board.length; i++) {
            System.out.print("  " + i);
        }
        System.out.println();
        System.out.print("Y  ");
        for (int i = 0; i < board.length; i++) {
            System.out.print("---");
        }
        System.out.println();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (col == 0) System.out.print(row + " | ");
                Cell cell = board[row][col];
                System.out.print("  " + cell.getState().getRepresentation());
        }
        System.out.println();
    }
    }


}
