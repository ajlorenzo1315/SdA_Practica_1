package es.storeapp.web.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/** Allowlist for public profile images in the legacy /resources mapping. */
public final class PublicResourceGuardInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        String context = request.getContextPath();
        if (!context.isEmpty() && uri.startsWith(context)) uri = uri.substring(context.length());
        // Do not serve server.log, the embedded database, backup files or arbitrary work files.
        if (!uri.matches("/resources/[0-9]+/[A-Za-z0-9_-]+\\.(?i:png|jpg|jpeg|gif|webp)")) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return false;
        }
        response.setHeader("X-Content-Type-Options", "nosniff");
        return true;
    }
}
