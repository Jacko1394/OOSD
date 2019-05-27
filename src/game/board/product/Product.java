package game.board.product;

import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;
import game.Team;
import game.board.product.dice.DiceDecoratorFactory;
import game.board.product.dice.Rollable;
import game.board.product.dice.Dice;

@Invariant("positionX >= 0 && positionY >= 0")
public abstract class Product {
    
    private Rollable dice;
    private Rollable decoratedDice;
    private Boolean poweredUp = false;
    private Boolean powerBlocked = false;
    private int positionX;
    private int positionY;
    protected Team productTeam;

    public String imgPath;

    @Requires("x >= 0 && y >= 0")
    public Product(int[] dice, String team, int positionX, int positionY)
    {
        this.dice = new Dice(dice);
        this.decoratedDice = DiceDecoratorFactory.build(this.getProductID(),this.dice);
        this.productTeam = new Team(team, false);
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public String getProductID() {
        return "";
    }


    public Rollable getDice(){
        if(this.poweredUp && this.powerBlocked == false){
            this.powerBlocked = true;
            return this.decoratedDice;
        }else{
            return this.dice;
        }
    }

    public void powerUp() {
        this.poweredUp = true;
    }

    public void powerDown() {
        this.poweredUp = false;
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
        return this.getProductID();
    }

    public Team getProductTeam()
    {
        return productTeam;
    }

}