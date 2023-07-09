package ch.teko.wee.spring.service;

import ch.teko.wee.spring.model.Comment;
import ch.teko.wee.spring.model.CommentRequest;
import ch.teko.wee.spring.model.User;
import ch.teko.wee.spring.model.Video;
import ch.teko.wee.spring.repository.CommentRepository;
import ch.teko.wee.spring.repository.UserRepository;
import ch.teko.wee.spring.repository.VideoRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    private final VideoRepository videoRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, UserRepository userRepository, VideoRepository videoRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.videoRepository = videoRepository;
    }

    @SneakyThrows
    public Comment createComment(CommentRequest commentRequest) {

        User user = userRepository.findById(commentRequest.getUserId())
                .orElseThrow(() -> new Exception("User not found with id: " + commentRequest.getUserId()));

        // Retrieve the video entity
        Video video = videoRepository.findById(commentRequest.getVideoId())
                .orElseThrow(() -> new Exception("Video not found with id: " + commentRequest.getVideoId()));

        // Create the comment
        Comment comment = new Comment();
        comment.setContent(commentRequest.getContent());
        comment.setUser(user);
        comment.setVideo(video);

        return commentRepository.save(comment);
    }

    @SneakyThrows
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new Exception("Comment not found with id: " + id));
    }
}

