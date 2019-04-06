package game.board;

import game.board.cell.Cell;
import game.board.cell.product.*;

public class Board {

    // 2d array of cells = 15x15 board
    // mapped cells[y]][x]
    private Cell cells[][] = new Cell[15][15];
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

    public boolean movePiece(Cell[][] startPoint, char direction) 
    {
        return false;
    }

    public void initialiseCells() 
    {
        // initialise all cells as null
        for (int i = 0; i < cells.length; i++)
        {
            for (int j = 0; i < cells[i].length; j++)
            {
                cells[i][j] = new Cell();
            }
        }
    }

    public void mapDirection()
    {
        cells[0][3].setDirections("d");
        cells[0][4].setDirections("l");
        cells[0][5].setDirections("l");
        cells[0][6].setDirections("l");
        cells[0][7].setDirections("l");
        cells[0][8].setDirections("l");
        cells[0][9].setDirections("l");
        cells[0][10].setDirections("l");
        cells[0][11].setDirections("l");

        cells[1][3].setDirections("d");
        cells[1][11].setDirections("u,d");

        cells[2][1].setDirections("d");
        cells[2][2].setDirections("l");
        cells[2][3].setDirections("l");
        cells[2][11].setDirections("u,d");
        cells[2][12].setDirections("l");
        cells[2][13].setDirections("l");

        cells[3][1].setDirections("d");
        cells[3][3].setDirections("u");
        cells[3][11].setDirections("d");
        cells[3][13].setDirections("u");

        cells[4][1].setDirections("d");
        cells[4][3].setDirections("u");
        cells[4][4].setDirections("l");
        cells[4][5].setDirections("l");
        cells[4][6].setDirections("l");
        cells[4][7].setDirections("l,d");
        cells[4][8].setDirections("l");
        cells[4][9].setDirections("l");
        cells[4][10].setDirections("l");
        cells[4][11].setDirections("l");

        cells[5][1].setDirections("d");
        cells[5][7].setDirections("d");
        cells[5][13].setDirections("u");

        cells[6][1].setDirections("d");
        cells[6][7].setDirections("d");
        cells[6][13].setDirections("u");

        cells[7][0].setDirections("r");
        cells[7][1].setDirections("d");
        cells[7][2].setDirections("l");
        cells[7][3].setDirections("l");
        cells[7][4].setDirections("l,d");
        cells[7][5].setDirections("l");
        cells[7][6].setDirections("l");
        cells[7][7].setDirections("l");
        cells[7][8].setDirections("l");
        cells[7][9].setDirections("l");
        cells[7][13].setDirections("u");
        cells[7][14].setDirections("l");

        cells[8][1].setDirections("d");
        cells[8][4].setDirections("d");
        cells[8][9].setDirections("u");
        cells[8][13].setDirections("u");

        cells[9][1].setDirections("d");
        cells[9][4].setDirections("d");
        cells[9][9].setDirections("u,r");
        cells[9][10].setDirections("r");
        cells[9][11].setDirections("r");
        cells[9][12].setDirections("r");
        cells[9][13].setDirections("r");
        cells[9][14].setDirections("l");

        cells[10][1].setDirections("d");
        cells[10][4].setDirections("d");
        cells[10][9].setDirections("u");
        cells[10][11].setDirections("d");
        cells[10][14].setDirections("u");

        cells[11][1].setDirections("r,d");
        cells[11][2].setDirections("r");
        cells[11][3].setDirections("r");
        cells[11][4].setDirections("r");
        cells[11][5].setDirections("r");
        cells[11][6].setDirections("r");
        cells[11][7].setDirections("r");
        cells[11][8].setDirections("r");
        cells[11][9].setDirections("u");
        cells[11][11].setDirections("d");
        cells[11][14].setDirections("u");

        cells[12][7].setDirections("u");
        cells[12][11].setDirections("d");
        cells[12][14].setDirections("u");

        cells[13][7].setDirections("u");
        cells[13][11].setDirections("r");
        cells[13][12].setDirections("d");
        cells[13][14].setDirections("u");

        cells[14][7].setDirections("u");
        cells[14][12].setDirections("r");
        cells[14][13].setDirections("r");
        cells[14][14].setDirections("u");
}

public void initialiseCells() 
    {
        // initialise all cells as null
        for (int i = 0; i < cells.length; i++)
        {
            for (int j = 0; i < cells[i].length; j++)
            {
                cells[i][j] = new Cell();
            }
        }
    }    

}