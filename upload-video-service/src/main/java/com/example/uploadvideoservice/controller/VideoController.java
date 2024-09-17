package com.example.uploadvideoservice.controller;

import com.example.uploadvideoservice.model.Video;
import com.example.uploadvideoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;
    private final RestTemplate restTemplate;

    @Value("${file.server.url}")
    private String fileServerUrl;

    @Autowired
    public VideoController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/video/create")
    public ResponseEntity<String> createVideo(
            @RequestParam("videoName") String videoName,
            @RequestParam("videoAuthor") String videoAuthor,
            @RequestParam("videoDescription") String videoDescription,
            @RequestParam("videoFile") MultipartFile videoFile) {

        String originalFileName = videoFile.getOriginalFilename();
        String uniqueFileName = UUID.randomUUID().toString() + "_" + originalFileName;

        try {

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("file", new ByteArrayResource(videoFile.getBytes()) {
                @Override
                public String getFilename() {
                    return uniqueFileName;
                }
            });

           ResponseEntity<String> response = restTemplate.postForEntity(fileServerUrl, body, String.class);
            if (response.getStatusCode().is2xxSuccessful()) {
            Video video = new Video();
            video.setFilename(videoName);
            video.setPath(uniqueFileName);
            video.setAuthor(videoAuthor);
            video.setDescription(videoDescription);
            video.setFilesize(videoFile.getSize());
            videoRepository.save(video);
                return ResponseEntity.ok("Video uploaded and metadata saved successfully: " + uniqueFileName);
            } else {
                return ResponseEntity.status(500).body("Error occurred while uploading the file to the file server.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error occurred while processing the file.");
        }
    }
}