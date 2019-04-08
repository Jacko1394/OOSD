package game.board.cell.product;

public class SurfacePro extends MicrosoftProducts {

    public static int[] dice = {1,2,3,4,5,6};
    
    public SurfacePro(int positionX, int positionY) {
        super(dice, positionX, positionY);
        imgPath = "src/logos/surface.png";
    }

}