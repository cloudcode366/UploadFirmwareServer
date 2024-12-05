package com.wiramin.learn.uploadfirmwareserver.controller;

import com.wiramin.learn.uploadfirmwareserver.entity.Firmware;
import com.wiramin.learn.uploadfirmwareserver.service.FirmwareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/update")
@CrossOrigin
public class UpdateFirmwareController {
    private final FirmwareService firmwareService;
    
    @GetMapping("/latest/{id}")
    public ResponseEntity<Firmware> latest(@PathVariable UUID id) {
        return ResponseEntity.ok(firmwareService.getNewestFirmware(id));
    }
}
