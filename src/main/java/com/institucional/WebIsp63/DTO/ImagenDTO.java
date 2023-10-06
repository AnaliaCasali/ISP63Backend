package com.institucional.WebIsp63.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder

public class ImagenDTO {
    private int id;
    private String name;
    private String imagenUrl;
    private String imagenId;

}
