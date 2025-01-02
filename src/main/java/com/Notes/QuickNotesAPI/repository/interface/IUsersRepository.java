import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.Notes.QuickNotesAPI.model.Users;

public interface IUsersRepository {

    public Users getUsersById(int UserId);

    public List<Users> listUsers();

    public List<User> getUsersByLastNameInit(String lastNameInitial);

    public boolean AuthenticateUser(String email, String password);

}