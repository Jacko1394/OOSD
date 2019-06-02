package game.board.star;

public class BlueStar extends Star
{

    public BlueStar(int positionX, int positionY) {
        super(positionX, positionY, "BLUE");
    }

    public int collectStar() {
        if (!this.isAlreadyCollected()){
            return 1;
        }
        return 0;
    }

    public Star shiftToBlue() {
        return this; // Do nothing as already blue
    }
}