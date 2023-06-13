package com.example.apitemplate.domain.user.service;


import com.example.apitemplate.domain.common.WorkType;
import com.example.apitemplate.domain.user.dao.UserDAO;
import com.example.apitemplate.domain.user.dto.UserDto;
import com.example.apitemplate.domain.user.mapper.UserMapper;
import com.example.apitemplate.domain.user.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;
    public UserVO getUserById(String id){
        UserVO userVO = userDAO.findByIdUser(id);
        return userVO;
    }
    public List<UserVO> getUsers() {
        List<UserVO> users = userDAO.findAllUsers();
        return users;
    }

    @Transactional
    public void setUsers(List<UserDto> users, String userId) {
        for (UserDto dto : users) {
            dto.setPwd(passwordEncoder.encode(dto.getPwd()));
            dto.setUdtId(userId);
            dto.setCrtId(userId);
            UserVO userVO = UserMapper.toEntity(dto);
            switch (dto.getWrkTp()) {
                case C:
                    userDAO.insert(userVO);
                    System.out.println(WorkType.C);
                    break;
                case U:
                    userDAO.update(userVO);
                    System.out.println(WorkType.U);
                    break;
                case D:
                    userDAO.delete(userVO);
                    System.out.println(WorkType.D);
                    break;
            }
        }
    }

    public void updateLoginInfo(String usrId){
        userDAO.updateLoginInfo(usrId);
    }
    public boolean isPasswordMatches(String password, String storedPassword){
        return passwordEncoder.matches(password, storedPassword);
    }
}
