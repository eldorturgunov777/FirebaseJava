package com.example.firebasejava.manager;

/**
 * Created by Eldor Turgunov on 12.07.2022.
 * Firebase Java
 * eldorturgunov777@gmail.com
 */
public interface AuthHandler {
    void onSuccess();

    void onError(Exception exception);
}
