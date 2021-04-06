public class MyLinkedList implements NodeList {
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            // This list was empty.
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0) {
                // newItem is greater than current item in Alphabetical order
                if (currentItem.next() != null) {
                    // move right if possible
                    currentItem = currentItem.next();
                } else {
                    // there is not next, just insert new item to right
                    currentItem.setNext(newItem);
                    // and set previous pointer
                    // if don't set previous, current item will reset to null;
                    newItem.setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0) {
                // newItem is smaller than current item in Alphabetical order
                // we already move to correct position, insert new item to left
                if (currentItem.previous() != null) {
                    // Need to reset previous and next pointer to correct item
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);
                } else {
                    // current item is root and had no previous item
                    newItem.setNext(this.root);
                    this.root.setPrevious(newItem);
                    // reset new item to root
                    this.root = newItem;
                }
                return true;

            } else {
                // find the same item in the list
                System.out.println(newItem.getValue() + " was already in the list");
                return false;
            }
        }

        System.out.println("Error, adding new item function.");
        return false;
    }

    @Override
    public boolean removeItem(ListItem delItem) {
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(delItem);
            if (comparison == 0) {
                // find the match item
                if (currentItem == this.root) {
                    // match item is root
                    this.root = currentItem.next();
                } else {
                    //check here
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                System.out.println(delItem.getValue() + " is deleting.");
                return true;
            } else if (comparison < 0) {
                // delete item is greater than current item in Alphabetical order
                currentItem = currentItem.next();
            } else {
                return false;
            }
        }
        System.out.println("Error, remove item function, no item in the list.");
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty.");
        } else {

            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }

        }
    }
}
