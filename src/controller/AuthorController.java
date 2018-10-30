package controller;

import hibernate.SessionConnection;
import java.util.List;
import model.Author;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AuthorController {

    public static void addAuthor(Author author) throws Exception {
        try {
            author.setIdauthor(ConfigurationController.getLastId("author"));
            SessionConnection sc = new SessionConnection();
            Transaction tx = sc.useSession().beginTransaction();
            sc.useSession().persist(author);
            tx.commit();
            sc.closeSession();
            ConfigurationController.updateId("author");
            displayAuthors();
            System.out.println("Author added");
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public static void deleteAuthor(int id) throws Exception {
        try {
            SessionConnection sc = new SessionConnection();
            Transaction tx = sc.useSession().beginTransaction();
            sc.useSession().delete(getAuthor(id));
            tx.commit();
            sc.closeSession();
            displayAuthors();
            System.out.println("Author deleted");
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public static void updateAuthor(Author author) throws Exception {
        try {
            SessionConnection sc = new SessionConnection();
            Transaction tx = sc.useSession().beginTransaction();
            sc.useSession().update(author);
            tx.commit();
            sc.closeSession();
            displayAuthors();
            System.out.println("Author updated");
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }
    
    public static Author getAuthor(int id){
        Author author;
        SessionConnection sc = new SessionConnection();
        Session session = sc.useSession();
        Query query = session.createQuery("from Author where idauthor=:id");
        query.setParameter("id", id);
        author = (Author) query.uniqueResult();
        session.close();
        return author;
    }

    public static void displayAuthors() throws Exception {
        try {
            SessionConnection sc = new SessionConnection();
            Session session = sc.useSession();
            Query query = session.createQuery("from Author");
            List<Author> authors = (List<Author>) query.list();
            session.close();
            for (Author author : authors) {
                System.out.println("ID:          " + author.getIdauthor());
                System.out.println("Name:        " + author.getName());
                System.out.println("Description: " + author.getName());
                System.out.println("----------------------------------");
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }
}
