package com.wiramin.learn.uploadfirmwareserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

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
    @ManyToOne
    @JoinColumn(name = "idDevice")
    @JsonIgnore
    private Device idDevice;
}
