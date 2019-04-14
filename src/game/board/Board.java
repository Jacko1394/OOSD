package game.board;

import game.board.cell.Cell;
import game.board.product.*;

import java.util.ArrayList;

public class Board {

    // 2d array of Cells = 15x15 board
    public Cell[][] cells = new Cell[15][15];

    private ArrayList<Product> products = new ArrayList<>();
    private Product currentProduct;
    private Cell currentCell;
    private int currentCellItem = 0;
    
    // configuration of static board
    public String[][] mapConfig =
            {
                // 0    1    2    3    4    5    6    7   8    9   10   11   12   13   14
                 {"_", "_", "_", "_", "_", "_", "_", "d","_", "_", "_", "_", "_", "_", "_"}  //0
                ,{"_", "_", "_", "d", "l", "l", "l", "l", "l", "l", "l", "l", "_", "_", "_"}  //1
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
        for (int i = 0; i < cells.length; i++)
        {
            for (int j = 0; j < cells[i].length; j++)
            {
                cells[i][j] = new Cell();
                cells[i][j].setDirections(mapConfig[i][j]);
                if (cells[i][j].getDirections().length > 1)
                {
                    cells[i][j].setCellType("choice");
                }
                else
                {
                    cells[i][j].setCellType("event");
                }
            }
        }
        this.currentCell = this.cells[0][0];
    }

    public void initialisePieces()
    {
        ProductFactory productFactory = new ProductFactory();
        this.products.add(productFactory.generateProduct("mac",7,0));
        this.products.add(productFactory.generateProduct("osx",0,7));
        this.products.add(productFactory.generateProduct("surfacepro",14,7));
        this.products.add(productFactory.generateProduct("windows10",7,14));

        for ( Product x : this.products ) {
            this.cells[x.getPositionX()][x.getPositionY()].addProduct(x);
        }
        this.currentProduct = this.products.get(0);

    }


    public void movePiece(Product product, char direction, String currentTeam)
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
        }

        product.setPositionY(newPositionY);
        product.setPositionX(newPositionX);
        cells[currentPositionX][currentPositionY].removeProduct(product);
        cells[newPositionX][newPositionY].addProduct(product);
        
    }

    public char[] getDirections(int xCoordinate, int yCoordinate)
    {
        return cells[xCoordinate][yCoordinate].getDirections();
    }

    public Cell getCell(int x, int y)
    {
        return cells[x][y];
    }

    public Product getCurrentProduct() {  return this.currentProduct ;}

    public void setCurrentProduct(Product product) { this.currentProduct = product ;}

    public Cell getCurrentCell() { return this.currentCell ;}

    public void setCurrentCell(Cell cell) { this.currentCellItem = 0; this.currentCell = cell ;}

    public Cell[] getPossibleCells(Cell productCell,int distance) {
        // TODO search through paths and return possible cells that a person could move to
        // TODO these cells can then be colored blue and selected by the user
        return null;
    }
    public void updateCurrentCell(Cell cell) {
        if ( this.currentCellItem < cell.getProducts().size() - 1 ) {
            this.currentCellItem ++;
        } else {
            this.currentCellItem = 0;
        }
        // ?
        this.currentCell = cell;

    }
    public int getCurrentCellItem(){ return this.currentCellItem; }
    
}