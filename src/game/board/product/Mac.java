package game.board.product;

public class Mac extends AppleProducts {

    public static int[] dice = {2,2,2,2,8,10};
    

    public Mac(int positionX, int positionY) {
        super(dice, positionX, positionY);
        imgPath = "src/logos/mac.png";
        productID = "Mac";
    }

}