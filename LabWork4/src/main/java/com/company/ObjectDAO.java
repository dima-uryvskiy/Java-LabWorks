package com.company;

import com.company.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import javax.swing.*;
import java.util.List;

public class ObjectDAO
{
    public void addValue(Object object)
    {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Error I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateValue(Object object)
    {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Error I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteValue(Object object)
    {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Error I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Object getChairById(Long idObject) // --
    {
        Session session = null;
        Chair chair = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            chair = (Chair) session.get(Chair.class, idObject);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Error I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return chair;
    }

    public List getAllFurnitures(String nameValue)  // --
    {
        Session session = null;
        //List<Furniture> furnitures = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
           // Query query = session.createQuery("FROM Furniture Where name = nameValue");
            //furnitures = (List<Furniture>) query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Error I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return null;
    }
}
