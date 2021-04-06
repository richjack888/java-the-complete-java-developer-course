public class MainMyLinkedList {
    public static void main(String[] args) {

//        MyLinkedList list = new MyLinkedList(null);
//        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
//        String[] data = stringData.split(" ");
//        for (String s : data) {
//            list.addItem(new Node(s));
//        }
//        list.traverse(list.getRoot());


//        MyLinkedList list = new MyLinkedList(null);
//        String stringData = "7 5 3 9 1 2 8 0 4 6";
//        String[] data = stringData.split(" ");
//        for (String s : data) {
//            list.addItem(new Node(s));
//        }
//        list.removeItem(new Node("3"));
//        list.removeItem(new Node("2"));
//        list.removeItem(new Node("1"));
//        list.removeItem(new Node("0"));
//        list.traverse(list.getRoot());
//
//        list.removeItem(new Node("6"));
//        list.removeItem(new Node("4"));
//        list.removeItem(new Node("5"));
//        list.traverse(list.getRoot());
//
//        list.removeItem(new Node("7"));
//        list.removeItem(new Node("8"));
//        list.removeItem(new Node("9"));
//        list.traverse(list.getRoot());

        SearchTree list = new SearchTree(null);
        list.traverse(list.getRoot());
//        String stringData = "7 5 3 9 1 2 8 0 4 6";
        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
        String[] data = stringData.split(" ");
        for (String s : data) {
            list.addItem(new Node(s));
        }
        list.traverse(list.getRoot());

    }
}
