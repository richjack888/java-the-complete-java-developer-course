package musicDB;


import musicDB.model.Datasource;


public class Main {
    public static void main(String[] args) {
        Datasource dataSource = new Datasource();
        if (!dataSource.open()) {
            System.out.println("Can't open datasourece");
            return;
        }
        dataSource.close();


    }
}
