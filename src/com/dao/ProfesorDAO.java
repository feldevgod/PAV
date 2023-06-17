package com.dao;
import com.facultad.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProfesorDAO<T> {
    private Session session;
  
    public ProfesorDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
  
    public void create(T object) {
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(object);
        transaction.commit();
    }
  
    public T read(Long id, Class<T> type) {
        return (T) session.get(type, id);
    }
  
    public void update(T object) {
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
    }
  
    public void delete(T object) {
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
    }
}