package model;
// Generated Oct 28, 2018 7:57:40 PM by Hibernate Tools 4.3.1



/**
 * Book generated by hbm2java
 */
public class Book  implements java.io.Serializable {


     private int idbook;
     private Author author;
     private String title;
     private String subtitle;

    public Book() {
    }

	
    public Book(int idbook) {
        this.idbook = idbook;
    }
    public Book(int idbook, Author author, String title, String subtitle) {
       this.idbook = idbook;
       this.author = author;
       this.title = title;
       this.subtitle = subtitle;
    }
   
    public int getIdbook() {
        return this.idbook;
    }
    
    public void setIdbook(int idbook) {
        this.idbook = idbook;
    }
    public Author getAuthor() {
        return this.author;
    }
    
    public void setAuthor(Author author) {
        this.author = author;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSubtitle() {
        return this.subtitle;
    }
    
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }




}


