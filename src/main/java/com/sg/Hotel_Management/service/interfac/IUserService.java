package com.sg.Hotel_Management.service.interfac;

import com.sg.Hotel_Management.dto.LoginRequest;
import com.sg.Hotel_Management.dto.Response;
import com.sg.Hotel_Management.entity.User;

public interface IUserService {
    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserBookingHistory(String userId);

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String email);

}
