package game;

import game.board.Board;
import java.util.Random;

public class Game {

    private int numberOfTeams;
    private String currentTeam;
    // teams can be fed in using stdin at a later stage for more than 2 players
    private String listOfTeams[] = {"Microsoft", "Apple"};
    private Board board;

    public void startGame()
    {
        this.numberOfTeams = listOfTeams.length;
        System.out.println("17");
        // randomly select a team to go first
        Random rand = new Random(); 
        this.currentTeam = this.listOfTeams[rand.nextInt(this.numberOfTeams - 1)];
        System.out.println("21");
        this.board = new Board();
        this.board.initialiseCells();
        System.out.println("24");
        this.board.mapDirection();
        System.out.println("26");
    }

    public String nextPlayer()
    {
        // assume next player is the first player in array, as we compare all but last player
        String nextPlayer = listOfTeams[0];

        for (int i = 0; i < listOfTeams.length - 1; i++)
        {
            if (listOfTeams[i].equals(currentTeam))
            {
                nextPlayer = listOfTeams[i + 1];
            }
        }

        return nextPlayer;
    }

    public int getNumberOfTeams() 
    {
        return numberOfTeams;
    }

    public void setNumberOfTeams(int numberOfTeams) 
    {
        this.numberOfTeams = numberOfTeams;
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
}