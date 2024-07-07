package com.tonmoy.learnspring.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PdfGeneratorService {

    @Value("${file.download-dir}")
    private String downloadDir;
    public void generatePdf(String content, String filePath) throws IOException, DocumentException {
        var fileName = "test_2.pdf";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath+fileName));
        document.open();
        document.add(new Paragraph(content));
        document.close();
    }

    public Resource loadFileAsResource(String fileName) throws IOException {
        Path filePath = Paths.get(downloadDir).resolve(fileName).normalize();
        Resource resource = new UrlResource(filePath.toUri());
        if (resource.exists() && resource.isReadable()) {
            return resource;
        } else {
            throw new IOException("File not found or not readable: " + fileName);
        }
    }
}
