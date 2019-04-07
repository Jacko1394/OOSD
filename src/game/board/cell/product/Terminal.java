package game.board.cell.product;

public class Terminal extends Product {

    public Terminal() {
        super();
    }

    @Override
    public int[] getDice(){
        return new int[] {0,1,2,3,4,5,6};
    }

}