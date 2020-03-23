package com.entropy.backend.service;

import com.entropy.backend.entity.Post;
import com.entropy.backend.enumeration.CategoryType;
import com.entropy.backend.enumeration.PublishStype;
import com.entropy.backend.enumeration.StatusType;
import com.entropy.backend.repository.PostRepository;
import com.entropy.backend.rest.request.post.PostCreateReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author bac-ta
 */
@Service
public class PostService {
    private PostRepository repository;

    @Autowired
    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> findPosts(int start, int limit) {
        Pageable pageable = PageRequest.of(start, limit, Sort.by(Sort.Direction.DESC, "created"));
        return (List<Post>) repository.findAll(pageable);
    }

    public Optional<Post> findById(int id) {
        Optional<Post> optionalPost = repository.findById(id);
        return optionalPost;
    }

    public Post createPost(PostCreateReq postReq) {
        String title = postReq.getTitle();
        String content = postReq.getContent();
        String author = postReq.getAuthor();
        Integer categoryTypeInt = postReq.getCategoryType();
        CategoryType categoryType = CategoryType.findByValue(categoryTypeInt);
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setCategoryType(categoryType);
        post.setAuthor(author);
        post.setPublishStype(PublishStype.findByValue(postReq.getPublishType()));

        Post postCreated = repository.save(post);
        return postCreated;
    }

//    public void deletePost(int id){
//
//        Optional<Post> optionalPost = findById(id);
//        if (!optionalPost.isPresent())
//            repository.updatePostStatus(id, StatusType.OFF);
//    }
}
