package com.srg.ebankspring.Filter;

import com.srg.ebankspring.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class LoginFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {


        String authorization = request.getHeader("Authorization");

        if (authorization != null || authorization.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = authorization.substring("Bearer ".length());
        String username = jwtService.extractUsername(token);
         if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

             UserDetails userDetails = userDetailsService.loadUserByUsername(username);

             // Validate the token
             if (jwtService.isTokenValid(token, userDetails)) {

                 // Create authentication token
                 UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                         userDetails, null, userDetails.getAuthorities()
                 );

                 // authentication details
                 authToken.setDetails(
                         new WebAuthenticationDetailsSource().buildDetails(request)
                 );

                 SecurityContextHolder.getContext().setAuthentication(authToken);
             }
         }
        System.out.println("path :" + request.getRequestURI());
        System.out.println("path Servlet :" + request.getServletPath());
        filterChain.doFilter(request, response);

    }
}
