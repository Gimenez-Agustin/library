package view;

import controller.AuthorController;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Author;

public class AuthorVIew {

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
                        Author author = new Author();
                        AuthorController authorController = new AuthorController();
                        System.out.println("Write the name of the author:");
                        author.setName(scan.nextLine());
                        System.out.println("Write the description of the author:");
                        author.setDescription(scan.nextLine());
                        author.setActive(true);
                        authorController.addAuthor(author);
                        System.out.println("Author added correctly");
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
                        String AuthorName = scan.nextLine();
                        Author author = AuthorController.getAuthor(id);
                        author.setName(AuthorName);
                        AuthorController.updateAuthor(author);
                    } catch (Exception ex) {
                        System.err.println("Exception " + ex.getMessage());
                    }
                    break;
                case "D":
                    try {
                        AuthorController.displayAuthors();
                    } catch (Exception ex) {
                        Logger.getLogger(AuthorVIew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "R":
                    try {
                        System.out.println("Give me the id of the author");
                        String AuthorId = scan.nextLine();
                        int id = Integer.valueOf(AuthorId);
                        AuthorController.deleteAuthor(id);
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
