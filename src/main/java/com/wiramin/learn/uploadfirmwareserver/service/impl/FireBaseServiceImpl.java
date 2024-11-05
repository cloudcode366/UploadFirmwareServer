package com.wiramin.learn.uploadfirmwareserver.service.impl;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.wiramin.learn.uploadfirmwareserver.configuration.FirebaseConfig;
import com.wiramin.learn.uploadfirmwareserver.service.FireBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@RequiredArgsConstructor
public class FireBaseServiceImpl implements FireBaseService {
    private final FirebaseConfig firebaseConfig;
    
    @Override
    public String upload(File file) throws IOException {
        Storage storage = firebaseConfig.getStorage();
        Path path = file.toPath();
        byte[] bytes = Files.readAllBytes(path);
        String fileName = path.getFileName().toString();
        String BUCKET_NAME = "tripwonder-image-86819.appspot.com";
        BlobId blobId = BlobId.of(BUCKET_NAME, fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("application/octet-stream").build();
        Blob blob = storage.create(blobInfo, bytes);
        file.delete();
        String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/tripwonder-image-86819.appspot.com/o/%s?alt=media";
        return String.format(DOWNLOAD_URL, URLEncoder.encode(file.getName(), StandardCharsets.UTF_8));
    }
}
