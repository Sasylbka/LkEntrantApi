package ru.esstu.entrant.lk.domain.vo.Additionals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Keycloak {
    private String keycloakGuid;
}
