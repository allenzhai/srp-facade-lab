import srpfacadelab.IGameEngine;
import srpfacadelab.RpgPlayer;
import srpfacadelab.SimpleGameEngine;
import  srpfacadelab.Item;

public class Main {

    public static void main(String[] args) {
        //This is meant to be simple and just show how you could instantiate the structure

        IGameEngine game = new SimpleGameEngine();
        RpgPlayer player1 = new RpgPlayer(game);
        RpgPlayer player2 = new RpgPlayer(game);
        ((SimpleGameEngine) game).addPlayer(player1);
        ((SimpleGameEngine) game).addPlayer(player2);

        //Here you would create items
        Item shinyItem = new Item(1, "Pearl", 50, 50, 50, true, true);
        Item regularItem = new Item(2, "Brick", 50, 50, 50, false, false);
        Item stinkBomb = new Item(3, "Stink Bomb", 0, 0,30, false, false);
        //Here you would tell the history and make the game happen

        //You could make players pick up items
        player1.pickUpItem(shinyItem);
        player1.pickUpItem(stinkBomb);
        player2.pickUpItem(regularItem);
        //You could make players use items
        player1.useItem(stinkBomb);
        //etc.
        //You don't need to worry about it for the assignment
        //This is only to show how the 'external world' would instantiate the structure.
        //In the assignment, you're supposed to improve the design and not instantiate a game
    }
}
