package com.example.demo.security;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JwtTokenProvider {
    private String jwtSecret;
    private long jwtExpirationMs = 3600000L;

    public String generateToken(Long userId, String email, Set<String> roles) {
        long exp = Instant.now().toEpochMilli() + jwtExpirationMs;
        String rolesCsv = roles == null ? "" : roles.stream().collect(Collectors.joining(","));
        String payload = userId + "|" + email + "|" + rolesCsv + "|" + exp;
        return Base64.getUrlEncoder().withoutPadding().encodeToString(payload.getBytes(StandardCharsets.UTF_8));
    }

    public boolean validateToken(String token) {
        try {
            String decoded = new String(Base64.getUrlDecoder().decode(token), StandardCharsets.UTF_8);
            String[] parts = decoded.split("\\|");
            if (parts.length < 4) return false;
            long exp = Long.parseLong(parts[3]);
            return Instant.now().toEpochMilli() < exp;
        } catch (Exception e) {
            return false;
        }
    }

    public Map<String, Object> getClaims(String token) {
        Map<String, Object> m = new HashMap<>();
        try {
            String decoded = new String(Base64.getUrlDecoder().decode(token), StandardCharsets.UTF_8);
            String[] parts = decoded.split("\\|");
            if (parts.length >= 1) m.put("userId", Long.parseLong(parts[0]));
            if (parts.length >= 2) m.put("email", parts[1]);
            if (parts.length >= 3) m.put("roles", parts[2]);
        } catch (Exception e) {
            // return empty map on error
        }
        return m;
    }

}
