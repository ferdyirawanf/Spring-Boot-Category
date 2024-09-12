package com.example.eStoreCategory.DTO.request;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CategoryDTO {
    private Integer id;
    private String name;

    @Data
    @Builder
    public static class Search {
        private String name;
    }
}