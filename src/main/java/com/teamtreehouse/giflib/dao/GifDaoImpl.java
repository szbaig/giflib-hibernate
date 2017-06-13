package com.teamtreehouse.giflib.dao;

import com.teamtreehouse.giflib.model.Gif;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Repository
public class GifDaoImpl implements GifDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Gif> findAll() {
        // Open a session
        Session session = sessionFactory.openSession();

        // Get all categories with Hibernate criteria
        List<Gif> gifs = session.createCriteria(Gif.class).list();

        // Close the session
        session.close();

        return gifs;
    }

    @Override
    public Gif findById(Long id) {
        // Open a session
        Session session = sessionFactory.openSession();
        Gif gif = session.get(Gif.class, id);
        session.close();
        return gif;
    }

    @Override
    public void save(Gif gif) {
        // Open a session
        Session session = sessionFactory.openSession();
        // Begin a transaction
        session.beginTransaction();
        // Save the gif
        session.save(gif);
        // Commit the transaction
        session.getTransaction().commit();
        // Close the session
        session.close();
    }

    @Override
    public void delete(Gif gif) {
        // Open a session
        Session session = sessionFactory.openSession();
        // Begin a transaction
        session.beginTransaction();
        // Delete the gif
        session.delete(gif);
        // Commit the transaction
        session.getTransaction().commit();
        // Close the session
        session.close();
    }
}
