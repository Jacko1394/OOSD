package game;

import game.board.Board;
import game.board.product.Product;
import game.board.BoardController;
import game.board.cell.Cell;

import java.util.Random;

public class Game {

    private String currentTeam;
    // teams can be fed in using stdin at a later stage for more than 2 players
    private String[] listOfTeams = {"Microsoft", "Apple"};
    private int numberOfTeams;
    private Board board = new Board();

    public void startGame()
    {
        numberOfTeams = listOfTeams.length;

        // randomly select a team to go first
        Random rand = new Random(); 
        currentTeam = listOfTeams[rand.nextInt(numberOfTeams - 1)];

        board.initialisePieces();
    }

    public String nextTeam()
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
        return team;
    }

    // returns whether the cell is a choice block or not
    public String getCellType(Product product)
    {
        Cell cell = board.getCell(product.getPositionX(), product.getPositionY());
        return cell.getCellType();
    }

    public boolean checkProductTeamIsCurrent(Product product)
    {
        if (product.getTeam().equalsIgnoreCase(this.currentTeam))
        {
            return true;
        }
        else
        {
            return false;
        }
    }



    public int getNumberOfTeams() 
    {
        return this.listOfTeams.length;
    }

    public String getCurrentTeam() 
    {
        return currentTeam;
    }

    public void setCurrentTeam(String currentTeam) 
    {
        this.currentTeam = currentTeam;
    }

    public String[] getListOfTeams() 
    {
        return listOfTeams;
    }

    public void setListOfTeams(String[] listOfTeams) 
    {
        this.listOfTeams = listOfTeams;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}