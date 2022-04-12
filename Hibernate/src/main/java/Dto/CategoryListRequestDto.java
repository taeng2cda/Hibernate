package Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class CategoryListRequestDto {
    private Integer id;
    private String kind;
    private String keyword;
}
