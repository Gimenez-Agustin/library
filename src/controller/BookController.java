package controller;

import hibernate.SessionConnection;
import java.util.List;
import model.Book;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookController {

    public static void addBook(Book book) throws Exception {
        try {
            book.setIdbook(ConfigurationController.getLastId("book"));
            SessionConnection sc = new SessionConnection();
            Transaction tx = sc.useSession().beginTransaction();
            sc.useSession().persist(book);
            tx.commit();
            sc.closeSession();
            ConfigurationController.updateId("book");
            displayBooks();
            System.out.println("Book added");
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public static void deleteBook(int id) throws Exception {
        try {
            SessionConnection sc = new SessionConnection();
            Transaction tx = sc.useSession().beginTransaction();
            sc.useSession().delete(getBook(id));
            tx.commit();
            sc.closeSession();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public static void updateBook(Book book) throws Exception {
        try {
            SessionConnection sc = new SessionConnection();
            Transaction tx = sc.useSession().beginTransaction();
            sc.useSession().update(book);
            tx.commit();
            sc.closeSession();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public static Book getBook(int id) {
        Book book;
        SessionConnection sc = new SessionConnection();
        Session session = sc.useSession();
        Query query = session.createQuery("from Book where idbook=:id");
        query.setParameter("id", id);
        book = (Book) query.uniqueResult();
        session.close();
        return book;
    }

    public static void displayBooks() throws Exception {
        try {
            SessionConnection sc = new SessionConnection();
            Session session = sc.useSession();
            Query query = session.createQuery("from Book");
            List<Book> books = (List<Book>) query.list();
            session.close();
            for (Book book : books) {
                System.out.println("Id   :  " + book.getIdbook());
                System.out.println("Title:  " + book.getTitle());
                System.out.println("Author: " + book.getAuthor().getName());
                System.out.println("----------------------------------");
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

}
