package game.turn;

public class TurnTree {

    private Turn root;
    // used to avoid having to scale the tree to jump back to current turn each time.
    private Turn currentTurn;

    public void initialiseTree(Board currentBoard)
    {
        root = new Turn(currentBoard);
    }

    // moves to next turn and 
    public Turn nextTurn(Board board)
    {
        Turn tempTurn = currentTurn;
        currentTurn.setNextTurn(tempTurn);

        // set tempTurn to the next turn
        tempTurn = currentTurn.getNextTurn();
        // set the next turns previous turn to the current turn
        tempTurn.setPreviousTurn(currentTurn);
        // set the current turn to the next turn and return the next turn.
        this.currentTurn = tempTurn;
        return this.currentTurn;
    }

    public Turn previousTurn()
    {
        // previous turn will act as the left node in a binary tree, the tree will still never go down.
        return currentTurn.getPreviousTurn();
    }
    
    public Turn goToTurn(int tNumber)
    {
        Turn turnIterator = root;
        int count = 0;

        while (tNumber > count)
        {
            // always scale alternate turn first
            if (turnIterator.getAlternateTurn() != null)
            {
                // alternate turn counts as the same turn, but in an alternate universe.
                turnIterator = turnIterator.getAlternateTurn();
            }
            else
            {
                // if there's no alternate turn, just go to next turn and keep counting.
                turnIterator = turnIterator.getNextTurn();
                count++;
            }
        }
        Turn tempTurn = turnIterator;
        turnIterator.setAlternateTurn(tempTurn);
        turnIterator = tempTurn.getAlternateTurn();
        turnIterator.setNextTurn(null);
        turnIterator.setAlternateTurn(null);
        return turnIterator;
    }
}