package srpfacadelab;

import srpfacadelab.Facade;


public class RpgPlayer {
    private final IGameEngine gameEngine;
    private int health;
    private int maxHealth;
    private int armour;
    public Facade facade;

    public RpgPlayer(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
        this.facade = new Facade(gameEngine, this)
    }

    public void takeDamage(int damage) {
        if (damage < armour) {
            gameEngine.playSpecialEffect("parry");
        }

        int damageToDeal;

        if (facade.getCarryingCapacity() > (0.5 * inventory.MAX_CARRYING_CAPACITY)){
            damageToDeal = (int)(0.75 * damage) - armour;
        }
        else{
            damageToDeal = damage - armour;
        }

        health -= damageToDeal;

        gameEngine.playSpecialEffect("lots_of_gore");
    }

    // Get/Sets
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getArmour() {
        return armour;
    }

    private void setArmour(int armour) {
        this.armour = armour;
    }

    public int getCarryingCapacity() {
        return facade.getCarryingCapacity();
    }


    // Stat Tracker
    public void calculateStats() {
        setArmour(facade.calculateStats());
    }

    // Inventory
    public void useItem(Item item) {
        facade.useItem(item);
    }
    public boolean pickUpItem(Item item) {
        return facade.pickUpItem(item);
    }
}
