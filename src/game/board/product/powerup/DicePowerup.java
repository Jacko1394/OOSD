package game.board.product.powerup;

public class DicePowerup implements Powerup {
    private boolean isActive;

    @Override
    public void activate() {
        isActive = true;
    }

    @Override
    public void deactivate() {
        isActive = false;
    }

    @Override
    public boolean getActiveStatus() {
        return isActive;
    }
}
