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
    private String currentState = "Player"; // Should become an enum

    
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
        ProductFactory appleProductFactory = new AppleFactory();
        ProductFactory microsoftProductFactory = new MicrosoftFactory();
        this.products.add(appleProductFactory.generateProduct("mac",7,0));
        this.products.add(appleProductFactory.generateProduct("osx",0,7));
        this.products.add(microsoftProductFactory.generateProduct("surfacepro",14,7));
        this.products.add(microsoftProductFactory.generateProduct("windows10",7,14));

        for ( Product x : this.products ) {
            this.cells[x.getPositionX()][x.getPositionY()].addProduct(x);
        }
        this.currentProduct = this.products.get(0);

    }

    public void movePiece(Product product, char direction)
    {
        int currentPositionX = product.getPositionX();
        int currentPositionY = product.getPositionY();
        int[] newPosition = nextPosition(currentPositionX,currentPositionY,direction);
        int xNew = newPosition[0];
        int yNew = newPosition[1];

        product.setPositionY(yNew);
        product.setPositionX(xNew);
        cells[currentPositionX][currentPositionY].removeProduct(product);
        cells[xNew][yNew].addProduct(product);
    }


    public void setChoiceState(Cell[][] paths) {
        for ( Cell[] cellrow : paths) {

            int[] endCellLocation = getPoint(cellrow[cellrow.length - 1]);
            cells[endCellLocation[0]][endCellLocation[1]].setCellColor(Cell.selectColor);

        }
        this.currentState = "Choice";
    }

    public void setPlayerState() {
        this.currentState = "Player";
        for ( Cell[] cellrow : cells){
            for ( Cell cell : cellrow) {
                cell.setCellColor(Cell.defaultColor);
            }
        }
    }

    public void movePiece(Product product, Cell toCell ) {
        cells[product.getPositionX()][product.getPositionY()].removeProduct(product);
        int[] cellLocation = getPoint(toCell);
        product.setPositionX(cellLocation[0]);
        product.setPositionY(cellLocation[1]);
        toCell.addProduct(product);
    }

    public int[] nextPosition(int x, int y, char direction) {
        int newPositionX = x;
        int newPositionY = y;
        switch(direction) {
            case 'l':
                newPositionY = y - 1;
                break;
            case 'r':
                newPositionY = y + 1;
                break;
            case 'd':
                newPositionX = x + 1;
                break;
            case 'u':
                newPositionX = x - 1;
                break;
        }
        int[] output = { newPositionX , newPositionY };
        return output;
    }

    public Cell[][] search(int x , int y , int distance) {

        ArrayList<Cell> pathsLong = searchBranch(x , y ,distance, new ArrayList<Cell>() );

        int pathsCount = pathsLong.size() % distance;
        Cell[][] paths =  new Cell[pathsCount][distance+1];

        for ( int i = 0; i < pathsLong.size(); i ++) {
            int section = i / (distance+1);
            int position = i - (section * (distance+1));
            Cell item = pathsLong.get(i);
            paths[section][position] = item;

        }
        return paths;
    }

    private ArrayList<Cell> searchBranch(int x , int y , int distance , ArrayList<Cell> path) {
        path.add(getCell(x,y));
        if( distance == 0 ){return path;}
        ArrayList<Cell> newPaths = new ArrayList<>();

        for (char direction : getDirections(x,y) ) {
            int[] nextCell = nextPosition(x,y,direction);
            newPaths.addAll(searchBranch(nextCell[0],nextCell[1],distance - 1,new ArrayList<>(path)));
        }
        return newPaths;
    }

    public char[] getDirections(int xCoordinate, int yCoordinate)
    {
        return cells[xCoordinate][yCoordinate].getDirections();
    }

    public Cell getCell(int x, int y)
    {
        return cells[x][y];
    }
    public int[] getPoint(Cell cell) {
        int[] output = { 0 , 0 };
        for (int i = 0; i < cells.length; i ++) {
            for (int j = 0; j < cells[i].length; j ++) {
                if (cells[i][j].equals(cell)) {
                    output[0] = i;
                    output[1] = j;

                }
            }
        }
        return output;
    }

    public Product getCurrentProduct() {  return this.currentProduct ;}

    public void setCurrentProduct(Product product) { this.currentProduct = product ;}

    public Cell getCurrentCell() { return this.currentCell ;}

    public void setCurrentCell(Cell cell) { this.currentCellItem = 0; this.currentCell = cell ;}

    public void updateCurrentCell(Cell cell) {
        if ( this.currentCellItem < cell.getProducts().size() - 1 ) {
            this.currentCellItem ++;
        } else {
            this.currentCellItem = 0;
        }
        // ? temporary
        this.currentCell = cell;

    }
    public int getCurrentCellItem(){ return this.currentCellItem; }

    public ArrayList<Product> getProducts()
    {
        return products;
    }
    
}