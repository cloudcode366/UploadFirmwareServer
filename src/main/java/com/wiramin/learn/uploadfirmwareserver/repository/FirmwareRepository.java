package com.wiramin.learn.uploadfirmwareserver.repository;

import com.wiramin.learn.uploadfirmwareserver.entity.Firmware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FirmwareRepository extends JpaRepository<Firmware, Long> {
    @Query("select f from Firmware f where f.idDevice.id = :id order by f.firmwareVersion desc limit 1")
    Firmware getNewestFirmware(UUID id);
}
