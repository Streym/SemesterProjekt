package dk.helleberg;

public class Player {
    private int posX, posY;
    private String name;
    private int healthPoints;
    private int airPoints;
    private int moveSpeed;
    private Inventory inventory;

    public Player() {
        this.posX = 0;
        this.posY = 0;
        this.name = "▣";
        this.healthPoints = 100;
        this.airPoints = 50;
        this.moveSpeed = 1;
        this.inventory = new Inventory();
    }

    public void move(String dir, int moveAmount, int mapYLimit, int mapXLimit) {
        if (dir == "up") {
            setPosY(this.posY - moveAmount);
        } else if (dir == "left" && this.posX != 0) {
            setPosX(this.posX - moveAmount);
        } else if (dir == "down" && this.posY != mapYLimit) {
            setPosY(this.posY + moveAmount);
        } else if (dir == "right" && this.posY != mapXLimit) {
            setPosY(this.posY + moveAmount);
        }
    }

    public void takeItem(Room room) {

    }

    private void addToInventory(Item item) {

    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosY() {
        return posY;
    }

    public String getName() {
        return name;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }
}
