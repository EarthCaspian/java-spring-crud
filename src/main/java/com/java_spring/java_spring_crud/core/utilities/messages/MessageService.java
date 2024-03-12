package com.java_spring.java_spring_crud.core.utilities.messages;

public interface MessageService {

    String getMessage(String keyword);
    String getMessageWithParams(String keyword, Object...params);
}
