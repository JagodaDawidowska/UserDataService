package com.example.fileuploadingsystem.api;

import com.example.fileuploadingsystem.exception.EmptyFileException;
import com.example.fileuploadingsystem.exception.FileExtensionException;
import com.example.fileuploadingsystem.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @CrossOrigin
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            userService.uploadData(file);
            return ResponseEntity.ok().body("Wczytywanie danych zakonczone powodzeniem");
        } catch (FileExtensionException e) {
            return ResponseEntity.badRequest().body("Plik nie jest w formacie JSON");
        } catch (JsonProcessingException e) {
            return ResponseEntity.badRequest().body("Blad parsowania pliku JSON");
        } catch (EmptyFileException | IOException e) {
            return ResponseEntity.internalServerError().body("Wystapil problem z zapisaniem pliku");
        }
    }

    @CrossOrigin
    @GetMapping()
    public List<UserDto> getUsers(@RequestParam() int pageNumber,
                                  @RequestParam() int pageSize,
                                  @RequestParam(required = false) String searchQuery,
                                  @RequestParam(required = false) String sortColumn,
                                  @RequestParam(required = false) String sortDirection) {
        return userService.getUsers(pageNumber, pageSize, searchQuery, sortColumn, sortDirection);
    }
}