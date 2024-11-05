package com.wiramin.learn.uploadfirmwareserver.repository;

import com.wiramin.learn.uploadfirmwareserver.entity.Firmware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FirmwareRepository extends JpaRepository<Firmware, Long> {
    @Query("select f from Firmware f order by f.firmwareVersion desc limit 1")
    Firmware getNewestFirmware();
}
