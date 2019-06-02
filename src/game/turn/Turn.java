package game.turn;

public class Turn {
    
    private Board board;

    // will check alternate first as it acts as current path.
    private Turn alternateTurn = null;
    private Turn nextTurn = null;
    private Turn previousTurn = null;

    public Turn(Board board)
    {
        this.board = board;
    }

    public Board getBoard()
    {
        return this.board;
    }

    public Turn getPreviousTurn() {
        return previousTurn;
    }

    public void setPreviousTurn(Turn previousTurn) {
        this.previousTurn = previousTurn;
    }

    public Turn getNextTurn() {
        return nextTurn;
    }

    public void setNextTurn(Turn nextTurn) {
        this.nextTurn = nextTurn;
    }

    public Turn getAlternateTurn() {
        return alternateTurn;
    }

    public void setAlternateTurn(Turn alternateTurn) {
        this.alternateTurn = alternateTurn;
    }

}