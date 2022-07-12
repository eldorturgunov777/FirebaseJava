package com.example.firebasejava.manager;

import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Eldor Turgunov on 12.07.2022.
 * Firebase Java
 * eldorturgunov777@gmail.com
 */
public class AuthManager {
    static FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    static FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

    public static boolean isSignedIn() {
        return firebaseUser != null;
    }

    public static void signIn(String email, String password, AuthHandler handler) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                handler.onSuccess();
            } else {
                handler.onError(task.getException());
            }
        });
    }

    public static void signUp(String email, String password, AuthHandler handler) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                handler.onSuccess();
            } else {
                handler.onError(task.getException());
            }
        });
    }

    public static void signUot() {
        firebaseAuth.signOut();
    }
}
