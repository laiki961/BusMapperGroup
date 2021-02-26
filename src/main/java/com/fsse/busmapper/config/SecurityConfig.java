package com.fsse.busmapper.config;

import com.fsse.busmapper.FirebaseSecurityFilter;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends
        WebSecurityConfigurerAdapter {
    @Autowired
    private FirebaseSecurityFilter firebaseSecurityFilter;

    public SecurityConfig(FirebaseSecurityFilter firebaseSecurityFilter) {
        this.firebaseSecurityFilter = firebaseSecurityFilter;
    }

    @PostConstruct
    public void initFirebase() throws IOException {
        InputStream serviceAccount = new
                ClassPathResource("firebase_config.json").getInputStream();
        Object viceAccount;
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        FirebaseApp.initializeApp(options);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .httpBasic().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(firebaseSecurityFilter,
                        UsernamePasswordAuthenticationFilter.class)
                .csrf().disable();
    }
}