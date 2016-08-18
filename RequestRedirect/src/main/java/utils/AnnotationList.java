package utils;

import annotations.ClassAnnotation;
import annotations.MethodAnnotation;
import org.apache.log4j.Logger;
import requestHandlers.GetRequestHandler;
import requestInterface.HandlerInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class AnnotationList {


    private static final Logger logger = Logger.getLogger(GetRequestHandler.class);
    private List<Class> allClasses;
    private Map<String, Object> objectMap;
    public AnnotationList(List<Class> allClasses, Map<String, Object> objectMap) {
        this.allClasses = allClasses;
        this.objectMap = objectMap;
    }

    public void checkTheClassAnnotations(HttpServletRequest request, HttpServletResponse resp) {
        logger.info("Class check");
        String array[] = request.getServletPath().split("/");
        String pathPart = array[1];
        String methodPart = array[2];
        for (Class clazz : allClasses) {
            if (clazz.isAnnotationPresent(ClassAnnotation.class)) {

                Annotation annotation = clazz.getAnnotation(ClassAnnotation.class);
                ClassAnnotation ann = (ClassAnnotation) annotation;
                logger.info(pathPart + " compare to " + ann.requestClassUrl());
                if (pathPart.equals(ann.requestClassUrl())) {
                    checkMethods(request, resp, clazz, methodPart);
                }
            }
        }
    }

    public void checkMethods(HttpServletRequest request, HttpServletResponse resp, Class clazz, String methodPart) {
        logger.info("check methods");

        for (Method method : clazz.getDeclaredMethods()) {

            if (method.isAnnotationPresent(MethodAnnotation.class)) {

                Annotation annotation = method.getAnnotation(MethodAnnotation.class);
                MethodAnnotation methodAnnotation = (MethodAnnotation) annotation;
                logger.info(methodPart + " compare to " + methodAnnotation.requestUrl());
                logger.info(methodPart.equals(methodAnnotation.requestUrl()) &&
                        request.getMethod().equals(methodAnnotation.method()));
                if (methodPart.equals(methodAnnotation.requestUrl()) &&
                        request.getMethod().equals(methodAnnotation.method())) {
                    try {

                        HandlerInterface o = (HandlerInterface) objectMap.get(clazz.getName());
                        method.setAccessible(true);
                        method.invoke(o, request, resp);

                    } catch (InvocationTargetException x) {
                        logger.error("Error while invoking method");
                    } catch (IllegalAccessException e) {
                        logger.error("Error Illegal Access");
                    }
                }
            }
        }
    }
}