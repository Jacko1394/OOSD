package game.board.star;

public class BlueStar extends Star
{

    public BlueStar(int positionX, int positionY) {
        super(positionX, positionY, "BLUE");
    }

    public int collectStar() {
            return 1;
    }

    public Star shiftToBlue() {
        return this; // Do nothing as already blue
    }
}