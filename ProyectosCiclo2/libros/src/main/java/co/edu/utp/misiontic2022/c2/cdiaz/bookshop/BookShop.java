package co.edu.utp.misiontic2022.c2.cdiaz.bookshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class BookShop {

    private final BufferedReader input;

    public BookShop() {
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start() {
        var mainLoop = true;
        while (mainLoop) {
            System.out.println("");
            System.out.println("==========================================");
            System.out.println(" Gestor de Librería");
            System.out.println("==========================================");
            System.out.println("1. Agregar libro");
            System.out.println("2. Listado de libros");
            System.out.println("3. Busqueda de libro");
            System.out.println("4. Consulta de existencias");
            System.out.println("5. Venta de libros");
            System.out.println("0. Salir");
            System.out.println("==========================================");
            System.out.print("Ingrese su opción: ");
            try {
                var opcion = Integer.valueOf(input.readLine());
                switch (opcion) {
                    case 0:
                        mainLoop = false;
                        break;
                    case 1:
                        //agregarLibro();
                        break;
                    case 2:
                        listadoLibros();
                        break;
                    case 3:
                        busquedaLibro();
                        break;
                    case 4:
                        consultaExistencias();
                        break;
                    case 5:
                        venta();
                        break;
                    default:
                        System.err.println("Opción no válida");
                }
            } catch (NumberFormatException | IOException e) {
                System.err.println("Ha ocurrido un error: " + e);
            }
        }
    }

/*     private void agregarLibro(){
        System.out.println("");
        System.out.println("==========================================");
        System.out.println(" Agregar libro");
        System.out.println("==========================================");
        try (var manager = new DBManager()) {
            System.out.println("Ingrese el titulo del libro");
            String title = input.readLine();
            
            System.out.println("Ingrese el ISBN del libro");
            String isbn = input.readLine();

            System.out.println("Ingrese el año del libro");
            int year = input.readLine();

            Book book = new Book(title, isbn, year);


        }catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Excepción SQL: " + ex.getMessage());
            System.out.println("Estado SQL: " + ex.getSQLState());
            System.out.println("Código de error: " + ex.getErrorCode());
        }
    } */

    private void listadoLibros() {
        System.out.println("");
        System.out.println("==========================================");
        System.out.println(" Listado de libros");
        System.out.println("==========================================");
        try (var manager = new DBManager()) {
            var books = manager.listBooks();
            books.forEach(System.out::println);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Excepción SQL: " + ex.getMessage());
            System.out.println("Estado SQL: " + ex.getSQLState());
            System.out.println("Código de error: " + ex.getErrorCode());
        }
    }

    private void busquedaLibro() throws IOException {
        System.out.println("");
        System.out.println("==========================================");
        System.out.println(" Búsqueda de libros");
        System.out.println("==========================================");
        try (var manager = new DBManager()) {
            System.out.print("Ingrese el ISBN del libro a consultar: ");
            var isbn = input.readLine();

            Book book = manager.searchBook(isbn);
            if (book != null) {
                System.out.println(book);
            } else {
                System.out.println("Libro no encontrado: " + isbn);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Excepción SQL: " + ex.getMessage());
            System.out.println("Estado SQL: " + ex.getSQLState());
            System.out.println("Código de error: " + ex.getErrorCode());
        }
    }

    private void consultaExistencias() throws IOException {
        System.out.println("");
        System.out.println("==========================================");
        System.out.println(" Consulta de existencias");
        System.out.println("==========================================");
        try (var manager = new DBManager()) {
            System.out.print("Ingrese el ISBN del libro a consultar: ");
            var isbn = input.readLine();

            Book book = manager.searchBook(isbn);
            if (book != null) {
                int units = manager.getStock(book);
                System.out.println("Hay " + units + " copias de " + book);
            } else {
                System.out.println("Libro no encontrado: " + isbn);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Excepción SQL: " + ex.getMessage());
            System.out.println("Estado SQL: " + ex.getSQLState());
            System.out.println("Código de error: " + ex.getErrorCode());
        }
    }

    private void venta() throws IOException {
        System.out.println("");
        System.out.println("==========================================");
        System.out.println(" Venta de libros");
        System.out.println("==========================================");
        try (var manager = new DBManager()) {
            System.out.print("Ingrese el ISBN del libro a consultar: ");
            var isbn = input.readLine();
            System.out.print("Ingrese la cantidad a vender: ");
            var units = Integer.valueOf(input.readLine());

            Book book = manager.searchBook(isbn);
            if (book != null) {
                boolean success = manager.sellBook(book, units);
                if (success) {
                    System.out.println("Libro vendido: " + units + " copias de " + book);
                } else {
                    System.out.println("No existen suficientes (" + units + ") copias de " + book);
                }
            } else {
                System.out.println("Libro no encontrado: " + isbn);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Excepción SQL: " + ex.getMessage());
            System.out.println("Estado SQL: " + ex.getSQLState());
            System.out.println("Código de error: " + ex.getErrorCode());
        }
    }
}
