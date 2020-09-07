package com.fuzeto.springbootdynamodb.controller.input;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductInput {

    private String name;
    private String cost;
}
