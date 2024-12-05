package com.wiramin.learn.uploadfirmwareserver.service;

import com.wiramin.learn.uploadfirmwareserver.entity.Firmware;

import java.util.UUID;

public interface FirmwareService {
    boolean createFirmware(Firmware firmware);
    Firmware getNewestFirmware(UUID uuid);
}
