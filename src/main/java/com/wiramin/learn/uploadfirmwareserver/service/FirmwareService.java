package com.wiramin.learn.uploadfirmwareserver.service;

import com.wiramin.learn.uploadfirmwareserver.entity.Firmware;

public interface FirmwareService {
    boolean createFirmware(Firmware firmware);
    Firmware getNewestFirmware();
}
