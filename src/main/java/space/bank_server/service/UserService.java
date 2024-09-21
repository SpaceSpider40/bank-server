package space.bank_server.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import space.bank_server.entity.user.ContactInfo;
import space.bank_server.entity.user.ContactInfoType;
import space.bank_server.entity.user.User;
import space.bank_server.exceptions.user.UserCreationException;
import space.bank_server.repository.IUserRepository;

@Service
@AllArgsConstructor
public class UserService {

    IUserRepository userRepository;

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

        return true;
    }

    public void addUser(String username, String password, JsonNode userContactInfo) throws UserCreationException {
        if (username.isEmpty()){
            throw new UserCreationException("Username cannot be empty");
        }

        if (password.isEmpty()){
            throw new UserCreationException("Password cannot be empty");
        }

        validateUserContactJson(userContactInfo, true);

        User user = new User(
                username,
                password
        );

        ContactInfo contactInfo = new ContactInfo(
                ContactInfoType.valueOf(userContactInfo.get("type").asText()),
                userContactInfo.get("value").asText(),
                user
        );
    }
}
