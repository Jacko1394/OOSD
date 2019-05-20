package game;

import game.board.Board;
import game.board.product.Product;
import game.board.BoardController;
import game.board.cell.Cell;
import com.google.java.contract.*; // cofoja

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private Team currentTeam;
    // teams can be fed in using stdin at a later stage for more than 2 players
    private Team apple  = new Team("apple", false);
    private Team microsoft = new Team("microsoft", false);
    private Team[] listOfTeams = {apple, microsoft};

    private ArrayList<Board> history = new ArrayList<>();

    public Board getBoard() {
        return history.get(history.size() - 1);
    }

    public ArrayList<Board> getHistory() {
        return history;
    }

    public void startGame()
    {
        Board board = new Board();
        history.add(board);

        // used to assign each product to it's appropriate team.
        ArrayList<Product> products = board.getProducts();
        for(Product product : products)
        {
            if (product.getProductTeam().getTeamID().equalsIgnoreCase("apple"))
            {
                apple.addProduct(product);
            }
            else if (product.getProductTeam().getTeamID().equalsIgnoreCase("microsoft"))
            {
                microsoft.addProduct(product);
            }
        }

        // randomly select a team to go first
        Random rand = new Random(); 
        currentTeam = listOfTeams[rand.nextInt(getNumberOfTeams() - 1)];

        history.get(0).initialisePieces();
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