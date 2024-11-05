package com.wiramin.learn.uploadfirmwareserver.controller;

import com.wiramin.learn.uploadfirmwareserver.entity.Firmware;
import com.wiramin.learn.uploadfirmwareserver.service.FireBaseService;
import com.wiramin.learn.uploadfirmwareserver.service.FirmwareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/storage")
@CrossOrigin
public class FirmwareStorageController {
    
    private final FireBaseService fireBaseService;
    private final FirmwareService firmwareService;
    
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") File file,
                                             @RequestParam("firmwareName") String firmwareName,
                                             @RequestParam("firmwareVersion") Double firmwareVersion,
                                             @RequestParam("description") String description) throws Exception {
        String url;
        Firmware firmware = new Firmware();
        firmware.setFirmwareName(firmwareName);
        firmware.setFirmwareVersion(firmwareVersion);
        firmware.setDescription(description);
        try {

           url = fireBaseService.upload(file);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        firmware.setFirmwareUrl(url);
        firmwareService.createFirmware(firmware);
        return ResponseEntity.ok("Upload successful");
    }
}
