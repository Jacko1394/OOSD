package game.board.product;

public abstract class AppleProducts extends Product {


    private static final String APPLE = "Apple";
    protected String productID;


    public AppleProducts(int[] dice, int positionX, int positionY) {
        super(dice, APPLE, positionX, positionY);
    }

}