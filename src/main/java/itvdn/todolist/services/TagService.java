package itvdn.todolist.services;

import itvdn.todolist.domain.Tag;
import itvdn.todolist.services.interfaces.ITagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class TagService implements ITagService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Tag findOrCreate(Tag tag) {

        List<Tag> foundTags = entityManager
                .createQuery("SELECT tag FROM Tag tag WHERE tag.name = :name", Tag.class)
                .setParameter("name", tag.getName())
                .getResultList();
        if(foundTags.isEmpty()) {
            entityManager.persist(tag);
            return tag;
        } else {
            return foundTags.get(0);
        }
    }
}
