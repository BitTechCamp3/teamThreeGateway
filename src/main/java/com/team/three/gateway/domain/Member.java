package com.team.three.gateway.domain;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private String userid;
    private String role;
    private Integer result;
}
