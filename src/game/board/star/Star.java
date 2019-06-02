package game.board.star;

import java.util.Random;

public class Star
{
    private int positionX;
    private int positionY;
    private String type;
    private StarState state;


    protected Star(int positionX, int positionY, StarState state) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.state = state;
        this.type = "YELLOW";
    }

    public Star shiftToBlue(){
        if (this.type == "YELLOW"){
            Random rand = new Random();
            boolean val = rand.nextInt(4)==1; //25% Probability of blue star;
            if (val){
                if (this.getType() == "YELLOW"){
                    Star star = new Star(this.getPositionX(),this.getPositionY(), state);
                    star.setType("BLUE");
                    return star;
                }
            }
        }
        return this;
    }

    public int collectStar(){
        return state.collectStar();
    }


    private void setType(String type) {
        this.type = type;
    }

    public int getPositionY() {
        return positionY;
    }


    public String getType() {
        return type;
    }

    public int getPositionX() {
        return positionX;
    }
}