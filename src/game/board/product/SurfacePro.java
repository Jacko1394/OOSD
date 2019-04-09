package game.board.product;

public class SurfacePro extends MicrosoftProducts {

    public static int[] dice = {3,3,5,5,5,8};
    
    public SurfacePro(int positionX, int positionY) {
        super(dice, positionX, positionY);
        imgPath = "src/logos/surface.png";
    }

}