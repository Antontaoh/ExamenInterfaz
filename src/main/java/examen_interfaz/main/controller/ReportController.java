package examen_interfaz.main.controller;

import examen_interfaz.main.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Controlador REST para generar y descargar reportes en PDF.
 */
@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * Genera un informe en PDF con la lista de ítems y lo ofrece como descarga.
     * @return ResponseEntity con el archivo PDF adjunto.
     * @throws JRException Error en la generación del reporte.
     * @throws FileNotFoundException Si el archivo generado no se encuentra.
     */
    @GetMapping("/items")
    public ResponseEntity<InputStreamResource> generateReport() throws JRException, IOException {
        String filePath = reportService.generatePdfReport();
        File file = new File(filePath);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=items_report.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
}


