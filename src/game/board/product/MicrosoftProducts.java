package game.board.product;

public abstract class MicrosoftProducts extends Product {
    
    private static final String TEAM_NAME = "Microsoft";
    
    public MicrosoftProducts(int[] dice, int positionX, int positionY) {
        super(dice, TEAM_NAME, positionX, positionY);
    }

}