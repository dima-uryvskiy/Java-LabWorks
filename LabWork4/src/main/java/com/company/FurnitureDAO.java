package com.company;

import com.company.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import javax.swing.*;
import java.util.List;

public class FurnitureDAO implements FurnitureDAOInterface
{
    public void addFurniture(Furniture furniture)
    {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(furniture);
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

    public void updateFurniture(Furniture furniture)
    {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(furniture);
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

    public Furniture getFurnitureById(Long idFurniture)
    {
        Session session = null;
        Furniture furniture = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            furniture = (Furniture) session.get(Furniture.class, idFurniture);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Error I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return furniture;
    }

    public List getAllFurnitures(Furniture furniture)
    {
        Session session = null;
        List<Furniture> furnitures = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            Query query = session.createQuery("FROM Furniture");
            furnitures = (List<Furniture>) query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Error I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return furnitures;
    }

    public void deleteFurniture(Furniture furniture)
    {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(furniture);
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
}
