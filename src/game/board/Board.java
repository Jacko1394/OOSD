package game.board;

import game.board.cell.Cell;
import game.board.cell.product.*;

public class Board {

    // 2d array of Cells = 15x15 board
    // mapped Cells[y]][x]
    public Cell[][] Cells = new Cell[15][15];
//    private Product[] product = new Product[6];
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

    public Board()
    {
        for (int i = 0; i < Cells.length; i++)
        {
            for (int j = 0; j < Cells[i].length; j++)
            {
                Cells[i][j] = new Cell();
                Cells[i][j].setDirections(mapConfig[i][j]);
            }
        }
        initialisePieces();
    }

    private void initialisePieces()
    {
        ProductFactory productFactory = new ProductFactory();

        Product mac = productFactory.getProduct("mac",7,0);
        Product osx = productFactory.getProduct("osx",0,7);

        Product surfacePro = productFactory.getProduct("surfacepro",14,7);
        Product windows10 = productFactory.getProduct("windows10",7,14);

        Cells[mac.getPositionX()][mac.getPositionY()].addProduct(mac);
        Cells[osx.getPositionX()][osx.getPositionY()].addProduct(osx);
        Cells[surfacePro.getPositionX()][surfacePro.getPositionY()].addProduct(surfacePro);
        Cells[windows10.getPositionX()][windows10.getPositionY()].addProduct(windows10);

    }

    public boolean movePiece(Product product, char direction)
    {
        int currentPositionX = product.getPositionX();
        int currentPositionY = product.getPositionY();
        int newPositionY = currentPositionY;
        int newPositionX = currentPositionX;

        switch(direction) {
            case 'l':
                newPositionY = currentPositionY - 1;
                break;
            case 'r':
                newPositionY = currentPositionY + 1;
                break;
            case 'd':
                newPositionX = currentPositionX + 1;
                break;
            case 'u':
                newPositionX = currentPositionX - 1;
                break;
            default:
                return false;
        }
        product.setPositionY(newPositionY);
        product.setPositionX(newPositionX);
        Cells[currentPositionX][currentPositionY].removeProduct(product);
        Cells[newPositionX][newPositionY].addProduct(product);
        return true;
    }

//    public void setProduct(Product[] product) {
//        this.product = product;
//    }
//
//    public Product[] getProduct() {
//        return this.product;
//    }
    
}