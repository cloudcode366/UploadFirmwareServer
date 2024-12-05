package com.wiramin.learn.uploadfirmwareserver.service;

import com.wiramin.learn.uploadfirmwareserver.dto.DeviceDto;
import com.wiramin.learn.uploadfirmwareserver.entity.Device;
import com.wiramin.learn.uploadfirmwareserver.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface DeviceService {
    Device createDevice(String name);
    List<DeviceDto> getAllDevices();
    Device getDeviceById(UUID id);
    Device updateDevice(Device device);
}
