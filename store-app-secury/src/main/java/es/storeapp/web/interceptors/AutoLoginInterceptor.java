package es.storeapp.web.interceptors;

import es.storeapp.business.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/** Legacy XMLDecoder cookie auto-login intentionally disabled. */
public class AutoLoginInterceptor implements HandlerInterceptor {
    public AutoLoginInterceptor(UserService userService) { }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return true;
    }
}
