package com.example.apitemplate.domain.auth.service;

import com.example.apitemplate.domain.auth.dao.AuthDao;
import com.example.apitemplate.domain.auth.dto.AuthDto;
import com.example.apitemplate.domain.auth.dto.CustomUserDetails;
import com.example.apitemplate.domain.auth.dto.LoginDto;
import com.example.apitemplate.domain.auth.mapper.AuthMapper;
import com.example.apitemplate.domain.auth.vo.AuthVO;
import com.example.apitemplate.domain.common.WorkType;
import com.example.apitemplate.domain.user.service.UserService;
import com.example.apitemplate.domain.user.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    private final AuthDao authDao;
    private final UserService userService;
    private final AuthenticationManagerBuilder authBuilder;

    public String login(LoginDto loginDto) {
        UserVO userVO = userService.getUserById(loginDto.getUsrId());
        boolean matches = userService.isPasswordMatches(loginDto.getPwd(), userVO.getPwd());
        if (!matches) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return null;
        }
        userService.updateLoginInfo(userVO.getUsrId());
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginDto.getUsrId(), loginDto.getPwd());
        Authentication auth = generateAuthentication(authToken);
        storeAuthenticationInSession(auth);
        System.out.println(userVO);
        System.out.println(userVO.getUsrId());
        return userVO.getUsrId();
    }

    private Authentication generateAuthentication(UsernamePasswordAuthenticationToken authToken) {
        return authBuilder.getObject().authenticate(authToken);
    }

    private void storeAuthenticationInSession(Authentication authentication) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVO userVo = userService.getUserById(username);
        UserDetails userDetails = new CustomUserDetails(userVo);
        return userDetails;
    }

    public List<AuthVO> getAuths() {
        List<AuthVO> auths = authDao.findAllAuths();
        return auths;
    }

    @Transactional
    public void setAuths(List<AuthDto> auths, String userId) {
        for (AuthDto dto : auths) {
            dto.setUdtId(userId);
            dto.setCrtId(userId);
            AuthVO authVO = AuthMapper.toEntity(dto);
            switch (dto.getWrkTp()) {
                case C:
                    authDao.insert(authVO);
                    System.out.println(WorkType.C);
                    break;
                case U:
                    authDao.update(authVO);
                    System.out.println(WorkType.U);
                    break;
                case D:
                    authDao.delete(authVO);
                    System.out.println(WorkType.D);
                    break;
            }
        }
    }
}
