public class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public static Book random() {
        int randomNumber = (int) (Math.random() * 5 + 1);
        System.out.println("Random number: " + randomNumber);
        switch (randomNumber) {
            case 1:
                return new MeanGenes();
            case 2:
                return new GettingThingsDone();
            case 3:
                return new Influence();
            case 4:
                return new ASeventhChildAndTheLaw();
            case 5:
                return new FooledByRandomness();
        }
        return null;
    }

    public String author() {
        return "No find author";
    }

    public String getName() {
        return name;
    }
}


class MeanGenes extends Book {
    public MeanGenes() {
        super("MeanGenes");
    }

    @Override
    public String author() {
        return "Terence C. Burnham";
    }
}

class GettingThingsDone extends Book {
    public GettingThingsDone() {
        super("GettingThingsDone");
    }

    @Override
    public String author() {
        return "David Allen";
    }
}

class Influence extends Book {
    public Influence() {
        super("Influence");
    }

    @Override
    public String author() {
        return "Robert Cialdini";
    }
}

class ASeventhChildAndTheLaw extends Book {
    public ASeventhChildAndTheLaw() {
        super("ASeventhChildAndTheLaw");
    }

    @Override
    public String author() {
        return "Patrick Yu";
    }
}

class FooledByRandomness extends Book {
    public FooledByRandomness() {
        super("FooledByRandomness");
    }
}

class run {
    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            Book book = Book.random();
            System.out.println("Book name: " + book.getName() + "\n"
                    + "Author: " + book.author() + "\n");
        }
    }
}




