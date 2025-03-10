package examen_interfaz.main.service;

import examen_interfaz.main.model.Item;
import examen_interfaz.main.repository.ItemRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servicio para generar reportes en PDF con JasperReports.
 */
@Service
public class ReportService {

    @Autowired
    private ItemRepository itemRepository;

    /**
     * Genera un informe en PDF con la lista de ítems.
     * @return Ruta del archivo PDF generado.
     * @throws JRException Error en la generación del reporte.
     * @throws FileNotFoundException Si el archivo JRXML no se encuentra.
     */
    public String generatePdfReport() throws JRException, IOException {
        List<Item> items = itemRepository.findAll();

        File file = new ClassPathResource("reports/items_report.jrxml").getFile();
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(items);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Examen Interfaz");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        String outputPath = "items_report.pdf";
        JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(outputPath));

        return outputPath;
    }
}


