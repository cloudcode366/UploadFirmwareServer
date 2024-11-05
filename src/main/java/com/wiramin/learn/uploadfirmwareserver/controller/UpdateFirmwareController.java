package com.wiramin.learn.uploadfirmwareserver.controller;

import com.wiramin.learn.uploadfirmwareserver.entity.Firmware;
import com.wiramin.learn.uploadfirmwareserver.service.FirmwareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/update")
@CrossOrigin
public class UpdateFirmwareController {
    private final FirmwareService firmwareService;
    
    @GetMapping("/latest")
    public ResponseEntity<Firmware> latest() {
        return ResponseEntity.ok(firmwareService.getNewestFirmware());
    }
}
