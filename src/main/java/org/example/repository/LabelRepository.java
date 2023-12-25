package org.example.repository;

import org.example.model.Post;

import java.awt.*;
import java.util.Optional;

public interface LabelRepository extends GenericRepository <Label, Long> {
    Optional<org.example.model.Label> getById( Long aLong);

    org.example.model.Label save(org.example.model.Label label);

    Post save( Post entity );
}
