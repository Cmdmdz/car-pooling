package com.cdx.carpooling.repositories.dao;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TRAVEL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Travel {

   @Id
    private String id;
    private String name;
    private String origin;
    private String destination;
    private String datetime;
    private String detail;

}
