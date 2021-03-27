import java.util.Scanner;

public class MainButton {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btn = new Button("Print");

    public static void main(String[] args) {
//        class ClickListener implements Button.OnClickListener {
//
//            public ClickListener() {
//                System.out.println("I've been attached.");
//            }
//
//            @Override
//            public void onClick(String title) {
//                System.out.println(title + " was clicked.");
//            }
//        }

        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked.");
            }
        });
        listen();
    }

    private static void listen() {
        boolean quit = false;
        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    btn.onClick();
                    break;
            }
        }
    }

}
