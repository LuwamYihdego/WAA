package Lab.demo.Post.service;

import assignments.assignment3.domain.dto.request.LoginRequest;
import assignments.assignment3.domain.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);

}
