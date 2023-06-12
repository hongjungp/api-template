package com.example.apitemplate.domain.user.service;


import com.example.apitemplate.domain.common.WorkType;
import com.example.apitemplate.domain.user.dao.UserDAO;
import com.example.apitemplate.domain.user.dto.UserDto;
import com.example.apitemplate.domain.user.mapper.UserMapper;
import com.example.apitemplate.domain.user.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDAO userDAO;

    public List<UserVO> getUsers() {
        List<UserVO> users = userDAO.findAllUsers();
        return users;
    }

    @Transactional
    public void setUsers(List<UserDto> users) {
        for (UserDto dto : users) {
            UserVO userVO = UserMapper.toEntity(dto);
            System.out.println(userVO);
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
}
