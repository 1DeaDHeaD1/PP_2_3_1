package ru.mvc_hiber.dao;


import org.springframework.stereotype.Repository;
import ru.mvc_hiber.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User findById(Long id) {
        TypedQuery<User> query = entityManager.createQuery("from User u where u.id = :id", User.class);
        query.setParameter("id", id);
        return query.getResultList().get(0);
    }

    @Override
    public User update(User user) {
        return entityManager.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

}
