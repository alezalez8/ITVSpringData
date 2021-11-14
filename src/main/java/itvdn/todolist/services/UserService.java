package itvdn.todolist.services;

import itvdn.todolist.domain.PlainObjects.UserPojo;
import itvdn.todolist.domain.User;
import itvdn.todolist.services.interfaces.IUserService;
import itvdn.todolist.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

/*
    private final EntityManagerFactory entityManagerFactory;
    @Autowired
    public UserService(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
*/

    private final Converter converter;

    @Autowired
    public UserService(Converter converter) {
        this.converter = converter;
    }

  @PersistenceContext
  EntityManager entityManager;

    @Override
    @Transactional
    public UserPojo createUser(User user) {
        entityManager.persist(user);
/*
        User result = new User();
        result.setId(user.getId());
        result.setEmail(user.getEmail());
        result.setPassword(user.getPassword());
*/
        return converter.userToPojo(user);

    }

    @Override
    @Transactional(readOnly = true)
    public UserPojo getUser(long id) {
        User foundUser = entityManager
                .createQuery("SELECT user FROM User user WHERE user.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult(); // return Object, поэтому добавляем  User.class

        /*UserP result = new User();
        result.setId(foundUser.getId());
        result.setEmail(foundUser.getEmail());
        result.setPassword(foundUser.getPassword());*/
        //entityManager.getTransaction().commit();
        return converter.userToPojo(foundUser);
    }






/*
    @Override
    public User createUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        try {
            entityManager.persist(user);

            User result = new User();
            result.setId(user.getId());
            result.setEmail(user.getEmail());
            result.setPassword(user.getPassword());

            entityManager.getTransaction().commit();
            return result;
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }

    }
*/



    @Override
    @Transactional(readOnly = true)
    public List<UserPojo> getAllUsers() {
        List<User> listOfUsers = entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
        List<UserPojo> result =  listOfUsers.stream().map(user -> converter.userToPojo(user)).collect(Collectors.toList());
        return result;
    }
/*
    @Override
    public User getUser(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        try {
            User foundUser = entityManager
                    .createQuery("SELECT user FROM User user WHERE user.id = :id", User.class)
                    .setParameter("id", id)
                    .getSingleResult(); // return Object, поэтому добавляем  User.class

            User result = new User();
            result.setId(foundUser.getId());
            result.setEmail(foundUser.getEmail());
            result.setPassword(foundUser.getPassword());

            entityManager.getTransaction().commit();
            return result;
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }


    }
*/


    @Override
    public UserPojo updateUser(User updatedUser, long id) {
        return null;
    }

    @Override
    public UserPojo deleteUser(long id) {
        return null;
    }
}
