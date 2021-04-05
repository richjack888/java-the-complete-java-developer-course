public abstract class ListItem {
    protected ListItem rightLink = null;
    protected ListItem leftLink = null;

    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next();

    abstract ListItem setNext(ListItem rightLink);

    abstract ListItem previous();

    abstract ListItem setPrevious(ListItem rightLink);

    abstract int compareTo(ListItem item);

    public ListItem getRightLink() {
        return rightLink;
    }

    public ListItem setRightLink(ListItem rightLink) {
        return this.rightLink = rightLink;
    }

    public ListItem getLeftLink() {
        return leftLink;
    }

    public ListItem setLeftLink(ListItem leftLink) {
        return this.leftLink = leftLink;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
