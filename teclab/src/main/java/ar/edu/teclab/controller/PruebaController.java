package ar.edu.teclab.controller;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import ar.edu.teclab.dto.AddComment_dto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.edu.teclab.dto.Ejemplo;
import ar.edu.teclab.service.PruebaService;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "*")
public class PruebaController {

    private static final Log LOG = LogFactory.getLog(PruebaController.class);

    @Autowired
    protected PruebaService pruebaService;

    @GetMapping("/ejemplo")
    public ResponseEntity<Ejemplo> getMessageStatus(@RequestParam(value = "nombre") String nombre) {
        try {
            Ejemplo ejemplo = new Ejemplo();
            ejemplo.setNombre(nombre);
            return ResponseEntity.ok(ejemplo);
        } catch (Exception e) {
            LOG.error("Error", e);
        }
        return null;
    }


    @GetMapping(value="/listComment")
    public Object GetComment() {
        try {
            String commands = "curl -X GET https://teclab1593636133.zendesk.com/api/v2/tickets/35/comments -v -u jorge.danni@teclab.edu.ar:Abril2021*";
            Process process = Runtime.getRuntime().exec(commands);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            String response = "";
            while ((line = reader.readLine()) != null) {
                response += line;
            }
            return response;
        } catch (Exception e) {
            LOG.error("Error", e);
        }
        return null;
    }


    @PutMapping("/addComment")
    public Object PostComment(@RequestBody() AddComment_dto comment) {
        try {
            URL url = new URL("https://teclab1593636133.zendesk.com/api/v2/tickets/35.json");
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestMethod("PUT");
            http.setDoOutput(true);
            http.setRequestProperty("Content-Type", "application/json");
            http.setRequestProperty("Authorization", "Basic am9yZ2UuZGFubmlAdGVjbGFiLmVkdS5hcjpBYnJpbDIwMjEq");

            String data = "{\"ticket\": {\"comment\": { \"body\": \""+comment.getBody()+"\" }}}";

            byte[] out = data.getBytes(StandardCharsets.UTF_8);

            OutputStream stream = http.getOutputStream();
            stream.write(out);

            Object info = http.getResponseMessage();
            http.disconnect();

            return info;
        }catch (Exception e) {
            LOG.error("Error", e);
        }
        return null;
    }

}


