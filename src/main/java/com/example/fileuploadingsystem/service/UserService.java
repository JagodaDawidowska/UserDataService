package com.example.fileuploadingsystem.service;

import com.example.fileuploadingsystem.api.UserDto;
import com.example.fileuploadingsystem.data.User;
import com.example.fileuploadingsystem.data.UserRepository;
import com.example.fileuploadingsystem.exception.EmptyFileException;
import com.example.fileuploadingsystem.exception.FileExtensionException;
import com.example.fileuploadingsystem.model.SortDirection;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.fileuploadingsystem.util.FileUtil.checkIfFormatIsJson;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void uploadData(MultipartFile file) throws FileExtensionException, EmptyFileException, JsonProcessingException, IOException {
        if (file != null && !file.isEmpty()) {
            if(checkIfFormatIsJson(file)){
                byte[] byteArray = file.getBytes();
                String string = new String(byteArray, StandardCharsets.UTF_8);
                List<UserDto> parsedUsers = parseJsonToUsers(string);
                saveUsers(parsedUsers);
            } else {
                throw new FileExtensionException();
            }
        } else {
            throw new EmptyFileException();
        }
    }

    private List<UserDto> parseJsonToUsers(String jsonString) throws JsonProcessingException {
        final ObjectMapper objectMapper = new ObjectMapper();
        UserDto[] users = objectMapper.readValue(jsonString, UserDto[].class);
        return new ArrayList<>(Arrays.asList(users));
    }

    private void saveUsers(List<UserDto> userDtoList){
        List<User> users = new ArrayList<>();
        userDtoList.forEach(dto -> {
            User user = new User();
            user.setName(dto.getName());
            user.setSurname(dto.getSurname());
            user.setLogin(dto.getLogin());
            users.add(user);
        });
        userRepository.saveAll(users);
    }

    public List<UserDto> getUsers (int pageNumber, int pageSize, String searchQuery, String sortColumn, String sortDirection){
        pageNumber--; // przesuniecie numery strony o 1 wzgledem tego co wysyla FE
        PageRequest pageRequest;
        if (isNotEmpty(sortColumn) && isNotEmpty(sortDirection)) {
            Sort sort;
            if (SortDirection.ASC.getValue().equalsIgnoreCase(sortDirection)) {
                sort = Sort.by(sortColumn).ascending();
            } else {
                sort = Sort.by(sortColumn).descending();
            }
            pageRequest = PageRequest.of(pageNumber, pageSize, sort);
        } else {
            pageRequest = PageRequest.of(pageNumber, pageSize);
        }

        List<UserDto> users;
        if (isNotEmpty(searchQuery)) {
            users = userRepository.getUsersCustom(pageRequest, searchQuery).getContent();
        } else {
            users = mapUsers(userRepository.findAll(pageRequest).getContent());
        }

        users.forEach(userDto -> userDto.setSurname(modifySurname(userDto)));

        return users;
    }

    private String modifySurname (UserDto userDto) {
        return String.format("%s_%s", userDto.getSurname(), DigestUtils.md5Hex(userDto.getName()));
    }

    private List<UserDto> mapUsers (List<User> userList) {
        List<UserDto> userDtoList = new ArrayList<>();
        userList.forEach(user -> {
            userDtoList.add(new UserDto(
                    user.getName(),
                    user.getSurname(),
                    user.getLogin()
            ));
        });
        return userDtoList;
    }

    private boolean isNotEmpty (String value) {
        return value != null && !value.equals("");
    }
}