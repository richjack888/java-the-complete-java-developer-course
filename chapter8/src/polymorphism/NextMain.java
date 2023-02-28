package polymorphism;

public class NextMain {

    public static void main(String[] args) {

//        Movie movie = Movie.getMovie("A", "Jaws");
//        movie.watchMovie();
//
//        Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws");
//        jaws.watchMovie();
//
//        Object comedy = Movie.getMovie("C", "Airplane");
//        Comedy comedyMovie = (Comedy) comedy;
//        comedyMovie.watchComedy();
//
//        var airplane = Movie.getMovie("C", "Airplane");
//        airplane.watchMovie();
//
//        var plane = new Comedy("Airplane");
//        plane.watchComedy();

        Object unknownObject = Movie.getMovie("C", "Airplane");
        String comedyStr = "Comedy";
        if (unknownObject.getClass().getSimpleName() == comedyStr) {
            Comedy c = (Comedy) unknownObject;
            c.watchComedy();
        } else if (unknownObject instanceof Adventure) {
            ((Adventure) unknownObject).watchAdventure();
        } else if (unknownObject instanceof ScienceFiction syfy) {
            syfy.watchScienceFiction();
        } else {
            System.out.println("Unknown object address " + unknownObject.hashCode());
            // print comedy string object address
            System.out.println("Comedy string address " + comedyStr.hashCode());
            System.out.println(unknownObject.getClass().getSimpleName());
        }
    }
}
