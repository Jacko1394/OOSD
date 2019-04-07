package game.board.cell.product;


public class Mac extends AppleProducts {

    public static int[] dice = {1,2,3,4,5,6};


    public Mac(int positionX, int positionY) {
        super(dice, positionX, positionY);
    }


}