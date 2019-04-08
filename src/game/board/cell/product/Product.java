package game.board.cell.product;

import java.util.Random;

// base class:
public abstract class Product {
    
    private int[] dice;
    private String team;
    private int positionX;
    private int positionY;

    public Product(int[] dice, String team, int positionX, int positionY) {
        this.dice = dice;
        this.team = team;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int[] getDice(){
        return this.dice;
    }

    public String getTeam(){
        return this.team;
    }

    public int rollDice() {
        int[] dice = this.getDice();
        Random rand = new Random(); 
        int rolled = dice[rand.nextInt(dice.length - 1)];
        return rolled;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int position) {
        this.positionX = position;
    }

    public void setPositionY(int position) {
        this.positionY = position;
    }

}