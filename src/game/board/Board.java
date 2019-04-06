package game.board;

import game.board.cell.Cell;
import game.board.cell.product.*;

public class Board {

    // 2d array of cells = 12*12 board
    private Cell[][] Cells = new Cell[12][12];

    public Board() {
       

        
    }

    public void initBoard() {
         // Apple Team
         Cells[0][0].setProduct(new Mac());
         Cells[0][1].setProduct(new OSX());
         Cells[0][2].setProduct(new Terminal());
 
         // Microsoft Team
         Cells[12][12].setProduct(new Windows10());
         Cells[12][12].setProduct(new SurfacePro());
         Cells[12][12].setProduct(new Powershell());
    }

    public void movePiece() {

    }

    public void displayBoard() {

    }

    public void initialisePieces() {

    }

    public void initialiseCells() {

    }

}