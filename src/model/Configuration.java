package model;
// Generated Oct 28, 2018 7:57:40 PM by Hibernate Tools 4.3.1



/**
 * Configuration generated by hbm2java
 */
public class Configuration  implements java.io.Serializable {


     private String className;
     private int id;

    public Configuration() {
    }

    public Configuration(String className, int id) {
       this.className = className;
       this.id = id;
    }
   
    public String getClassName() {
        return this.className;
    }
    
    public void setClassName(String className) {
        this.className = className;
    }
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }




}


