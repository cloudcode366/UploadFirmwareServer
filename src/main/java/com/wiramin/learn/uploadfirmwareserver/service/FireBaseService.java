package com.wiramin.learn.uploadfirmwareserver.service;

import java.io.File;
import java.io.IOException;

public interface FireBaseService {
    String upload(File file) throws IOException;
}
