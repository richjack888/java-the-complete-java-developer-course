public class Node extends ListItem {
    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return getRightLink();
    }

    @Override
    ListItem setNext(ListItem rightLink) {
        return setRightLink(rightLink);
    }

    @Override
    ListItem previous() {
        return getLeftLink();
    }

    @Override
    ListItem setPrevious(ListItem leftLink) {
        return setLeftLink(leftLink);
    }

    /**
     * if compare result is same, return 0
     * https://www.runoob.com/java/java-string-compareto.html
     */
    @Override
    int compareTo(ListItem item) {
        if (item != null) {
            return ((String) getValue()).compareTo((String) item.getValue());
        }
        return -1;
    }
}
