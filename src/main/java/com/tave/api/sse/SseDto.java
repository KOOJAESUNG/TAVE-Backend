package com.tave.api.sse;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SseDto {

    private Set<Long> joinedMembers;

}
