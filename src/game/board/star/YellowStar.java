package game.board.star;

public class YellowStar extends Star implements StarState
{

    public YellowStar(int positionX, int positionY) {
        super(positionX, positionY, state);
    }

    @Override
    public int collectStar() {
            return 1;
    }



}