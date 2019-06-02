package game;

import com.google.java.contract.Requires;
import game.board.Board;
import game.board.cell.Cell;
import game.board.product.Product;

import java.util.ArrayList;

public class Facade
{
    Game game = new Game();
    Board board = new Board();

    public Board getBoard() {
        return game.getBoard();
    }

    public void nextTurn()
    {
        game.nextTurn();
    }

    public void previousTurn()
    {
        game.previousTurn();
    }

    public void goToTurn(int tNumber)
    {
        game.goToTurn(tNumber);
    }

    public void startGame()
    {
        game.startGame();
    }

    public void endTurn()
    {
        game.endTurn();
    }

    public Team nextTeam()
    {
        return game.nextTeam();
    }

    // returns whether the cell is a choice block or not
    @Requires("product != null")
    public String getCellType(Product product)
    {
        return game.getCellType(product);
    }

    public boolean checkProductTeamIsCurrent(Product product)
    {
        return game.checkProductTeamIsCurrent(product);
    }

    public int getNumberOfTeams() 
    {
        return game.getNumberOfTeams();
    }

    public Team getCurrentTeam()
    {
        return game.getCurrentTeam();
    }

    public Team[] getListOfTeams()
    {
        return game.getListOfTeams();
    }

    public void setListOfTeams(Team[] listOfTeams)
    {
        game.setListOfTeams(listOfTeams);
    }




    public void initialisePieces()
    {
        board.initialisePieces();
    }

    public void movePiece(Product product, char direction)
    {
        board.movePiece(product, direction);
    }


    public void setChoiceState(Cell[][] paths) {
        board.setChoiceState(paths);
    }

    public void setPlayerState() {
        board.setPlayerState();
    }

    public void movePiece(Product product, Cell toCell ) {
        board.movePiece(product, toCell);
    }

    public int[] nextPosition(int x, int y, char direction) {
        return board.nextPosition(x, y, direction);
    }

    public Cell[][] search(int x , int y , int distance) {

        return board.search(x,y,distance);
    }

    private ArrayList<Cell> searchBranch(int x , int y , int distance , ArrayList<Cell> path) {
        return board.searchBranch(x,y,distance,path);
    }

    public char[] getDirections(int xCoordinate, int yCoordinate)
    {
        return board.getDirections(xCoordinate, yCoordinate);
    }

    public Cell getCell(int x, int y)
    {
        return cells[x][y];
    }
    public int[] getPoint(Cell cell) {
        return getPoint(cell);
    }

    public Product getCurrentProduct() 
    {  
        return board.getCurrentProduct();
    }

    public void setCurrentProduct(Product product) 
    { 
        board.setCurrentProduct(product);;
    }

    public Cell getCurrentCell() 
    { 
        return board.getCurrentCell();
    }

    public void setCurrentCell(Cell cell) 
    { 
        board.setCurrentCell(cell);
    }

    public void updateCurrentCell(Cell cell) {
        board.updateCurrentCell(cell);
    }
    
    public int getCurrentCellItem()
    { 
        return board.getCurrentCellItem() 
    }

    public ArrayList<Product> getProducts()
    {
        return board.getProducts();
    }

}