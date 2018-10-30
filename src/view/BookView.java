package view;

import controller.BookController;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book;

public class BookView {

    public String selection = "";

    public void display() {
     while (!selection.toUpperCase().equals("Q")) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Which operation do you want to do?");
            System.out.println("----------------------------------");
            System.out.println("A) Add Author");
            System.out.println("U) Update Author");
            System.out.println("R) Remove Author");
            System.out.println("D) Display Author");
            System.out.println("Q) Quit");
            selection = scan.nextLine();

            switch (selection.toUpperCase()) {
                case "A":
                    try {
                        Book book = new Book();
                        BookController authorController = new BookController();
                        System.out.println("Write the title of the book:");
                        book.setTitle(scan.nextLine());
                        System.out.println("Write the sub title of the book:");
                        book.setSubtitle(scan.nextLine());
                        authorController.addBook(book);
                        System.out.println("Book added correctly");
                    } catch (Exception ex) {
                        System.out.println("Error " + ex.getMessage());
                    }
                    break;
                case "U":
                    try {
                        System.out.println("Give me the id of the author");
                        String AuthorId = scan.nextLine();
                        int id = Integer.valueOf(AuthorId);
                        System.out.println("Give me the new name of the author");
                        String bookName = scan.nextLine();
                        Book book = BookController.getBook(id);
                        book.setTitle(bookName);
                        BookController.updateBook(book);
                    } catch (Exception ex) {
                        System.err.println("Exception " + ex.getMessage());
                    }
                    break;
                case "D":
                    try {
                        BookController.displayBooks();
                    } catch (Exception ex) {
                        Logger.getLogger(AuthorVIew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "R":
                    try {
                        System.out.println("Give me the id of the author");
                        String AuthorId = scan.nextLine();
                        int id = Integer.valueOf(AuthorId);
                        BookController.deleteBook(id);
                    } catch (Exception ex) {
                        System.err.println("Exception " + ex.getMessage());
                    }
                    break;
                default:
                    System.err.println("Choose a correct option");
            }
        }
    }
}
