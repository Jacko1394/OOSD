package game.board.product;

public abstract class MicrosoftProducts extends Product {


    private static final String MICROSOFT = "Microsoft";
    
    public MicrosoftProducts(int[] dice, int positionX, int positionY) {
        super(dice, MICROSOFT, positionX, positionY);
    }

}