package game.board.cell.product;

public class Powershell extends MicrosoftProducts {

    public static int[] dice = {1,2,3,4,5,6};
    
    public Powershell(int positionX, int positionY) {
        super(dice, positionX, positionY);
    }

}