package ch.teko.wee.spring.controller;

import ch.teko.wee.spring.model.*;
import ch.teko.wee.spring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Dies ist in ein komplexerer Controller der  mit den Models und den Tabellen Video, User und Comment interagiert
 */

@RestController
@RequestMapping("/api")
public class YoutubeController {

    private final UserService userService;
    private final VideoService videoService;
    private final CommentService commentService;

    @Autowired
    public YoutubeController(UserService userService, VideoService videoService, CommentService commentService) {
        this.userService = userService;
        this.videoService = videoService;
        this.commentService = commentService;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/videos")
    public Video createVideo(@RequestBody Video video) {
        return videoService.createVideo(video);
    }

    @GetMapping("/videos/{id}")
    public Video getVideo(@PathVariable Long id) {
        return videoService.getVideoById(id);
    }

    @PostMapping("/comments")
    public Comment createComment(@RequestBody CommentRequest comment) {
        return commentService.createComment(comment);
    }

}

