package com.wiramin.learn.uploadfirmwareserver.controller;

import com.wiramin.learn.uploadfirmwareserver.dto.DeviceDto;
import com.wiramin.learn.uploadfirmwareserver.entity.Device;
import com.wiramin.learn.uploadfirmwareserver.entity.Firmware;
import com.wiramin.learn.uploadfirmwareserver.service.DeviceService;
import com.wiramin.learn.uploadfirmwareserver.service.FireBaseService;
import com.wiramin.learn.uploadfirmwareserver.service.FirmwareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/storage")
public class FirmwareStorageController {
    
    private final FireBaseService fireBaseService;
    private final FirmwareService firmwareService;
    private final DeviceService deviceService;
    
    @PostMapping("/upload/{idDevice}")
    public ResponseEntity<String> uploadFile(@RequestParam("file") File file,
                                             @RequestParam("firmwareName") String firmwareName,
//                                             @RequestParam("firmwareVersion") Double firmwareVersion,
                                             @RequestParam("description") String description,
                                             @PathVariable UUID idDevice) throws Exception {
        Firmware latestFirmware = firmwareService.getNewestFirmware(idDevice);
        String url;
        Firmware firmware = new Firmware();
        firmware.setFirmwareName(firmwareName);
        firmware.setFirmwareVersion(latestFirmware==null?1:latestFirmware.getFirmwareVersion()+1);
        firmware.setDescription(description);
        Device device = deviceService.getDeviceById(idDevice);
        firmware.setIdDevice(device);
        
        try {

           url = fireBaseService.upload(file);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        firmware.setFirmwareUrl(url);
        device.getFirmwareList().add(firmware);
//        deviceService.updateDevice(device);
        firmwareService.createFirmware(firmware);
        return ResponseEntity.ok("Upload successful");
    }
    
    @PostMapping("/create-device")
    public ResponseEntity<Device> createDevice(@RequestParam("name") String name) throws Exception {
        return ResponseEntity.ok(deviceService.createDevice(name));
    }
    
    @GetMapping("/get-all-deivce")
    public ResponseEntity<List<DeviceDto>> getAllDevice() throws Exception {
        return ResponseEntity.ok(deviceService.getAllDevices());
    }
}
