package game.board.star;

import java.util.Random;

public class YellowStar extends Star
{

    public YellowStar(int positionX, int positionY) {
        super(positionX, positionY, "YELLOW");
    }

    public Star shiftToBlue() {
        Random rand = new Random();
        boolean val = rand.nextInt(4)==1; //25% Probability of blue star;
        if (val){
            if (this.getType() == "YELLOW"){
                return new BlueStar(this.getPositionX(),this.getPositionY());
            }
        }
        return this;
    }

    public int collectStar() {
            return 1;
    }



}