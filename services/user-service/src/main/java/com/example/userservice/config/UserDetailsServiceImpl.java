//package com.example.userservice.config;
//
//
//import com.example.userservice.user.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//
//@Service
//@RequiredArgsConstructor
//public class UserDetailsServiceImpl implements UserDetailsService {
//    private final UserRepository repository;
//    @Override
//    //@Transactional
//    public UserDetails loadUserByUsername(String keyclaokid) throws UsernameNotFoundException {
//        return repository.findByKeyclaokid(keyclaokid).orElseThrow(()-> new UsernameNotFoundException("the user does not exists"));
//    }
//}
