package com.wiramin.learn.uploadfirmwareserver.service.impl;

import com.wiramin.learn.uploadfirmwareserver.dto.DeviceDto;
import com.wiramin.learn.uploadfirmwareserver.entity.Device;
import com.wiramin.learn.uploadfirmwareserver.repository.DeviceRepository;
import com.wiramin.learn.uploadfirmwareserver.service.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;
    
    public Device createDevice(String name) {
         Device device = new Device();
         device.setName(name);
         return deviceRepository.save(device);
    }
    
    public List<DeviceDto> getAllDevices() {
        List<Device> devices = deviceRepository.findAll();
        List<DeviceDto> deviceDtos = new ArrayList<>();
        for(Device device : devices) {
            DeviceDto deviceDto = new DeviceDto();
            deviceDto.setName(device.getName());
            deviceDto.setId(device.getId());
            deviceDtos.add(deviceDto);
        }
        return deviceDtos;
    }
    
    public Device getDeviceById(UUID id) {
        return deviceRepository.findById(id).orElse(null);
    }
    
    public Device updateDevice(Device device) {
        return deviceRepository.save(device);
    }
}
