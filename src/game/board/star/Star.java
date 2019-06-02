package game.board.star;

public abstract class Star
{
    private int positionX;
    private int positionY;
    private String type;
    private boolean alreadyCollected;

    protected Star(int positionX, int positionY, String type) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.type = type;
        this.alreadyCollected = false;
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

    public boolean isAlreadyCollected() {
        return alreadyCollected;
    }

    public void setAlreadyCollected(boolean alreadyCollected) {
        this.alreadyCollected = alreadyCollected;
    }
}