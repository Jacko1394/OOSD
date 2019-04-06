package game.board;

import game.board.cell.Cell;

public class Board {

    // 2d array of Cells = 15x15 board
    // mapped Cells[y]][x]
    public static Cell Cells[][] = new Cell[15][15];

    public Board() {
       

        
    }

    public void initBoard() {
         // Apple Team
         /*Cells[0][0].setProduct(new Mac());
         Cells[0][1].setProduct(new OSX());
         Cells[0][2].setProduct(new Terminal());
         
 
         // Microsoft Team
         Cells[12][12].setProduct(new Windows10());
         Cells[12][12].setProduct(new SurfacePro());
         Cells[12][12].setProduct(new Powershell());*/
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
        // initialise all Cells as null
        for (int i = 0; i < Cells.length - 1; i++)
        {
            for (int j = 0; j < Cells[j].length - 1; j++)
            {
                Cells[i][j] = new Cell();
            }
        }
    }

    public void mapDirection()
    {
        try {

            Cells[0][3].setDirections("d");
            Cells[0][4].setDirections("l");
            Cells[0][5].setDirections("l");
            Cells[0][6].setDirections("l");
            Cells[0][7].setDirections("l");
            Cells[0][8].setDirections("l");
            Cells[0][9].setDirections("l");
            Cells[0][10].setDirections("l");
            Cells[0][11].setDirections("l");

            Cells[1][3].setDirections("d");
            Cells[1][11].setDirections("u,d");

            Cells[2][1].setDirections("d");
            Cells[2][2].setDirections("l");
            Cells[2][3].setDirections("l");
            Cells[2][11].setDirections("u,d");
            Cells[2][12].setDirections("l");
            Cells[2][13].setDirections("l");

            Cells[3][1].setDirections("d");
            Cells[3][3].setDirections("u");
            Cells[3][11].setDirections("d");
            Cells[3][13].setDirections("u");

            Cells[4][1].setDirections("d");
            Cells[4][3].setDirections("u");
            Cells[4][4].setDirections("l");
            Cells[4][5].setDirections("l");
            Cells[4][6].setDirections("l");
            Cells[4][7].setDirections("l,d");
            Cells[4][8].setDirections("l");
            Cells[4][9].setDirections("l");
            Cells[4][10].setDirections("l");
            Cells[4][11].setDirections("l");

            Cells[5][1].setDirections("d");
            Cells[5][7].setDirections("d");
            Cells[5][13].setDirections("u");

            Cells[6][1].setDirections("d");
            Cells[6][7].setDirections("d");
            Cells[6][13].setDirections("u");

            Cells[7][0].setDirections("r");
            Cells[7][1].setDirections("d");
            Cells[7][2].setDirections("l");
            Cells[7][3].setDirections("l");
            Cells[7][4].setDirections("l,d");
            Cells[7][5].setDirections("l");
            Cells[7][6].setDirections("l");
            Cells[7][7].setDirections("l");
            Cells[7][8].setDirections("l");
            Cells[7][9].setDirections("l");
            Cells[7][13].setDirections("u");
            Cells[7][14].setDirections("l");

            Cells[8][1].setDirections("d");
            Cells[8][4].setDirections("d");
            Cells[8][9].setDirections("u");
            Cells[8][13].setDirections("u");

            Cells[9][1].setDirections("d");
            Cells[9][4].setDirections("d");
            Cells[9][9].setDirections("u,r");
            Cells[9][10].setDirections("r");
            Cells[9][11].setDirections("r");
            Cells[9][12].setDirections("r");
            Cells[9][13].setDirections("r");
            Cells[9][14].setDirections("l");

            Cells[10][1].setDirections("d");
            Cells[10][4].setDirections("d");
            Cells[10][9].setDirections("u");
            Cells[10][11].setDirections("d");
            Cells[10][14].setDirections("u");

            Cells[11][1].setDirections("r,d");
            Cells[11][2].setDirections("r");
            Cells[11][3].setDirections("r");
            Cells[11][4].setDirections("r");
            Cells[11][5].setDirections("r");
            Cells[11][6].setDirections("r");
            Cells[11][7].setDirections("r");
            Cells[11][8].setDirections("r");
            Cells[11][9].setDirections("u");
            Cells[11][11].setDirections("d");
            Cells[11][14].setDirections("u");

            Cells[12][7].setDirections("u");
            Cells[12][11].setDirections("d");
            Cells[12][14].setDirections("u");

            Cells[13][7].setDirections("u");
            Cells[13][11].setDirections("r");
            Cells[13][12].setDirections("d");
            Cells[13][14].setDirections("u");

            Cells[14][7].setDirections("u");
            Cells[14][12].setDirections("r");
            Cells[14][13].setDirections("r");
            Cells[14][14].setDirections("u");

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}