package com.tonmoy.learnspring.controller;

import com.itextpdf.text.DocumentException;
import com.tonmoy.learnspring.service.PdfGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/files")
public class FileController {

    private final PdfGeneratorService pdfGenerationService;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @GetMapping("/generate-pdf")
    public String generatePdf() {
        try {
            pdfGenerationService.generatePdf( getContent(), uploadDir);
            return "PDF generated successfully at " + uploadDir;
        } catch (IOException | DocumentException e) {
            return "Error generating PDF: " + e.getMessage();
        }
    }

    @GetMapping("/download-pdf")
    public ResponseEntity<Resource> downloadPdf(@RequestParam String fileName) {
        try {
            Resource resource = pdfGenerationService.loadFileAsResource(fileName);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (IOException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    private String getContent() {
        return "This is a pdf!!";
    }
}
