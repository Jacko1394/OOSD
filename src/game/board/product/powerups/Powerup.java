package game.board.product.powerups;

public class Powerup {
    private Boolean isActive;

    public void activate(){
        isActive = true;
    }

    public Boolean getActiveStatus() {
        return isActive;
    }
}
