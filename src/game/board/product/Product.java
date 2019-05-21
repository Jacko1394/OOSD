package game.board.product;

import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;
import game.Team;
import game.board.product.dice.Dice;

@Invariant("positionX >= 0 && positionY >= 0")
public abstract class Product {
    
    private Dice dice;
    private int positionX;
    private int positionY;
    protected String productID;
    protected Team productTeam;

    public String imgPath;

    @Requires("x >= 0 && y >= 0")
    public Product(int[] dice, String team, int positionX, int positionY)
    {
        this.dice = new Dice(dice, new StandardDice());
        this.productTeam = new Team(team, false);
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Dice getDice(){
        return this.dice;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    @Requires("position >= 0")
    public void setPositionX(int position) {
        this.positionX = position;
    }

    @Requires("position >= 0")
    public void setPositionY(int position) {
        this.positionY = position;
    }

    public String getID()
    {
        return productID;
    }

    public Team getProductTeam()
    {
        return productTeam;
    }

}