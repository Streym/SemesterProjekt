package dk.helleberg;
import java.util.Scanner;

public class Game {
    Scanner input = new Scanner(System.in);
    Room[][] rooms = new Room[64][64];
    Player player = new Player();

    private void initMap() {
        for (int i = 0; i < this.rooms.length; i++) {
            for (int j = 0; j < this.rooms[i].length; j++) {
                this.rooms[i][j] = new Room();
            }
        }

        for (int i = 0; i < this.rooms.length; i++) {
            for (int j = 0; j < this.rooms[i].length; j++) {
                if (rooms[i][j].assignItem(i)) {
                    rooms[i][j].assignItemType();
                }
            }
        }
    }

    public void initialize() {
        initMap();
    }


    public void render() {
        this.rooms[player.getPosY()][player.getPosX()].setPlayer(player); // Move to better place

        for (int i = 0; i < this.rooms.length; i++) {
            for (int j = 0; j < this.rooms[i].length; j++) {
                if (this.rooms[i][j].isHasPlayer()) {
                    System.out.print(this.player.getName());
                } else if (this.rooms[i][j].isHasItem()) {
                    System.out.print(this.rooms[i][j].getItem().getName());
                } else {
                    System.out.print("█");
                }
            }
            System.out.println("");
        }
    }

    public void moveScanner () {
        System.out.print("Enter direction: ");
        String moveDir = input.nextLine();
        System.out.print("Enter move amount: ");
        int moveAmount = input.nextInt();
        if (moveAmount <= player.getMoveSpeed()) {
            player.move(moveDir, moveAmount, rooms.length, rooms[0].length);
        } else {
            System.out.println("Så langt kan du ikke gå mester :/");
            moveScanner();
        }
    }

    public void run() {
        while (true) {
            render();
            moveScanner();
        }
    }
}
