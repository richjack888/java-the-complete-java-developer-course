import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class PlayListMain {
    public static void main(String[] args) {
        Album album1 = Album.createAlbum("Apple Day");
        album1.addSong("A", "1:11");
        album1.addSong("AA", "2:22");
        album1.addSong("AAA", "3:33");

        Album album2 = Album.createAlbum("Banana Day");
        album2.addSong("B", "1:11");
        album2.addSong("BB", "2:22");
        album2.addSong("BBB", "3:33");

        PlayList playList = PlayList.createPlayList("Emotion");
        playList.addAlbum(album1);
        playList.addAlbum(album2);
        playList.printAlbums(false);
        visit(playList);

    }

    private static void visit(PlayList playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        LinkedList<Album> albumList = playList.getPlayLists();
        ListIterator<Album> albumListIterator = albumList.listIterator();
        boolean changeDirection = false;

        if (albumList.isEmpty()) {
            System.out.println("None album in the play list");
            return;
        } else {
            System.out.println("Start to play album!\nWe are at the origin point now.");
            printMenu();
        }

        while (!quit) {
            System.out.print("\n" + "Enter number to action:");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Play list over!");
                    quit = true;
                    break;
                case 1:
                    if (changeDirection) {
                        if (albumListIterator.hasNext()) {
                            albumListIterator.next();
                        }
                        changeDirection = false;
                    }
                    if (albumListIterator.hasNext()) {
                        System.out.println("Playing Album No." + (albumListIterator.nextIndex() + 1));
                        albumListIterator.next().printSongs();


                    } else {
                        System.out.println("No more next Album!");
                        changeDirection = true;
                    }
                    break;
                case 2:
                    if (!changeDirection) {
                        if (albumListIterator.hasPrevious()) {
                            albumListIterator.previous();
                        }
                        changeDirection = true;
                    }
                    if (albumListIterator.hasPrevious()) {
                        System.out.println("Playing Album No." + (albumListIterator.previousIndex() + 1));
                        albumListIterator.previous().printSongs();
                    } else {
                        System.out.println("No more previous Album!");
                        changeDirection = false;
                    }
                    break;
                case 3:
                    if (!changeDirection) {
                        if (albumListIterator.hasPrevious()) {
                            System.out.println("Playing Album No." + (albumListIterator.previousIndex() + 1));
                            albumListIterator.previous().printSongs();
                        } else {
                            System.out.println("No more previous Album!");
                            changeDirection = false;
                        }
                    } else {
                        if (albumListIterator.hasNext()) {
                            System.out.println("Playing Album No." + (albumListIterator.nextIndex() + 1));
                            albumListIterator.next().printSongs();
                        } else {
                            System.out.println("No more next Album!");
                            changeDirection = true;
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
            }
        }


    }

    private static void printMenu() {
        System.out.println("Available actions:");
        System.out.println("0 - Quit!\n" +
                "1 - Go to next Album.\n" +
                "2 - Go to previous Album.\n" +
                "3 - Repeat current Album.\n" +
                "4 - Print menu of actions again.\n" +
                "-------------------------------");
    }

}
