package com.fsse.busmapper.api;

import com.fsse.busmapper.domain.dto.response.UserDetailsResponseDto;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserApi {
    @GetMapping("/me/details")
    public UserDetailsResponseDto getMyUserDetails(Principal principal) { //the principal as an exit point (from firebasesecurityfilter)after layers of filtering
        if (principal instanceof
                PreAuthenticatedAuthenticationToken) {
            PreAuthenticatedAuthenticationToken preAuthenticated
                    = (PreAuthenticatedAuthenticationToken) principal;
            if (preAuthenticated.getPrincipal() instanceof
                    FirebaseToken) {
                return new
                        UserDetailsResponseDto((FirebaseToken)
                        preAuthenticated.getPrincipal());
            }
        }
        return null;
    }
}
