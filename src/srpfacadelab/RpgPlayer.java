package srpfacadelab;

import srpfacadelab.Inventory;


public class RpgPlayer {
    //public static final int MAX_CARRYING_CAPACITY = 1000;
    private final IGameEngine gameEngine;
    private int health;
    private int maxHealth;
    private int armour;
    public Inventory inventory;
    public StatsCalculator statsCalculator;

    public RpgPlayer(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
        this.inventory = new Inventory(gameEngine, this);
        this.statsCalculator = new StatsCalculator(this);
    }

    public void takeDamage(int damage) {
        if (damage < armour) {
            gameEngine.playSpecialEffect("parry");
        }

        int damageToDeal;

        if (inventory.getCarryingCapacity() > (0.5 * inventory.MAX_CARRYING_CAPACITY)){
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
        return inventory.getCarryingCapacity();
    }


    // Stat Tracker
    public void calculateStats() {
        setArmour(statsCalculator.calculateStats());
    }

    // Inventory
    public void useItem(Item item) {
        inventory.useItem(item);
    }
    public boolean pickUpItem(Item item) {
        return inventory.pickUpItem(item);
    }
}
