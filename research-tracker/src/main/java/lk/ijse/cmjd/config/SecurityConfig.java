package lk.ijse.cmjd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/register", "/css/**", "/js/**", "/images/**").permitAll() // public pages
                .anyRequest().authenticated() // protect other URLs
                )
                .formLogin(form -> form
                .loginPage("/login") // tell Spring to use your custom login.html
                .defaultSuccessUrl("/dashboard", true) // redirect after login
                .permitAll()
                )
                .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                );

        return http.build();
    }
}
