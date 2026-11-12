package es.storeapp.web.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import java.security.SecureRandom;
import java.util.Base64;

/** CSP con nonce efimero por respuesta HTML. No reutilizar ni cachear HTML con nonce. */
public class CSPInterceptor implements HandlerInterceptor {
    private static final SecureRandom RANDOM = new SecureRandom();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        byte[] bytes = new byte[24];
        RANDOM.nextBytes(bytes);
        String nonce = Base64.getEncoder().encodeToString(bytes);
        request.setAttribute("cspNonce", nonce);
        // El atributo nonce permite el JS inline legitimo de las plantillas Thymeleaf.
        // style-src-attr conserva estilos aplicados por plugins; endurecer tras pruebas de UI.
        String policy = "default-src 'none'; "
            + "script-src 'self' 'nonce-" + nonce + "'; "
            + "script-src-attr 'none'; "
            + "style-src 'self'; style-src-elem 'self'; style-src-attr 'unsafe-inline'; "
            + "img-src 'self' data:; font-src 'self' data:; "
            + "connect-src 'self'; form-action 'self'; base-uri 'self'; "
            + "object-src 'none'; frame-src 'none'; frame-ancestors 'none'; "
            + "manifest-src 'self'; worker-src 'none'";
        response.setHeader("Content-Security-Policy", policy);
        response.setHeader("X-Content-Type-Options", "nosniff");
        response.setHeader("Referrer-Policy", "strict-origin-when-cross-origin");
        response.setHeader("X-Frame-Options", "DENY");
        response.setHeader("Cache-Control", "no-store");
        return true;
    }
}
