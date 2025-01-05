package com.QuickNotesAPI.QuickNotes.service.Interface;

import java.util.List;

import com.QuickNotesAPI.QuickNotes.model.Users;

public interface IUsersService {

    public List<Users> getListUsers();

    public Users getUserById(int userId);

}
