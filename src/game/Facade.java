package game;

public class Facade
{
    Game game = new Game();
    Board board = new Board();

    private String currentTeam;
    // teams can be fed in using stdin at a later stage for more than 2 players
    private String[] listOfTeams = {"Microsoft", "Apple"};

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

        // randomly select a team to go first
        Random rand = new Random(); 
        currentTeam = listOfTeams[rand.nextInt(getNumberOfTeams() - 1)];

        history.get(0).initialisePieces();
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
        return product.getTeam().equalsIgnoreCase(this.currentTeam);
    }

    public int getNumberOfTeams() 
    {
        return this.listOfTeams.length;
    }

    public String getCurrentTeam() 
    {
        return game.getCurrentTeam();
    }

    public String[] getListOfTeams() 
    {
        return game.getListOfTeams();
    }

    public void setListOfTeams(String[] listOfTeams) 
    {
        game.setListOfTeams(listOfTeams);
    }

}