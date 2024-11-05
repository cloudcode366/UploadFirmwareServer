package com.wiramin.learn.uploadfirmwareserver.service.impl;

import com.wiramin.learn.uploadfirmwareserver.entity.Firmware;
import com.wiramin.learn.uploadfirmwareserver.repository.FirmwareRepository;
import com.wiramin.learn.uploadfirmwareserver.service.FirmwareService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FirmwareServiceImpl implements FirmwareService {
    private final FirmwareRepository firmwareRepository;
    
    public boolean createFirmware(Firmware firmware) {
        firmwareRepository.save(firmware);
        return true;
    }
    
    public Firmware getNewestFirmware() {
        return firmwareRepository.getNewestFirmware();
    }
}
