package org.example.repository;

import org.example.model.Post;

import java.awt.*;

public interface PostRepository  extends GenericRepository<Label, Long> {

    Post save(Post entity);
}
