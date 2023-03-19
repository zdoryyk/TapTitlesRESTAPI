package ua.zdoryk.TapTitlesRESTAPI.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.zdoryk.TapTitlesRESTAPI.models.Comment;
import ua.zdoryk.TapTitlesRESTAPI.services.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> commentList(){
        return commentService.getAll();
    }

    @GetMapping("/comment")
    public Comment findUserByName(String name)
    {
        return commentService.getCommentByPlayerName(name);
    }

    @PostMapping("/add")
    public void addComment(Comment comment){
        commentService.addComment(comment);
    }


}
