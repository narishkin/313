package home.catechumen.bootMVC.dao;

import home.catechumen.bootMVC.model.Role;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAll() {
        return entityManager.createQuery("FROM Role", Role.class).getResultList();
    }
}
