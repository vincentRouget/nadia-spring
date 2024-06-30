package com.nadia.nadia.controller;

import com.nadia.nadia.entity.Commentary;
import com.nadia.nadia.services.CommentaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/commentary")
public class CommentaryController {

    @Autowired
    private CommentaryService commentaryService;

    @GetMapping
    public List<Commentary> getAllComments() {
        return commentaryService.getAllComments();
    }

    @GetMapping("/{id}")
    public Optional<Commentary> getCommentaryById(@PathVariable Long id) {
        return commentaryService.getCommentaryById(id);
    }

    @PostMapping
    public Commentary createCommentary(@RequestBody Commentary commentary) {
        return commentaryService.saveCommentary(commentary);
    }

    @PutMapping("/{id}")
    public Commentary updateCommentary(@PathVariable Long id, @RequestBody Commentary commentary) {
        return commentaryService.updateCommentary(id, commentary);
    }

    @DeleteMapping("/{id}")
    public void deleteCommentary(@PathVariable Long id) {
        commentaryService.deleteCommentary(id);
    }
}
