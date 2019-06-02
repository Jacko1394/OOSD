package game.board.star;

public class BlueStar extends Star implements StarState
{

    public BlueStar(int positionX, int positionY) {
        super(positionX, positionY, state);
    }

    @Override
    public int collectStar() {
            return 1;
    }
}