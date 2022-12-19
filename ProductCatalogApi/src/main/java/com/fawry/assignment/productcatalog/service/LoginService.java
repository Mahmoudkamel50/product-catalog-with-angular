package com.fawry.assignment.productcatalog.service;

import com.fawry.assignment.productcatalog.dto.request.LoginDto;
import com.fawry.assignment.productcatalog.repository.entity.Login;
import com.fawry.assignment.productcatalog.repository.LoginRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Login addLogin(Login login) {
        return this.loginRepository.save(login);
    }

    public boolean login(LoginDto loginDto){
        Login login = this.loginRepository.findByUserName(loginDto.getUserName()).orElseThrow()
                ;
        if (login.getPassword().equals(loginDto.getPass())) return true;
        else return false;
    }
}
