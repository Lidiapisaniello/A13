package com.groom.manvsclass.controller;

import com.groom.manvsclass.model.ClassUT;
import com.groom.manvsclass.service.RobotService;
import com.groom.manvsclass.util.filesystem.upload.FileUploadResponse;
import com.groom.manvsclass.service.ClassUTService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@Controller
public class ClassUTController {

    private final ClassUTService classUTService;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ClassUTController.class.getName());

    public ClassUTController(ClassUTService classUTService) {
        this.classUTService = classUTService;
    }

    @GetMapping("/elencoNomiClassiUT")
    public ResponseEntity<?> getNomiClassiUT(@CookieValue(name = "jwt", required = false) String jwt){
        return classUTService.getNomiClassiUT(jwt);
    }

    @GetMapping("/home")
    @ResponseBody
    public ResponseEntity<List<ClassUT>> elencaClassi(@CookieValue(name = "jwt", required = false) String jwt) {
        System.out.println("(/home) visualizzazione delle classi di gioco");
        List<ClassUT> classi = classUTService.elencaClassi();
        return ResponseEntity.ok().body(classi);
    }

    @GetMapping("/downloadFile/{name}")
    @ResponseBody
    public ResponseEntity<?> downloadClasse(@PathVariable("name") String name) {
        try {
            return classUTService.downloadClasse(name);
        } catch (Exception e) {
            // Gestisci l'eccezione e ritorna una risposta appropriata
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Errore nel download della classe: " + e.getMessage());
        }
    }

    @PostMapping("/uploadrobots")
    @ResponseBody
    public ResponseEntity<FileUploadResponse> uploadClassAndRobotZip(
            @RequestParam("classUTFile") MultipartFile classUTFile,
            @RequestParam("classUTDetails") String classUTDetails,
            @RequestParam("robotTestsZip") MultipartFile robotTestsZip,
            @CookieValue(name = "jwt", required = false) String jwt,
            HttpServletRequest request
    ) throws IOException {
        return classUTService.uploadClassAndRobotZip(classUTFile, classUTDetails, robotTestsZip, jwt, request);
    }

    @PostMapping("/update/{name}")
    @ResponseBody
    public ResponseEntity<String> modificaClasse(@PathVariable String name, @RequestBody ClassUT newContent, @CookieValue(name = "jwt", required = false) String jwt, HttpServletRequest request) {
        return classUTService.modificaClasse(name, newContent, jwt, request);
    }

    @GetMapping("/home/{text}")
    @ResponseBody
    public List<ClassUT> ricercaClasse(@PathVariable String text) {
        return classUTService.ricercaClasse(text);
    }

    @PostMapping("/delete/{name}")
    @ResponseBody
    public ResponseEntity<?> eliminaClasse(@PathVariable String name, @CookieValue(name = "jwt", required = false) String jwt) {
        return classUTService.eliminaClasse(name, jwt);
    }

    @GetMapping("/Dfilterby/{difficulty}")
    @ResponseBody
    public ResponseEntity<List<ClassUT>> elencaClassiD(@PathVariable String difficulty, @CookieValue(name = "jwt", required = false) String jwt) {
        return classUTService.elencaClassiD(difficulty, jwt);
    }

    @GetMapping("/Dfilterby/{text}/{difficulty}")
    @ResponseBody
    public ResponseEntity<List<ClassUT>> elencaClassiD(@PathVariable String text, @PathVariable String difficulty, @CookieValue(name = "jwt", required = false) String jwt) {
        return classUTService.elencaClassiD(text, difficulty, jwt);
    }

    @GetMapping("/orderbydate")
    @ResponseBody
    public ResponseEntity<List<ClassUT>> ordinaClassi(@CookieValue(name = "jwt", required = false) String jwt) {
        return classUTService.ordinaClassi(jwt);
    }

    @GetMapping("/orderbyname")
    @ResponseBody
    public ResponseEntity<List<ClassUT>> ordinaClassiNomi(@CookieValue(name = "jwt", required = false) String jwt) {
        return classUTService.ordinaClassiNomi(jwt);
    }





     /*
    @PostMapping("/insert")
    @ResponseBody
    public ResponseEntity<ClassUT> uploadClasse(@RequestBody ClassUT classe, @CookieValue(name = "jwt", required = false) String jwt) {
        return uploadService.uploadClasse(classe, jwt);
    }

     */

    /*
    @PostMapping("/deleteFile/{fileName}")
    @ResponseBody
    public ResponseEntity<String> eliminaFile(@PathVariable String fileName, @CookieValue(name = "jwt", required = false) String jwt) {
        return uploadService.eliminaFile(fileName, jwt);
    }

     */
}
