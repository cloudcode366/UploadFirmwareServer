package com.wiramin.learn.uploadfirmwareserver.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.cloud.storage.Storage;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class FirebaseConfig {
    private final Storage storage;

    public FirebaseConfig() throws IOException {
        Map<String, Object> firebaseConfig = new HashMap<>();
        firebaseConfig.put("type", "service_account");
        firebaseConfig.put("project_id", System.getenv("FIREBASE_PROJECT_ID"));
        firebaseConfig.put("private_key_id", System.getenv("FIREBASE_PRIVATE_KEY_ID"));
        firebaseConfig.put("private_key", System.getenv("FIREBASE_PRIVATE_KEY").replace("\\n", "\n"));
        firebaseConfig.put("client_email", System.getenv("FIREBASE_CLIENT_EMAIL"));
        firebaseConfig.put("client_id", System.getenv("FIREBASE_CLIENT_ID"));
        firebaseConfig.put("auth_uri", System.getenv("FIREBASE_AUTH_URI"));
        firebaseConfig.put("token_uri", System.getenv("FIREBASE_TOKEN_URI"));
        firebaseConfig.put("auth_provider_x509_cert_url", System.getenv("FIREBASE_AUTH_PROVIDER_CERT_URL"));
        firebaseConfig.put("client_x509_cert_url", System.getenv("FIREBASE_CLIENT_CERT_URL"));
        String jsonConfig = new ObjectMapper().writeValueAsString(firebaseConfig);
        GoogleCredentials credentials = GoogleCredentials.fromStream(new ByteArrayInputStream(jsonConfig.getBytes()));

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(credentials)
                .setProjectId(System.getenv("FIREBASE_PROJECT_ID"))
                .build();

        FirebaseApp.initializeApp(options);
        storage = StorageOptions.newBuilder().setCredentials(credentials).setProjectId(System.getenv("FIREBASE_PROJECT_ID")).build().getService();
    }
    @Bean
    public Storage getStorage() {
        return storage;
    }
}
