package game;

import game.board.*;
import java.util.Random;

public class Game {

    private int numberOfTeams;
    private String currentTeam;
    private String listOfTeams[] = {"Microsoft", "Apple"};

    public void startGame()
    {
        // randomly select a team to go first
        Random rand = new Random(); 
        currentTeam = listOfTeams[rand.nextInt(numberOfTeams - 1)];

        Board board = new Board();
        board.initialiseCells();

    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public String getCurrentTeam() {
        return currentTeam;
    }

    public void setCurrentTeam(String currentTeam) {
        this.currentTeam = currentTeam;
    }

    public String[] getListOfTeams() {
        return listOfTeams;
    }

    public void setListOfTeams(String[] listOfTeams) {
        this.listOfTeams = listOfTeams;
    }

}