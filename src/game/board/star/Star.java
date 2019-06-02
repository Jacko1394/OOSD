package game.board.star;

public abstract class Star
{
    private int positionX;
    private int positionY;
    private String type;

    protected Star(int positionX, int positionY, String type) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.type = type;
    }

    public abstract int collectStar();
    public abstract Star shiftToBlue();

    public int getPositionY() {
        return positionY;
    }


    public String getType() {
        return type;
    }

    public int getPositionX() {
        return positionX;
    }
}