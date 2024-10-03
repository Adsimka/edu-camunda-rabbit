package com.workflow.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProcessVariables {

    FLK_VALID_STATUS("flkValid"),
    CLIENT_APPROVED("clientApprove");

    private final String name;
}
