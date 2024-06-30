package com.nadia.nadia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nadia.nadia.entity.Commentary;
import com.nadia.nadia.repository.CommentaryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentaryService {

    @Autowired
    private CommentaryRepository commentaryRepository;

    public List<Commentary> getAllComments() {
        return commentaryRepository.findAll();
    }

    public Optional<Commentary> getCommentaryById(Long id) {
        return commentaryRepository.findById(id);
    }

    public Commentary saveCommentary(Commentary commentary) {
        return commentaryRepository.save(commentary);
    }

    public Commentary updateCommentary(Long id, Commentary commentary) {
        if (commentaryRepository.existsById(id)) {
            commentary.setId(id);
            return commentaryRepository.save(commentary);
        }
        return null;
    }

    public void deleteCommentary(Long id) {
        commentaryRepository.deleteById(id);
    }
}
