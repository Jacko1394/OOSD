package game.board.cell.product;

public class Powershell extends Product {

    public Powershell() {
        super();
    }

    @Override
    public int[] getDice(){
        return new int[] {0,1,2,3,4,5,6};
    }

}