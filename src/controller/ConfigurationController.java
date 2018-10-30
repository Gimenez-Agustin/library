package controller;

import hibernate.SessionConnection;
import model.Configuration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ConfigurationController {
    
    public static int getLastId(String className){
        Configuration configuration;
        int i = -1;
        SessionConnection sc = new SessionConnection();
        Session session = sc.useSession();
        Query query = session.createQuery("from Configuration where className=:name");
        query.setParameter("name", className);
        configuration = (Configuration) query.uniqueResult();
        session.close();
        if (configuration != null) {
            i = configuration.getId();
        }
        return i;
    }
    

    public static void updateId(String className) {
        int i = getLastId(className);
        Configuration configuration;
        if (i != -1) {
            SessionConnection sc = new SessionConnection();
            Query query = sc.useSession().createQuery("from Configuration where className=:name");
            query.setParameter("name", className);
            configuration = (Configuration) query.uniqueResult();
            i++;
            configuration.setId(i);
            Transaction tx = sc.useSession().beginTransaction();
            sc.useSession().update(configuration);
            tx.commit();
            sc.closeSession();
        }
    }
}
