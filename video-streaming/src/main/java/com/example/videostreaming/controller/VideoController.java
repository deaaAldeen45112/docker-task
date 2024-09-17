package com.example.videostreaming.controller;

import com.example.videostreaming.model.Video;
import com.example.videostreaming.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping("/getAllVideos")
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
}