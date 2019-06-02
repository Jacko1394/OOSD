package game;

import com.google.java.contract.Requires;
import game.board.Board;
import game.board.cell.Cell;
import game.board.product.Product;
import game.turn.Turn;
import game.turn.TurnTree;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    private Team currentTeam;
    private Team apple  = new Team("Apple", false);
    private Team microsoft = new Team("Microsoft", false);
    private Team[] listOfTeams = {apple, microsoft};
    private Turn currentTurn;
    private TurnTree tt = new TurnTree();

    public Board getBoard() {
        return currentTurn.getBoard();
    }

    public void nextTurn()
    {
        this.currentTurn = tt.nextTurn(currentTurn.getBoard());
    }

    public void previousTurn()
    {
        this.currentTurn = tt.previousTurn();
    }

    public void goToTurn(int tNumber)
    {
        this.currentTurn = tt.goToTurn(tNumber);
    }

    public void startGame()
    {
        Board board = new Board();
        tt.initialiseTree(board);

        // used to assign each product to it's appropriate team.
        ArrayList<Product> products = board.getProducts();
        for(Product product : products)
        {
            if (product.getProductTeam().getTeamID().equalsIgnoreCase("Apple"))
            {
                apple.addProduct(product);
            }
            else if (product.getProductTeam().getTeamID().equalsIgnoreCase("Microsoft"))
            {
                microsoft.addProduct(product);
            }
        }

        // randomly select a team to go first
        Random rand = new Random(); 
        currentTeam = listOfTeams[rand.nextInt(getNumberOfTeams() - 1)];

        board.initialisePieces();
        nextTurn();
    }

    public void endTurn()
    {
        nextTurn();
        currentTeam = nextTeam();
    }

    public Team nextTeam()
    {
        // assume next player is the first player in array, as we compare all but last player
        var team = listOfTeams[0];

        for (int i = 0; i < listOfTeams.length - 1; i++)
        {
            if (listOfTeams[i].equals(currentTeam))
            {
                team = listOfTeams[i + 1];
            }
        }
        // getting the next Team updates currentTeam
        currentTeam = team;
        return currentTeam;
    }

    // returns whether the cell is a choice block or not
    @Requires("product != null")
    public String getCellType(Product product)
    {
        Cell cell = getBoard().getCell(product.getPositionX(), product.getPositionY());
        return cell.getCellType();
    }

    public boolean checkProductTeamIsCurrent(Product product)
    {
        return product.getProductTeam() == this.currentTeam;
    }

    public int getNumberOfTeams() 
    {
        return this.listOfTeams.length;
    }

    public Team getCurrentTeam()
    {
        return currentTeam;
    }

    public Team[] getListOfTeams()
    {
        return listOfTeams;
    }

    public void setListOfTeams(Team[] listOfTeams)
    {
        this.listOfTeams = listOfTeams;
    }

}
