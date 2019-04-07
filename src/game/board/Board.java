package game.board;

import game.board.cell.Cell;
import game.board.cell.product.*;

public class Board {

    // 2d array of Cells = 15x15 board
    // mapped Cells[y]][x]
    public Cell[][] Cells = new Cell[15][15];
    private Product[] product = new Product[6];
    public String[][] mapConfig =
            {
                //0   1   2   3   4   5   6   7    8   9  10  11  12  13  14
                {"_", "_", "_", "_", "_", "_"
                , "_", "d","_", "_", "_", "_", "_", "_", "_"}  //0
                ,{"_", "_", "_", "d","l","l","l","l","l","l","l","l", "_", "_", "_"}  //1
                , {"_", "d", "l", "l", "_", "_", "_", "_", "_", "_", "_", "ud", "l", "l", "_"}  //2
                , {"_", "d", "_", "u", "_", "_", "_", "_", "_", "_", "_", "d", "_", "u", "_"}  //3
                , {"_", "d", "_", "u", "l", "l", "l", "dl", "l", "l", "l", "l", "_", "u", "_"}  //4
                , {"_", "d", "_", "_", "_", "_", "_", "d", "_", "_", "_", "_", "_", "u", "_"}  //5
                , {"_", "d", "_", "_", "_", "_", "_", "d", "_", "_", "_", "_", "_", "u", "_"}  //6
                , {"r", "d", "l", "l", "dl", "l", "l", "l", "l", "l", "_", "_", "_", "u", "l"}  //7
                , {"_", "d", "_", "_", "d", "_", "_", "_", "_", "u", "_", "_", "_", "u", "_"}  //8
                , {"_", "d", "_", "_", "d", "_", "_", "_", "_", "ur", "r", "dr", "r", "u", "l"}  //9
                , {"_", "d", "_", "_", "d", "_", "_", "_", "_", "u", "_", "d", "_", "_", "u"}  //10
                , {"_", "r", "r", "r", "r", "r", "r", "r", "r", "u", "_", "d", "_", "_", "u"}  //11
                , {"_", "_", "_", "_", "_", "_", "_", "u", "_", "_", "_", "d", "_", "_", "u"}  //12
                , {"_", "_", "_", "_", "_", "_", "_", "u", "_", "_", "_", "r", "d", "_", "u"}  //13
                , {"_", "_", "_", "_", "_", "_", "_", "u", "_", "_", "_", "_", "r", "r", "u"}  //14
            };

    public void initialiseCells() 
    {
        for (int i = 0; i < Cells.length; i++)
        {
            for (int j = 0; j < Cells[i].length; j++)
            {
                Cells[i][j] = new Cell();
                Cells[i][j].setDirections(mapConfig[i][j]);
            }
        }
    }

    public void initialisePieces()
    {
     Mac mac = new Mac(7,0);
        OSX osx = new OSX(0, 7);
        SurfacePro surfacePro = new SurfacePro(14,7);
        Windows10 windows10 = new Windows10(7,14);

        Product[] data = {mac,osx,surfacePro,windows10};
        setProduct(data);
    }

    public boolean movePiece(Product product, char direction)
    {
        int currentPositionX = product.getPositionX();
        int currentPositionY = product.getPositionY();
        int newPositionY;
        int newPositionX;
        switch(direction) {
            case 'l':
                newPositionY = currentPositionY - 1;
                product.setPositionY(newPositionY);
                Cells[currentPositionX][currentPositionY].removeProduct(product);
                Cells[currentPositionX][newPositionY].addPiece(product);
                break;
            case 'r':
                newPositionY = currentPositionY + 1;
                product.setPositionY(newPositionY);
                Cells[currentPositionX][currentPositionY].removeProduct(product);
                Cells[currentPositionX][newPositionY].addPiece(product);
                break;
            case 'd':
                newPositionX = currentPositionX + 1;
                product.setPositionX(newPositionX);
                Cells[currentPositionX][currentPositionY].removeProduct(product);
                Cells[newPositionX][currentPositionY].addPiece(product);
                break;
            case 'u':
                newPositionX = currentPositionX - 1;
                product.setPositionX(newPositionX);
                Cells[currentPositionX][currentPositionY].removeProduct(product);
                Cells[newPositionX][currentPositionY].addPiece(product);
                break;
            default:
                return false;
        }
        return true;
    }

    public void setProduct(Product[] product) {
        this.product = product;
    }

    public Product[] getProduct() {
        return this.product;
    }




}