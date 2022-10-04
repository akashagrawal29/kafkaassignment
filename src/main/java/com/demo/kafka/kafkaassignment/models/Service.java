package com.demo.kafka.kafkaassignment.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Service implements Serializable {
    @Id
    String case_NUMBER;
    String svc_ID;
    String svc_TYPE;
    String svc_CODE;
    String svc_FAC_ID;
    String svc_FAC_NAME;
    String svc_PHY_ID;
    String svc_PHY_NAME;
    String mysource;
}
