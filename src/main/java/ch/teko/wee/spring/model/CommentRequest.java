package ch.teko.wee.spring.model;

public class CommentRequest {

    private String content;
    private Long userId;
    private Long videoId;

    public CommentRequest(String content, Long userId, Long videoId) {
        this.content = content;
        this.userId = userId;
        this.videoId = videoId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }
}