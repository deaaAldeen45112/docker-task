# Video Streaming System

## Overview

This repository contains a containerized video streaming system using Docker and Docker Compose. The system is designed with microservices to handle video uploads, streaming, authentication, and storage.

## Architecture Overview

The system consists of the following microservices:

- **Upload Video Service**: Allows users to upload videos after authentication. Stores video metadata in MySQL and the file itself through the File System Service.
- **Video Streaming Service**: Enables users to view videos after authentication. Fetches video metadata from MySQL and retrieves video files from the File System Service.
- **Authentication Service**: Validates user credentials.
- **File System Service**: Manages file storage and retrieval (local file system or cloud storage like AWS S3).
- **MySQL DB Service**: Stores video metadata including file paths/URLs.

## Documentation
A full project report is available in `docker_report.pdf`. 

## Video Presentation
A video presentation demonstration of the project setup is available on YouTube:  
[Watch the Video Presentation](https://www.youtube.com/watch?v=7uDP1g6dvRk&t=1s)
