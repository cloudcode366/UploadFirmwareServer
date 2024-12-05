package com.wiramin.learn.uploadfirmwareserver.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "device")
@Data
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    
    @OneToMany(mappedBy = "idDevice", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Firmware> firmwareList;
}
