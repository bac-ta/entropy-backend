package com.entropy.backend.repositories.customs.impls;

import com.entropy.backend.models.entities.User;
import com.entropy.backend.repositories.customs.UserRepositoryCustom;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Class implement {@link UserRepositoryCustom}
 *
 * @author bac-ta
 * @see UserRepositoryCustomImpl
 * @since 2021-06-15
 */
@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> findUserExistBy(String username, String email, String phone) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        List<Predicate> predicates = new LinkedList<>();

        predicates.add(builder.equal(root.get(User.Fields.username), username));

        predicates.add(builder.equal(root.get(User.Fields.email), email));

        if (StringUtils.isNotBlank(phone))
            predicates.add(builder.equal(root.get(User.Fields.phone), email));

        query.select(root).where(builder.or(predicates.toArray(new Predicate[0])));

        TypedQuery<User> typedQuery = entityManager.createQuery(query);
        typedQuery.setMaxResults(1);

        return typedQuery.getResultList().stream().findFirst();
    }
}
