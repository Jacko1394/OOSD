package game.board.product;

public abstract class AppleProducts extends Product {

    private static final String TEAM_NAME = "Apple";

    public AppleProducts(int[] dice, int positionX, int positionY) {
        super(dice, TEAM_NAME, positionX, positionY);
    }

}