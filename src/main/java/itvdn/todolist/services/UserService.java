package itvdn.todolist.services;

import itvdn.todolist.Exceptions.CustomEmptyDataException;
import itvdn.todolist.domain.PlainObjects.UserPojo;
import itvdn.todolist.domain.User;
import itvdn.todolist.repositories.UserRepository;
import itvdn.todolist.services.interfaces.IUserService;
import itvdn.todolist.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private final Converter converter;
    private final UserRepository userRepository;

    @Autowired
    public UserService(Converter converter,
                       UserRepository userRepository) {
        this.converter = converter;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserPojo createUser(User user) {

        userRepository.save(user);

        return converter.userToPojo(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserPojo getUser(long id) {

        Optional<User> foundUserOptional = userRepository.findById(id);

        if (foundUserOptional.isPresent()) {
            return converter.userToPojo(foundUserOptional.get());
        } else {
            // throw new CustomEmptyDataException("unable to get user");
            throw new NoSuchElementException("unable to get user");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserPojo> getAllUsers() {
        List<User> listOfUsers = userRepository.findAll();
        return listOfUsers.stream().map(user -> converter.userToPojo(user)).collect(Collectors.toList());

    }

    @Override
    @Transactional
    public UserPojo updateUser(User source, long id) {
        Optional<User> userForUpdateOptional = userRepository.findById(id);
        if (userForUpdateOptional.isPresent()) {
            User target = userForUpdateOptional.get();
            target.setEmail(source.getEmail());
            target.setPassword(source.getPassword());
            userRepository.save(target);
            return converter.userToPojo(target);
        } else {
            // return converter.userToPojo(new User());
            // throw  new NoSuchElementException("No such user");
            throw new CustomEmptyDataException("unable to update user");

        }
    }

    @Override
    @Transactional
    public String deleteUser(long id) {
        Optional<User> userForDeleteOptional = userRepository.findById(id);

        if (userForDeleteOptional.isPresent()) {
            userRepository.delete(userForDeleteOptional.get());
            return "User with id:" + id + " was successfully remover";
        } else {
            throw new CustomEmptyDataException("unable to delete user");
        }
    }

    @Override
    @Transactional
    public UserPojo findUserByEmailAndPassword(String email, String password) {
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        if (user.isPresent()) {
            return converter.userToPojo(user.get());
        } else {
            return null;
        }

    }
}
