package com.ztest.boot.mvc.common.interceptor;

import com.ztest.boot.mvc.common.Permission;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/7/6 0006 51
 */
public class PermissionInterceptor extends HandlerInterceptorAdapter {

    public static final String NOT_PERMISSION_METHOD = "NPM";
    private static final ConcurrentHashMap<Method, String> methodPermissionCache = new ConcurrentHashMap<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();

            // 方法解析
            String permission = methodPermissionCache.get(method);
            if (null == permission) {
                Permission annotationPermission = method.getAnnotation(Permission.class);
                if (annotationPermission == null) {
                    permission = NOT_PERMISSION_METHOD;
                } else {
                    if (StringUtils.hasText(annotationPermission.value())) {
                        permission = annotationPermission.value();
                    } else {
                        permission = NOT_PERMISSION_METHOD;
                    }
                }

                methodPermissionCache.put(method, permission);
            }

            // 校验
            if (!NOT_PERMISSION_METHOD.equals(permission)) {
//                System.out.println("@Permission: check " + method.getName());
            } else {
//                System.out.println("@Permission: unCheck " + method.getName());
            }
        }

        return true;
    }

}
