package com.lumeim.filestorage.service;

import com.lumeim.filestorage.model.File;
import com.lumeim.filestorage.repository.FileRepository;
import org.elasticsearch.monitor.StatusInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    private final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public StatusInfo.Status upload(File file) {
        if (file == null || file.getName().isEmpty() || file.getSize() < 0) {
            return StatusInfo.Status.valueOf("400");
        } else {
            fileRepository.save(file);
            return StatusInfo.Status.valueOf("200");
        }
    }

    public StatusInfo.Status delete(Long id) {
        if (fileRepository.existsById(id)) {
            fileRepository.deleteById(id);
            return StatusInfo.Status.valueOf("200");
        } else {
            return StatusInfo.Status.valueOf("400");
        }
    }

    public StatusInfo.Status assignTags(Long id, String... tags) {
        if (fileRepository.existsById(id)) {
            //adding tags
            return StatusInfo.Status.valueOf("200");
        } else {
            return StatusInfo.Status.valueOf("400");
        }
    }

    public StatusInfo.Status removeTags(Long id, String...tags) {
        if (fileRepository.existsById(id)) {
            //removing tags
            return StatusInfo.Status.valueOf("200");
        } else {
            return StatusInfo.Status.valueOf("400");
        }
    }

    public StatusInfo.Status showFilesByTags(String... tags) {
        //filtering files by tags
        return StatusInfo.Status.valueOf("200");
    }
}
