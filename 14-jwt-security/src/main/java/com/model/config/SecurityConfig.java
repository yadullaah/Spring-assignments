package com.model.config;

import com.model.security.JwtAuthenticationEntryPoint;
import com.model.security.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.beans.factory.annotation.Autowired;

@EnableMethodSecurity
@Configuration
@RequiredArgsConstructor
@AllArgsConstructor

public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private JwtAuthenticationEntryPoint authenticationEntryPoint;
	@Autowired
	private JwtAuthenticationFilter authenticationFilter;

	@Bean
	static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()).cors(withDefaults());
		http.sessionManagement(session -> session.sessionCreationPolicy(STATELESS));

		http.authorizeHttpRequests(request -> request.requestMatchers("/api/register").permitAll());
		http.authorizeHttpRequests(request -> request.requestMatchers("/api/login").permitAll());

		http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.GET, "/app/**"));
		http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.POST, "/app/**"));
		http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.PUT, "/app/**"));
		http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.DELETE, "app/**"));
		http.exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint));
		http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
		http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
		return http.build();
	}

//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	    // Disable CSRF and enable CORS with default settings
//	    http.csrf(csrf -> csrf.disable()).cors(withDefaults());
//
//	    // Set the session management policy to stateless (usually for REST APIs)
//	    http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//	    // Allow unrestricted access to the registration and login endpoints
//	    http.authorizeHttpRequests(request -> request
//	            .requestMatchers("/api/register", "/api/login").permitAll()
//	            .requestMatchers(HttpMethod.GET, "/studentapp/**").authenticated()
//	            .requestMatchers(HttpMethod.POST, "/studentapp/**").authenticated()
//	            .requestMatchers(HttpMethod.PUT, "/studentapp/**").authenticated()
//	            .requestMatchers(HttpMethod.DELETE, "/studentapp/**").authenticated()
//	            .anyRequest().authenticated()
//	    );
//
//	    // Configure exception handling for unauthorized access
//	    http.exceptionHandling(exception -> exception
//	            .authenticationEntryPoint(authenticationEntryPoint)
//	    );
//
//	    // Add the custom authentication filter before the UsernamePasswordAuthenticationFilter
//	    http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//	    return http.build();
//	}

}
