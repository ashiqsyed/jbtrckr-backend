package com.ashiqsyed.jbtrckr.config;

import com.ashiqsyed.jbtrckr.model.User;
import com.ashiqsyed.jbtrckr.repository.UserRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private UserRepository userRepo;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String header = req.getHeader("Authorization");

        System.out.println("----------------------------------");
        System.out.println("Incoming request: " + req.getMethod() + " " + req.getRequestURI());
        System.out.println("Authorization header: " + req.getHeader("Authorization"));
        System.out.println("----------------------------------");
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(req, resp);
            return;
        }

        String token = header.substring(7);
        try {
            Claims claims = jwtUtility.validateToken(token);

            Object userIdObj = claims.get("userId");
            if (userIdObj == null) {

                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT");
                return;

            }

            Long userId = Long.valueOf(userIdObj.toString());
            User user = userRepo.findById(userId).orElse(null);
            if (user == null) {

                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT");
                return;
            }
            UserPrincipal principal = new UserPrincipal(user.getId(), user.getUsername(), user.getEmail());
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(principal, null, Collections.singletonList(new SimpleGrantedAuthority("USER")));
            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
            SecurityContextHolder.getContext().setAuthentication(auth);

//            System.out.println("Auth principal: " + principal.getUsername());
//            System.out.println("Auth authenticated: " + auth.isAuthenticated());
//            System.out.println("SecurityContext set " + (SecurityContextHolder.getContext().getAuthentication() != null));
        } catch (Exception e) {
            System.out.println("The JWT was not validated.");
            System.out.println(e);
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT");
            return;
        }
        chain.doFilter(req, resp);
    }
}
