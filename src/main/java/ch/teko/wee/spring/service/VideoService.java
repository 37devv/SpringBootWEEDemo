package ch.teko.wee.spring.service;

import ch.teko.wee.spring.model.Video;
import ch.teko.wee.spring.repository.VideoRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Video createVideo(Video video) {
        return videoRepository.save(video);
    }

    @SneakyThrows
    public Video getVideoById(Long id) {
        return videoRepository.findById(id)
                .orElseThrow(() -> new Exception("Video not found with id: " + id));
    }
}
