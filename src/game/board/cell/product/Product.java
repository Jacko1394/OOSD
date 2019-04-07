package game.board.cell.product;

import java.util.Random;

// base class:
public abstract class Product {
    
    public abstract int[] dice;

    public int[] getDice(){
        return this.dice;
    }

    public int rollDice() {
        int[] dice = this.getDice();
        Random rand = new Random(); 
        int rolled = dice[rand.nextInt(dice.length - 1)];
        return rolled;
    }
    
}