package musicDB.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    public static final String DB_Name = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\software\\JetBrains\\IdeaProjects\\java-the-complete-java-developer-course\\chapter19\\src\\musicDB\\" + DB_Name;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 4;

    public enum SortOrder {
        ORDER_BY_NONE,
        ORDER_BY_ASC,
        ORDER_BY_DESC;
    }

    public static final String QUERY_ALBUMS_BY_ARTIST_START =
            "SELECT " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " FROM " + TABLE_ALBUMS +
                    " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
                    " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
                    " WHERE " + TABLE_ARTISTS + "." + COLUMN_ALBUM_NAME + " = \"";

    public static final String QUERY_ALBUMS_BY_ARTIST_SORT =
            " ORDER BY " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";


    public static final String QUERY_ARTIST_FOR_SONG_START =
            "SELECT " + TABLE_ARTISTS + "." + COLUMN_ALBUM_NAME + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
                    TABLE_SONGS + "." + COLUMN_SONG_TRACK + " FROM " + TABLE_SONGS +
                    " INNER JOIN " + TABLE_ALBUMS + " ON " +
                    TABLE_SONGS + "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
                    " INNER JOIN " + TABLE_ARTISTS + " ON " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ALBUM_ID +
                    " WHERE LOWER (" + TABLE_SONGS + "." + COLUMN_SONG_TITLE + ") = \"";

    public static final String QUERY_ARTIST_FOR_SONG_SORT =
            " ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + "," +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";

    public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";
    public static final String CREATE_ARTIST_FOR_SONG_VIEW = "CREATE VIEW IF NOT EXISTS " +
            TABLE_ARTIST_SONG_VIEW + " AS SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " AS " + COLUMN_SONG_ALBUM + ", " +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK + ", " + TABLE_SONGS + "." + COLUMN_SONG_TITLE +
            " FROM " + TABLE_SONGS +
            " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS +
            "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
            " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
            " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
            " ORDER BY " +
            TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK;

    public static final String QUERY_VIEW_SONG_INFO = " SELECT " + COLUMN_ARTIST_NAME + ", " +
            COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW +
            " WHERE LOWER (" + COLUMN_SONG_TITLE + ") = \"";

    public static final String QUERY_VIEW_SONG_INFO_PREP = "SELECT " + COLUMN_ARTIST_NAME + ", " +
            COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW +
            " WHERE LOWER (" + COLUMN_SONG_TITLE + ") = ?";

    public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS +
            "(" + COLUMN_ARTIST_NAME + ") VALUES(?)";

    public static final String INSERT_ALBUMS = "INSERT INTO " + TABLE_ALBUMS +
            "(" + COLUMN_ALBUM_NAME + ", " + COLUMN_ALBUM_ARTIST + ") VALUES(?, ?)";

    public static final String INSERT_SONGS = "INSERT INTO " + TABLE_SONGS +
            "(" + COLUMN_SONG_TRACK + ", " + COLUMN_SONG_TITLE + ", " + COLUMN_SONG_ALBUM +
            ") VALUES(?, ?, ?)";

    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID + " FROM " +
            TABLE_ARTISTS + " WHERE " + COLUMN_ARTIST_NAME + " =?";

    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUM_ID + " FROM " +
            TABLE_ALBUMS + " WHERE " + COLUMN_ALBUM_NAME + " =?";

    private Connection conn;

    private PreparedStatement querySongInfoView;

    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;

    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            querySongInfoView = conn.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);
            System.out.println("Connect to " + DB_Name + " success!");
            insertIntoArtists = conn.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = conn.prepareStatement(INSERT_ALBUMS, Statement.RETURN_GENERATED_KEYS);
            insertIntoSongs = conn.prepareStatement(INSERT_SONGS);
            queryArtist = conn.prepareStatement(QUERY_ARTIST);
            queryAlbum = conn.prepareStatement(QUERY_ALBUM);

            return true;

        } catch (SQLException e) {
            System.out.println("Couldn't connect ot database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (querySongInfoView != null) {
                querySongInfoView.close();
            }

            if (insertIntoArtists != null) {
                insertIntoArtists.close();
            }

            if (insertIntoAlbums != null) {
                insertIntoAlbums.close();
            }

            if (insertIntoSongs != null) {
                insertIntoSongs.close();
            }

            if (queryArtist != null) {
                queryArtist.close();
            }

            if (queryAlbum != null) {
                queryAlbum.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    public List<Artist> queryArtists(SortOrder sortOrder) {

        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM ");
        stringBuilder.append(TABLE_ARTISTS);
        if (sortOrder != SortOrder.ORDER_BY_NONE) {
            stringBuilder.append(" ORDER BY ");
            stringBuilder.append(COLUMN_ARTIST_NAME);
            stringBuilder.append(" COLLATE NOCASE ");
            if (sortOrder == SortOrder.ORDER_BY_DESC) {
                stringBuilder.append("DESC");
            } else {
                stringBuilder.append("ASC");
            }
        }


        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(stringBuilder.toString())) {

            List<Artist> artists = new ArrayList<>();
            while (resultSet.next()) {
                Artist artist = new Artist();
                artist.setId(resultSet.getInt(INDEX_ARTIST_ID));
                artist.setName(resultSet.getString(INDEX_ARTIST_NAME));
                artists.add(artist);
            }
            return artists;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public List<String> queryAlbumsForArtist(String artistName, SortOrder sortOrder) {

        // SELECT albums.name FROM albums INNER JOIN artists ON albums.artist = artists._id WHERE artists.name = "Iron Maiden" ORDER BY albums.name COLLATE NOCASE ASC
        StringBuilder stringBuilder = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START);
        stringBuilder.append(artistName);
        stringBuilder.append("\"");

        if (sortOrder != SortOrder.ORDER_BY_NONE) {
            stringBuilder.append(QUERY_ALBUMS_BY_ARTIST_SORT);
            if (sortOrder == SortOrder.ORDER_BY_DESC) {
                stringBuilder.append("DESC");
            } else {
                stringBuilder.append("ASC");
            }
        }

        System.out.println("SQL statement = " + stringBuilder.toString());

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(stringBuilder.toString())) {
            List<String> albums = new ArrayList<>();
            while (resultSet.next()) {
                albums.add(resultSet.getString(1));
            }
            return albums;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public List<SongArtist> queryArtistsForSong(String songName, SortOrder sortOrder) {
        StringBuilder stringBuilder = new StringBuilder(QUERY_ARTIST_FOR_SONG_START);
        stringBuilder.append(songName);
        stringBuilder.append("\"");

        if (sortOrder != SortOrder.ORDER_BY_NONE) {
            stringBuilder.append(QUERY_ARTIST_FOR_SONG_SORT);
            if (sortOrder == SortOrder.ORDER_BY_DESC) {
                stringBuilder.append("DESC");
            } else {
                stringBuilder.append("ASC");
            }
        }

        System.out.println("SQL statement = " + stringBuilder.toString());

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(stringBuilder.toString())) {

            List<SongArtist> songArtists = new ArrayList<>();
            while (results.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(results.getString(1));
                songArtist.setAlbumName(results.getString(2));
                songArtist.setTrack(results.getInt(3));
                songArtists.add(songArtist);
            }
            return songArtists;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public void querySongsMetadata() {
        String sql = "SELECT * FROM " + TABLE_SONGS;

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int numColumn = resultSetMetaData.getColumnCount();
            for (int i = 1; i <= numColumn; i++) {
                System.out.format("Column %d in the songs table is name %s\n",
                        i, resultSetMetaData.getColumnName(i));
            }
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
    }

    public int getCount(String tableName) {
        String sql = "SELECT COUNT(*) AS count FROM " + tableName;
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);) {

            return resultSet.getInt("count");
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return -1;
        }
    }

    public boolean createViewForSongArtists() {
        try (Statement statement = conn.createStatement()) {
            statement.execute(CREATE_ARTIST_FOR_SONG_VIEW);
            System.out.println("View of " + TABLE_ARTIST_SONG_VIEW + " created success!");
            return true;

        } catch (SQLException e) {
            System.out.println("Create View failed: " + e.getMessage());
            return false;
        }
    }

    public List<SongArtist> querySongInfoView(String song_title) {

        try {
            querySongInfoView.setString(1, song_title);
            ResultSet resultSet = querySongInfoView.executeQuery();

            List<SongArtist> songArtists = new ArrayList<>();
            while (resultSet.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(resultSet.getString(1));
                songArtist.setAlbumName(resultSet.getString(2));
                songArtist.setTrack(resultSet.getInt(3));
                songArtists.add(songArtist);
            }
            return songArtists;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    private int insertArtist(String name) throws SQLException {
        queryArtist.setString(1, name);
        ResultSet resultSet = queryArtist.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        } else {
            // Insert the artist
            insertIntoArtists.setString(1, name);
            int affectRows = insertIntoArtists.executeUpdate();
            if (affectRows != 1) {
                throw new SQLException("Couldn't insert artist");
            }
            ResultSet generateKeys = insertIntoArtists.getGeneratedKeys();
            if (generateKeys.next()) {
                return generateKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for artist");
            }
        }

    }

}