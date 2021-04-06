public class SearchTree implements NodeList {

    private ListItem root;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            // the tree was empty
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = (currentItem.compareTo(newItem));
            if (comparison < 0) {
                // newItem is greater than current item in Alphabetical order
                if (currentItem.next() != null) {
                    // move to right if possible
                    currentItem = currentItem.next();
                } else {
                    // there's no node to the right, so add to the right
                    currentItem.setNext(newItem);
                    return true;
                }
            } else if (comparison > 0) {
                // newItem is smaller than current item in Alphabetical order
                if (currentItem.previous() != null) {
                    // move to left if possible
                    currentItem = currentItem.previous();
                } else {
                    // there's no node to the lett, so add to the lett
                    currentItem.setPrevious(newItem);
                    return true;
                }
            } else {
                // comparison == 0, new item already in the tree
                System.out.println(newItem.getValue() + " is already in tree.");
                return false;
            }
        }

        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        // tomorrow check
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                performRemoval(currentItem, parentItem);
                return true;
            }
        }

        return false;
    }

    private void performRemoval(ListItem currentItem, ListItem parentItem) {
        if (currentItem.next() == null) {
            if (parentItem.next() == currentItem) {
                parentItem.setNext(currentItem.previous());
            } else if (parentItem.previous() == currentItem) {
                parentItem.setPrevious(currentItem.previous());
            } else {
                this.root = currentItem.previous();
            }
        } else if (currentItem.previous() == null) {
            if (parentItem.next() == currentItem) {
                parentItem.setNext(currentItem.next());
            } else if (parentItem.previous() == currentItem) {
                parentItem.setPrevious(currentItem.next());
            } else {
                this.root = currentItem.next();
            }
        } else {
            ListItem current = currentItem.next();
            ListItem leftmostParent = currentItem;
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }
            currentItem.setValue(current.getValue());
            if (leftmostParent == currentItem) {
                currentItem.setNext(current.next());
            } else {
                leftmostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        // recursive method
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }

    }
}
