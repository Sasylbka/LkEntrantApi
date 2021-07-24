package ru.esstu.entrant.lk.web.forpdf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.FileDto;
import ru.esstu.entrant.lk.services.FileService;
import ru.esstu.entrant.lk.services.forpdf.DocxGeneratorService;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.List;

@RestController
@Slf4j

public class ForPDFController {
    private final DocxGeneratorService docxGeneratorService;

    public ForPDFController( DocxGeneratorService docxGeneratorService) {
        this.docxGeneratorService = docxGeneratorService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/getDoc")
    public void get(final int id, HttpServletResponse response) throws Exception {
        byte[] result;
        result = docxGeneratorService.generateDocxFileFromTemplate(id);
        response.setHeader("Content-Disposition", "attachment; filename=\"message.docx\"");
        response.getOutputStream().write(result);
    }
}
