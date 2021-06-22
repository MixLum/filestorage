package com.lumeim.filestorage.controller;

import com.lumeim.filestorage.model.File;
import com.lumeim.filestorage.service.FileService;
import org.elasticsearch.monitor.StatusInfo;
import org.springframework.stereotype.Controller;

@Controller
public class FileController {
    private FileService fileService;

    public StatusInfo.Status upload(File file) {
        return fileService.upload(file);
    }

    public StatusInfo.Status delete(Long id) {
        return fileService.delete(id);
    }

    public StatusInfo.Status assignTags(Long id, String...tags) {
        return fileService.assignTags(id, tags);
    }

    public StatusInfo.Status removeTags(Long id, String... tags) {
        return fileService.removeTags(id, tags);
    }

    public StatusInfo.Status showFilesByTags(String... tags) {
        return fileService.showFilesByTags(tags);
    }
}
