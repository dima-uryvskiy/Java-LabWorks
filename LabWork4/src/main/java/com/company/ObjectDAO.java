package com.company;

import com.company.util.HibernateUtil;
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

    public Chair getChairById(Long idObject)
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

    public Desk getDeskById(Long idObject)
    {
        Session session = null;
        Desk desk = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            desk = (Desk) session.get(Desk.class, idObject);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Error I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return desk;
    }

    public Office getOfficeById(Long idObject)
    {
        Session session = null;
        Office office = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            office = (Office) session.get(Office.class, idObject);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Error I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return office;
    }

    public List<Office> getAllOffice() {
        Session session = null;
        List<Office> offices = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            offices = (List<Office>)  HibernateUtil.getSessionFactory().openSession().createQuery("From Office").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Error I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return offices;
    }

    public List<Office> hqlRequest() {
        return (List<Office>)  HibernateUtil.getSessionFactory().openSession().createQuery("SELECT office From Chair, Desk, Office office WHERE office.name = 'Mini'").list();
    }
}
