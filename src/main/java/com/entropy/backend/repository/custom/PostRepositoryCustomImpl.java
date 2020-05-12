package com.entropy.backend.repository.custom;

import com.entropy.backend.enumeration.PublishStype;
import com.entropy.backend.enumeration.SortType;
import com.entropy.backend.enumeration.StatusType;
import com.entropy.backend.model.dto.PostDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepositoryCustomImpl implements PostRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Map<Integer, List<PostDTO>> findPosts(int sort, int start, int limit, Integer statusType, Integer publishType, Integer categoryId, String searchText) {

        Map<Integer, List<PostDTO>> map = new HashMap<>();
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT post.id, post.updated, post.author, post.image_title, post.title, post.publish_type, post.status_type FROM post ");

        StringBuilder queryCountBuilder = new StringBuilder();
        queryCountBuilder.append("SELECT COUNT(*) FROM post ");

        if (categoryId != null) {
            queryBuilder.append("LEFT JOIN post_category ON post.id=post_category.post_id ");

            queryCountBuilder.append("LEFT JOIN post_category ON post.id=post_category.post_id ");
        }

        if (statusType != null || publishType != null || !StringUtils.isBlank(searchText)) {
            queryBuilder.append(" WHERE ");

            queryCountBuilder.append(" WHERE ");

            if (statusType != null) {
                String statusTypeStr = StatusType.findByValue(statusType).getName();
                queryBuilder.append("status_type='" + statusTypeStr + "' ");

                queryCountBuilder.append("status_type='" + statusTypeStr + "' ");
            }

            if (publishType != null) {
                if (statusType != null) {
                    queryBuilder.append(" AND ");
                    queryCountBuilder.append(" AND ");
                }
                String publishTypeStr = PublishStype.findByValue(publishType).getName();
                queryBuilder.append("publish_type='" + publishTypeStr + "' ");

                queryCountBuilder.append("publish_type='" + publishTypeStr + "' ");
            }

            if (!StringUtils.isBlank(searchText)) {
                if (statusType != null || publishType != null) {
                    queryBuilder.append(" AND ");
                    queryCountBuilder.append(" AND ");
                }
                queryBuilder.append("post.title LIKE '%").append(searchText).append("%'").
                        append(" OR post.content LIKE'%").append(searchText).append("%'");

                queryCountBuilder.append("post.title LIKE '%").append(searchText).append("%'").
                        append(" OR post.content LIKE'%").append(searchText).append("%'");

            }

        }
        String sortType = SortType.findByValue(sort).getName();
        queryBuilder.append(" ORDER BY post.id, post.updated ").append(sortType).append(" LIMIT ").
                append(start).append(",").append(limit);
        Query query = entityManager.createNativeQuery(queryBuilder.toString());
        Query queryCount = entityManager.createNamedQuery(queryCountBuilder.toString());

        List<PostDTO> postDTOList = query.getResultList();
        map.put(0, postDTOList);
        return map;
    }
}
