package co.edu.utp.misiontic2022.c2.cdiaz.bookshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DBManager implements AutoCloseable {
    private Connection connection;

    public DBManager() throws SQLException {
        connect();
    }

    private void connect() throws SQLException {
        // TODO: program this method
        String url = "/home/coscristian/Escritorio/Ciclo-2---MinTic/ProyectosCiclo2/libros/src/main/java/co/edu/utp/misiontic2022/c2/cdiaz/bookshop/bookShop.db";
        String bbdd = "jdbc:sqlite:";
        connection = DriverManager.getConnection(bbdd + url, "", "");
    }

    /**
     * Close the connection to the database if it is still open.
     *
     */
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
        connection = null;
    }

    public boolean addBookDB(Book book, int cantExistencias) throws SQLException{
        // Add book
        var sqlAddBook = "INSERT INTO libro VALUES (?, ?, ?, ?);";
        PreparedStatement preparedStatm = connection.prepareStatement(sqlAddBook);
        preparedStatm.setString(1, book.getIsbn());
        preparedStatm.setInt(2, book.getId());
        preparedStatm.setString(3, book.getTitle());
        preparedStatm.setInt(4, book.getYear());

        // Add amount of existences of the book
        var sqlAddExistences = "INSERT INTO stock VALUES (?, ?);";
        PreparedStatement preparedStatm2 = connection.prepareStatement(sqlAddExistences);
        preparedStatm2.setInt(1, book.getId());
        preparedStatm2.setInt(2, cantExistencias);
        return preparedStatm.executeUpdate() == 1 && preparedStatm2.executeUpdate() == 1;
    }

     /**
     * Return the number of units in stock of the given book.
     *
     * @param book The book object.
     * @return The number of units in stock, or 0 if the book does not
     *         exist in the database.
     * @throws SQLException If somthing fails with the DB.
     */
    public int getStock(Book book) throws SQLException {
        return getStock(book.getId());
    }

    /**
     * Return the number of units in stock of the given book.
     *
     * @param bookId The book identifier in the database.
     * @return The number of units in stock, or 0 if the book does not
     *         exist in the database.
     */
    public int getStock(int bookId) throws SQLException {
        // TODO: program this method
        var sql = "SELECT cant_existente,id " +
                "FROM stock " +
                "WHERE id = " + bookId + ";";
        PreparedStatement preparedStatm = connection.prepareStatement(sql);
        ResultSet rset = preparedStatm.executeQuery();
        //if(rset.isBeforeFirst()) // checks if the book has at least 1 unit, otherwise returns 0
            return rset.getInt("cant_existente");
        //return 0;
    }

    /**
     * Search book by ISBN.
     *
     * @param isbn The ISBN of the book.
     * @return The Book object, or null if not found.
     * @throws SQLException If somthing fails with the DB.
     */
    public Book searchBook(String isbn) throws SQLException {
        // TODO: program this method
        var sql = "SELECT titulo, isbn, anio_pub, id " + 
                "FROM libro " + 
                "WHERE isbn = " + isbn + ";";
        PreparedStatement preparedStatm = connection.prepareStatement(sql);
        ResultSet rset = preparedStatm.executeQuery();
        
        if (rset.isBeforeFirst()) // returns false if the rset contains no rows
            return new Book(rset.getString("titulo"), rset.getString("isbn"), rset.getInt("anio_pub"), rset.getInt("id"));
        return null;
    }

    /**
     * Sell a book.
     *
     * @param book The book.
     * @param units Number of units that are being sold.
     * @return True if the operation succeeds, or false otherwise
     *         (e.g. when the stock of the book is not big enough).
     * @throws SQLException If somthing fails with the DB.
     */
    public boolean sellBook(Book book, int units) throws SQLException {
        return sellBook(book.getId(), units);
    }

    public boolean updateExcistences(int units, int bookId, int availableBooks) throws SQLException{
        String sql = "UPDATE stock " + 
        "SET cant_existente = " + (availableBooks - units) + " " + 
        "WHERE id = " + bookId + ";";
        PreparedStatement preparedStat = connection.prepareStatement(sql);
        return preparedStat.executeUpdate() == 1;
    }

    public boolean registerSale(int bookId, int units) throws SQLException{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now(); 
        String strDate = dtf.format(now);

        String sql = "INSERT INTO venta VALUES (?,?,?);";
        PreparedStatement preparedStat = connection.prepareStatement(sql);
        preparedStat.setString(1, strDate);
        preparedStat.setString(2, String.valueOf(bookId));
        preparedStat.setInt(3, units);
    
        return preparedStat.executeUpdate() == 1;
    }

    /**
     * Sell a book.
     *
     * @param bookId The book's identifier.
     * @param units Number of units that are being sold.
     * @return True if the operation succeeds, or false otherwise
     *         (e.g. when the stock of the book is not big enough).
     * @throws SQLException If something fails with the DB.
     */
    public boolean sellBook(int bookId, int units) throws SQLException {
        // TODO: program this method
        var sql = "SELECT cant_existente " + 
                "FROM stock " + 
                "WHERE id = " + bookId + ";";
        PreparedStatement preparedStat = connection.prepareStatement(sql);
        ResultSet rSet = preparedStat.executeQuery();
        
        int availableBooks = rSet.getInt("cant_existente");

        if (units <= availableBooks){
            // Registrar venta
            if(registerSale(bookId, units) && updateExcistences(units, bookId, availableBooks)){
                return true;
            }
        }
        return false;
    }

    /**
     * Return a list with all the books in the database.
     *
     * @return List with all the books.
     * @throws SQLException If something fails with the DB.
     */
    public List<Book> listBooks() throws SQLException {
        // TODO: program this method
        var sql = "SELECT * FROM libro";
        PreparedStatement preparedSt = connection.prepareStatement(sql);
        ResultSet rset = preparedSt.executeQuery();
        
        List<Book> booksList = new ArrayList<>();

        while(rset.next()){
            var title = rset.getString("titulo");
            var isbn = rset.getString("isbn");
            var year = rset.getInt("anio_pub");
            var id = rset.getInt("id");
            booksList.add(new Book(title, isbn, year, id));
        }
        return booksList;
    }
}
