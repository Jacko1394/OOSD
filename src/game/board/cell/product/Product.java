package game.board.cell.product;

import java.util.Random;

// base class:
public abstract class Product {
    
    public abstract int[] getDice();

    public int rollDice() {
        int[] dice = this.getDice();
        Random rand = new Random(); 
        int rolled = dice[rand.nextInt(dice.length - 1)];
        return rolled;
    }
    
}