package com.lumeim.filestorage.repository;

import com.lumeim.filestorage.model.File;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Set;

public interface FileRepository extends ElasticsearchRepository<File, Long> {

}
