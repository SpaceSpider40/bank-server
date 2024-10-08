package space.bank_server.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import space.bank_server.dto.user.UserCreationDTO;
import space.bank_server.entity.user.ContactInfo;
import space.bank_server.entity.user.ContactInfoType;
import space.bank_server.entity.user.User;
import space.bank_server.exceptions.user.UserCreationException;
import space.bank_server.repository.IContactInfoRepository;
import space.bank_server.repository.IUserRepository;

import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    IUserRepository userRepository;
    IContactInfoRepository contactInfoRepository; 

    /**
     * validates structure of userContactInfo json node
     * @param userContactJson json node
     * @param throwException if ture throws Exception instead of returning false
     * @throws UserCreationException Exception contain information why validation failed@param throwError
     * @return ture if object passes validation otherwise false
     */
    private static boolean validateUserContactJson(JsonNode userContactJson, boolean throwException) throws UserCreationException {

        if (!userContactJson.has("type") || !userContactJson.has("value")){
            if (throwException){
                throw new UserCreationException("Invalid user contact structure");
            } else {
                return false;
            }
        }

        //TODO: validate contents

        return true;
    }

    public User addUser(String username, String password, ContactInfo userContactInfo) throws UserCreationException {
        if (username.isEmpty()){
            throw new UserCreationException("Username cannot be empty");
        }

        if (password.isEmpty()){
            throw new UserCreationException("Password cannot be empty");
        }

        User user = new User(
                username,
                password
        );

        userRepository.save(user);
        userRepository.flush();

        userContactInfo.setUser(user);

        contactInfoRepository.save(userContactInfo);
        contactInfoRepository.flush();

        return user;
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
