package game.board.cell.product;

import game.board.cell.product.dice.Dice;

import java.util.Random;

// base class:
public abstract class Product {
    
    private Dice dice;
    private String team;
    private int positionX;
    private int positionY;

    public String imgPath;

    public Product(int[] dice, String team, int positionX, int positionY) {
        this.dice = new Dice(dice);
        this.team = team;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Dice getDice(){
        return this.dice;
    }

    public String getTeam(){
        return this.team;
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