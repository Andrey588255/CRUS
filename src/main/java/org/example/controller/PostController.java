package org.example.controller;

import org.example.model.Label;
import org.example.model.Post;
import org.example.model.Status;
import org.example.repository.LabelRepository;
import org.example.repository.PostRepository;
import org.example.service.PostService;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;
    private final LabelRepository labelRepository;
    public Optional<org.example.model.Label> get(Long id) {
        return postRepository.getById(id);
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    public Post saveWithLabels(Post p, List<Long> labelsId) {
        return postService.saveWithLabels(p, labelsId);
    }



    public boolean checkLabelStatus(Long id) {
        Optional<Label> label = labelRepository.getById(id);
        return label.map(value -> value.getStatus().equals(Status.ACTIVE)).orElse(false);
    }

    public boolean checkIfPostExists(Long id) { return postRepository.checkIfExists(id); }

    public List<Label> findAll() {
        return postRepository.findAll().stream()
                .filter(p -> p.getStatus().equals(Status.ACTIVE))
                .collect(Collectors.toList());
    }

    public Post saveWithLabels( Label label, List<Long> updatedLabels ) {
        return null;
    }

    public Post create( Long aLong, String string ) {
        return null;
    }
}