package view;

import java.util.Scanner;

public class MainView {

    public String selection = "";

    public void display() {
        while (!selection.toUpperCase().equals("Q")) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Which operation do you want to do?");
            System.out.println("----------------------------------");
            System.out.println("B) manage Book");
            System.out.println("A) manage Author");
            System.out.println("Q) Quit");
            selection = scan.nextLine();

            switch (selection.toUpperCase()) {
                case "B":
                    BookView bookView = new BookView();
                    bookView.display();
                    break;
                case "A":
                    AuthorVIew authorView = new AuthorVIew();
                    authorView.display();
                    break;
                default:

            }
        }
    }
}
