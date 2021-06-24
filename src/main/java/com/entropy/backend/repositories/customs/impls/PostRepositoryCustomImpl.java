package com.entropy.backend.repositories.customs.impls;

import com.entropy.backend.common.constants.QueryName;
import com.entropy.backend.models.enumerations.PublicationType;
import com.entropy.backend.models.enumerations.SortType;
import com.entropy.backend.models.enumerations.StatusType;
import com.entropy.backend.models.dtos.PostDto;
import com.entropy.backend.repositories.customs.PostRepositoryCustom;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional(readOnly = true)
public class PostRepositoryCustomImpl implements PostRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Map<Integer, List<PostDto>> findPosts(int sort, int start, int limit, Integer statusType, Integer publishType, Integer categoryId, String searchText) {

        Map<Integer, List<PostDto>> map = new HashMap<>();
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT post.id, post.updated, post.author, post.title, post.publish_type, post.status_type FROM post ");

        StringBuilder queryCountBuilder = new StringBuilder();
        queryCountBuilder.append("SELECT COUNT(post.id) FROM post ");

        if (categoryId != null) {
            queryBuilder.append("LEFT JOIN post_category ON post.id=post_category.post_id ");

            queryCountBuilder.append("LEFT JOIN post_category ON post.id=post_category.post_id ");
        }

        if (statusType != null || publishType != null || !StringUtils.isBlank(searchText)) {
            queryBuilder.append(" WHERE ");

            queryCountBuilder.append(" WHERE ");

            if (statusType != null) {
                String statusTypeStr = StatusType.findByValue(statusType).getName();
                queryBuilder.append("status_type='").append(statusTypeStr).append("' ");

                queryCountBuilder.append("status_type='").append(statusTypeStr).append("' ");
            }

            if (publishType != null) {
                if (statusType != null) {
                    queryBuilder.append(" AND ");
                    queryCountBuilder.append(" AND ");
                }
                String publishTypeStr = PublicationType.findByValue(publishType).getName();
                queryBuilder.append("publish_type='").append(publishTypeStr).append("' ");

                queryCountBuilder.append("publish_type='").append(publishTypeStr).append("' ");
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
        queryBuilder.append("ORDER BY post.id ").append(sortType).append(", post.updated ").append(sortType).append(" LIMIT ").
                append(start).append(",").append(limit);
        Query query = entityManager.createNativeQuery(queryBuilder.toString(), QueryName.QUERY_POST);

        Query queryCount = entityManager.createNativeQuery(queryCountBuilder.toString());
        String countStr = queryCount.getResultList().get(0).toString();

        List<PostDto> postDtoList = query.getResultList();
        map.put(Integer.parseInt(countStr), postDtoList);
        return map;
    }
}
