package com.wiramin.learn.uploadfirmwareserver.repository;

import com.wiramin.learn.uploadfirmwareserver.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeviceRepository extends JpaRepository<Device, UUID> {
    
}
