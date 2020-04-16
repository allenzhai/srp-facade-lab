package srpfacadelab;

public class StatsCalculator {
    private RpgPlayer player;
    public StatsCalculator(RpgPlayer player){
        this.player = player;
    }

    public int calculateStats() {
        int armour = player.getArmour();
        for (Item i: player.inventory.getInventory()) {
            armour += i.getArmour();
        }
        return armour;
    }
}
