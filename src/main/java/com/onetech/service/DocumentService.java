package com.onetech.service;



import com.onetech.entity.Document;

import java.util.List;
import java.util.Optional;

public interface DocumentService {

    Document createDocument(Document document);

    Optional<Document> getDocumentById(Long id);

    List<Document> getAllDocuments();

    Document updateDocument(Long id, Document document);

    void deleteDocument(Long id);
}
