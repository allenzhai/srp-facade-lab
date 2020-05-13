package srpfacadelab;

import java.util.List;
import java.util.ArrayList;

import srpfacadelab.Inventory;
import srpfacadelab.StatsCalculator;

public class Facade {
    public Inventory inventory;
    public StatsCalculator statsCalculator;

    public Facade(IGameEngine gameEngine, RpgPlayer player){
        this.gameEngine = gameEngine;
        this.player = player;
        this.inventory = new Inventory(gameEngine, this);
        this.statsCalculator = new StatsCalculator(this);
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
