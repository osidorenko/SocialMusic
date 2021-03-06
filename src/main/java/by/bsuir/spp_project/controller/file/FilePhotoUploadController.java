package by.bsuir.spp_project.controller.file;


import by.bsuir.spp_project.dao.files.PictureRepository;
import by.bsuir.spp_project.entity.files.Picture;
import by.bsuir.spp_project.service.fileupload.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Controller
public class FilePhotoUploadController {


    private final StorageService storageService;

    private PictureRepository pictureRepository;

    @Autowired
    public FilePhotoUploadController(
            @Qualifier("filePhotoUploadStrorageService") StorageService storageService,
            @Qualifier("pictureRepository") PictureRepository pictureRepository) {
        this.storageService = storageService;
        this.pictureRepository = pictureRepository;
    }

    @PostMapping("/app/upload/photo")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            Set<String> set = new HashSet<String>();
            storageService.save(file);

            /*String url = MvcUriComponentsBuilder
                    .fromMethodName(FilePhotoUploadController.class, "getFile", path.getFileName().toString()).build().toString();*/
            /*int id = (int) pictureRepository.count() + 1;*/
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            /*pictureRepository.save(new Picture(id, file.getOriginalFilename()));*/
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/app/files/photo")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilePhotoUploadController.class, "getFile", path.getFileName().toString()).build().toString();
            return new FileInfo(filename, url);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/app/files/photo/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        if (file == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return (ResponseEntity<Resource>) ResponseEntity.ok()
                //todo httpheader make and read about headers
                .header("Content-type", "image/png")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

}
