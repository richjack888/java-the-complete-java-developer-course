public class Door {
    private String material;
    private boolean open;
    private boolean locked;

    public Door(String material) {
        this.material = material;
        this.open = true;
        this.locked = false;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen() {
        this.open = true;
    }

    public void setClose() {
        this.open = false;
    }

    public void lock_door() {
        if (this.open) {
            System.out.println("Can't do. The door is open now, please close the door to lock.");
        } else {
            this.locked = true;
            System.out.println("The door is lock now.");
        }
    }

    public void unlock_door() {
        if (this.locked) {
            this.locked = false;
            System.out.println("The door is unlock now.");
        } else {
            System.out.println("Can't do. The door doesn't lock.");
        }

    }

}
