package com.groom.manvsclass.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groom.manvsclass.model.Admin;
import com.groom.manvsclass.model.ClassUT;
import com.groom.manvsclass.model.Operation;
import com.groom.manvsclass.util.filesystem.FileOperationUtil;
import com.groom.manvsclass.util.filesystem.download.FileDownloadUtil;
import com.groom.manvsclass.util.filesystem.upload.FileUploadResponse;
import com.groom.manvsclass.util.filesystem.upload.FileUploadUtil;
import com.groom.manvsclass.model.repository.ClassRepository;
import com.groom.manvsclass.model.repository.OperationRepository;
import com.groom.manvsclass.model.repository.SearchRepositoryImpl;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ClassUTService {

    private final JwtService jwtService;
    private final OperationRepository operationRepository;
    private final ClassRepository classRepository;
    private final MongoTemplate mongoTemplate;
    private final SearchRepositoryImpl searchRepository;
    private final RobotService robotService;

    private final LocalDate today = LocalDate.now();
    private final Admin userAdmin= new Admin("default","default","default","default","default");

    public ClassUTService(JwtService jwtService,
                          OperationRepository operationRepository,
                          ClassRepository classRepository,
                          MongoTemplate mongoTemplate,
                          SearchRepositoryImpl searchRepository,
                          RobotService robotService) {
        this.jwtService = jwtService;
        this.operationRepository = operationRepository;
        this.classRepository = classRepository;
        this.mongoTemplate = mongoTemplate;
        this.searchRepository = searchRepository;
        this.robotService = robotService;
    }

    public ResponseEntity<?> getNomiClassiUT(String jwt) {
        // 1. Verifica se il token JWT è valido
        if (jwt == null || jwt.isEmpty() || !jwtService.isJwtValid(jwt)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Token JWT non valido o mancante.");
        }

        // 2. Recupera tutte le ClassUT dal repository e restituisce solo i nomi
        List<String> classNames = classRepository.findAll()
                .stream()
                .map(ClassUT::getName) // Estrae solo i nomi
                .collect(Collectors.toList());

        // 3. Ritorna i nomi delle classi con lo status HTTP 200 (OK)
        return ResponseEntity.ok(classNames);
    }

    public ResponseEntity<FileUploadResponse> uploadClassAndRobotZip(MultipartFile classUTFile, String classUTDetails, MultipartFile robotTestsZip, String jwt, HttpServletRequest request) throws IOException {
        // Se il token Jwt non è valido restituisci un errore al frontend e esci
        if (! jwtService.isJwtValid(jwt)) {
            FileUploadResponse response = new FileUploadResponse();
            response.setErrorMessage("Errore, il token non è valido");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        // Se il token è valido, verifica che i MultipartFile siano stati ricevuto con successo
        String classUTFileName;
        try {
            classUTFileName = StringUtils.cleanPath(Objects.requireNonNull(classUTFile.getOriginalFilename()));
        } catch (NullPointerException e) {
            FileUploadResponse response = new FileUploadResponse();
            response.setErrorMessage("Errore, almeno uno dei file selezionati non è stato ricevuto con successo");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        // Se i file sono stati ricevuti, procedi con il salvataggio
        ObjectMapper mapper = new ObjectMapper();
        ClassUT classe = mapper.readValue(classUTDetails, ClassUT.class);
        long size = classUTFile.getSize();

        System.out.println("Salvataggio di "+classUTFileName+"nel filestystem condiviso");
        FileUploadUtil.saveCLassFile(classUTFileName, classe.getName(), classUTFile);

        robotService.saveRobotsFromZip(classUTFileName, classe.getName(), classUTFile , robotTestsZip);

        FileUploadResponse response = new FileUploadResponse();
        response.setFileName(classUTFileName);
        response.setSize(size);
        response.setDownloadUri("/downloadFile");

        // classe.setUri("Files-Upload/" + classe.getName() + "/" + classUTFileName);
        classe.setUri(String.format("%s/%s/%s/%s", RobotService.VOLUME_T0_BASE_PATH, RobotService.UNMODIFIED_SRC, classe.getName(), classUTFileName));
        classe.setDate(today.toString());

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String data = currentDate.format(formatter);
        Operation operation1 = new Operation((int) operationRepository.count(), userAdmin.getUsername(), classe.getName() + " con Robot", 0, data);

        operationRepository.save(operation1);
        classRepository.save(classe);
        System.out.println("Operazione completata con successo (uploadTest)");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*
    public ResponseEntity<ClassUT> uploadClasse(ClassUT classe, String jwt) {
        if (jwtService.isJwtValid(jwt)) {
            System.out.println("Token valido, può inserire una nuova classe (/insert)");
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String data = currentDate.format(formatter);
            Operation operation1 = new Operation((int) operationRepository.count(), userAdmin.getUsername(), classe.getName(), 0, data);
            operationRepository.save(operation1);
            ClassUT savedClasse = classRepository.save(classe);

            System.out.println("Inserimento classe avvenuto con successo (/insert)");
            return ResponseEntity.ok().body(savedClasse);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
     */

    public List<ClassUT> ricercaClasse(@PathVariable String text) {
        return searchRepository.findByText(text);
    }

    public ResponseEntity<?> downloadClasse(@PathVariable("name") String name) throws Exception {

        System.out.println("/downloadFile/{name} (HomeController) - name: " + name);
        System.out.println("test");
        try{
            List<ClassUT> classe= searchRepository.findByText(name);
            System.out.println("File download:");
            System.out.println(classe.get(0).getcode_Uri());
            ResponseEntity file =  FileDownloadUtil.downloadClassFile(classe.get(0).getcode_Uri());
            return file;
        }
        catch(Exception e){
            System.out.println("Classe UT non trovata");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ClasseUT " + name + " non trovata");
        }
    }

    public List<ClassUT> elencaClassi() {
        return classRepository.findAll();
    }

    public ResponseEntity<List<ClassUT>> elencaClassiD(String difficulty, String jwt) {
        if (jwtService.isJwtValid(jwt)) {
            List<ClassUT> classiFiltrate = searchRepository.filterByDifficulty(difficulty);
            return ResponseEntity.ok().body(classiFiltrate);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    public ResponseEntity<List<ClassUT>> elencaClassiD(String text, String difficulty, String jwt) {
        if (jwtService.isJwtValid(jwt)) {
            List<ClassUT> classiFiltrate = searchRepository.searchAndDFilter(text, difficulty);
            return ResponseEntity.ok().body(classiFiltrate);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    public ResponseEntity<List<ClassUT>> ordinaClassi(String jwt) {
        if (jwtService.isJwtValid(jwt)) {
            List<ClassUT> classiOrdinate = searchRepository.orderByDate();
            return ResponseEntity.ok().body(classiOrdinate);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    public ResponseEntity<List<ClassUT>> ordinaClassiNomi(String jwt) {
        if (jwtService.isJwtValid(jwt)) {
            List<ClassUT> classiOrdinateNome = searchRepository.orderByName();
            return ResponseEntity.ok().body(classiOrdinateNome);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    public ResponseEntity<String> modificaClasse(String name, ClassUT newContent, String jwt, HttpServletRequest request) {
        if (jwtService.isJwtValid(jwt)) {
            System.out.println("Token valido, può aggiornare informazioni inerenti le classi (update/{name})");
            Query query = new Query();
            query.addCriteria(Criteria.where("name").is(name));
            Update update = new Update().set("name", newContent.getName())
                    .set("date", newContent.getDate())
                    .set("difficulty", newContent.getDifficulty())
                    .set("description", newContent.getDescription())
                    .set("category", newContent.getCategory());
            long modifiedCount = mongoTemplate.updateFirst(query, update, ClassUT.class).getModifiedCount();

            if (modifiedCount > 0) {
                LocalDate currentDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String data = currentDate.format(formatter);
                Operation operation1 = new Operation((int) operationRepository.count(), userAdmin.getUsername(), newContent.getName(), 1, data);
                operationRepository.save(operation1);
                return new ResponseEntity<>("Aggiornamento eseguito correttamente.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Nessuna classe trovata o nessuna modifica effettuata.", HttpStatus.NOT_FOUND);
            }
        } else {
            System.out.println("Token non valido ((update/{name}))");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errore nel completamente dell'operazione");
        }
    }

    public ResponseEntity<?> eliminaClasse(String name, String jwt) {
        if (jwtService.isJwtValid(jwt)) {
            Query query = new Query();
            query.addCriteria(Criteria.where("name").is(name));
            eliminaFile(name, jwt);
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String data = currentDate.format(formatter);
            Operation operation1 = new Operation((int) operationRepository.count(), "userAdmin", name, 2, data);
            operationRepository.save(operation1);
            ClassUT deletedClass = mongoTemplate.findAndRemove(query, ClassUT.class);
            if (deletedClass != null) {
                return ResponseEntity.ok().body(deletedClass);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Classe non trovata");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token JWT non valido");
        }
    }

    public ResponseEntity<String> eliminaFile(String fileName, String jwt) {
        if (jwtService.isJwtValid(jwt)) {
            File directory = new File(String.format("%s/%s", RobotService.VOLUME_T0_BASE_PATH, fileName));
            File directoryUnmodifiedSrc = new File(String.format("%s/%s/%s", RobotService.VOLUME_T0_BASE_PATH, RobotService.UNMODIFIED_SRC,fileName));
            File srcFolderT1 = new File(String.format("%s/%s", "Files-Upload", fileName));

            System.out.println("name: " + fileName);
            if (srcFolderT1.exists() && srcFolderT1.isDirectory()) {
                try {
                    FileOperationUtil.deleteDirectoryRecursively(srcFolderT1.toPath());
                    FileOperationUtil.deleteDirectoryRecursively(directory.toPath());
                    FileOperationUtil.deleteDirectoryRecursively(directoryUnmodifiedSrc.toPath());
                    return new ResponseEntity<>("Cartella eliminata con successo (/deleteFile/{fileName})", HttpStatus.OK);
                } catch (IOException e) {
                    return new ResponseEntity<>("Impossibile eliminare la cartella.", HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                return new ResponseEntity<>("Cartella non trovata.", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Token JWT non valido.", HttpStatus.UNAUTHORIZED);
        }
    }



}
