package com.wiramin.learn.uploadfirmwareserver.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "firmware")
@Data
public class Firmware {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firmwareName;
    private Double firmwareVersion;
    private String firmwareUrl;
    private String description;
}
