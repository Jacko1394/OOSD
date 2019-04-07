package game.board.cell.product;

public class Terminal extends AppleProducts {

    public static int[] dice = {1,2,3,4,5,6};

    public Terminal(int positionX, int positionY) {
        super(dice,positionX, positionY);
    }

}