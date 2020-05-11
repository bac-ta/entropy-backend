package com.entropy.backend.repository.custom;

import com.entropy.backend.enumeration.PublishStype;
import com.entropy.backend.enumeration.SortType;
import com.entropy.backend.enumeration.StatusType;
import com.entropy.backend.model.dto.PostDTO;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class PostRepositoryCustomImpl implements PostRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PostDTO> findPosts(int sort, int start, int limit, Integer statusType, Integer publishType, Integer categoryId, String searchText) {

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT post.id, post.updated, post.author, post.image_title, post.title, post.publish_type, post.status_type FROM post ");

        if (categoryId != null)
            queryBuilder.append("LEFT JOIN post_category ON post.id=post_category.post_id ");

        if (statusType != null || publishType != null || !StringUtils.isBlank(searchText)) {
            queryBuilder.append(" WHERE ");

            if (statusType != null) {
                String statusTypeStr = StatusType.findByValue(statusType).getName();
                queryBuilder.append("status_type='" + statusTypeStr + "' ");
            }
            if (publishType != null) {
                if (statusType != null)
                    queryBuilder.append(" AND ");
                String publishTypeStr = PublishStype.findByValue(publishType).getName();
                queryBuilder.append("publish_type='" + publishTypeStr + "' ");
            }
            if (!StringUtils.isBlank(searchText)) {
                if (statusType != null || publishType != null)
                    queryBuilder.append(" AND ");
                queryBuilder.append("post.title LIKE '%").append(searchText).append("%'").
                        append(" OR post.content LIKE'%").append(searchText).append("%'");

            }

        }
        String sortType = SortType.findByValue(sort).getName();
        queryBuilder.append(" ORDER BY post.id, post.updated ").append(sortType);
        Query query = entityManager.createNativeQuery(queryBuilder.toString());

        return query.getResultList();
    }
}
