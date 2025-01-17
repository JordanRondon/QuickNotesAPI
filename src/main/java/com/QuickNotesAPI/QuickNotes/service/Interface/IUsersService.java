package com.QuickNotesAPI.QuickNotes.service.Interface;

import java.util.List;

import com.QuickNotesAPI.QuickNotes.model.Users;

public interface IUsersService {

    public List<Users> getListUsers();

    public List<Users> getListUsersByLastNameInitial(String lastNameInitial);

    public Users getUserById(int userId);

    public void register(Users user);

    public String login(String email, String password);

    public void disable(int userId);

}
