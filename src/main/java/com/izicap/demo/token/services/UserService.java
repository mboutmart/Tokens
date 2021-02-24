package com.izicap.demo.token.services;

import com.izicap.demo.token.entities.Token;
import com.izicap.demo.token.entities.User;
import com.izicap.demo.token.errors.ConflictException;
import com.izicap.demo.token.errors.ForbiddenException;
import com.izicap.demo.token.errors.UnauthorizedException;
import com.izicap.demo.token.repositories.TokenRepository;
import com.izicap.demo.token.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UserRepository userRepository;

    public User createUser(String tokenString, String username, String password) {

        // retrieve mathcing token from db
        List<Token> token = tokenRepository.findTokenByToken(tokenString);

        if (token.size() == 0) {
            throw new UnauthorizedException();
        }

        if (token.get(0).getUser().getUserName().equals("admin")) {
            if (userRepository.findUserByUserName(username).size() > 0) {
                throw new ConflictException();
            }
            return userRepository.save(User.builder().userName(username).password(password).build());
        }
        throw new ForbiddenException();
    }

    public List<User> all() {
        Specification alwaysTrue = (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.conjunction();

        return userRepository.findAll(alwaysTrue);
    }
}
