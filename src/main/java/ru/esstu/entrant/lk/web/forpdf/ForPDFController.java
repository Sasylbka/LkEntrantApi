package ru.esstu.entrant.lk.web.forpdf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.services.forpdf.DocxGeneratorService;
import ru.esstu.entrant.lk.services.forpdf.DocxGeneratorServiceTest;

import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j

public class ForPDFController {
    private final DocxGeneratorServiceTest docxGeneratorServiceTest;
    private final DocxGeneratorService docxGeneratorService;

    public ForPDFController(DocxGeneratorService docxGeneratorService, DocxGeneratorServiceTest docxGeneratorServiceTest) {
        this.docxGeneratorServiceTest = docxGeneratorServiceTest;
        this.docxGeneratorService = docxGeneratorService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/getDoc.pdf")
    public void get(final int id, HttpServletResponse response) throws Exception {
        byte [] result = docxGeneratorService.generateDocxFileFromTemplate(id);
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "filename=\"file.pdf\"");
        response.getOutputStream().write(result);
    }
    @RequestMapping(method = RequestMethod.GET, path = "/getDoc")
    public void getDocx(final int id, HttpServletResponse response) throws Exception {
        byte[] result;
        result = docxGeneratorServiceTest.generateDocxFileFromTemplate(id);
        response.setHeader("Content-Disposition", "attachment; filename=\"message.docx\"");
        response.getOutputStream().write(result);
    }
}
