package com.wiramin.learn.uploadfirmwareserver.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class DeviceDto {
    private UUID id;
    private String name;
}
