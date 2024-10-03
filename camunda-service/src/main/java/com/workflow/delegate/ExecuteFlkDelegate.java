package com.workflow.delegate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workflow.enums.ProcessVariables;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class ExecuteFlkDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("We pass FLK");
        boolean flkStatus = new Random().nextBoolean();

        delegateExecution.setVariable(ProcessVariables.FLK_VALID_STATUS.getName(), flkStatus);
        delegateExecution.setVariable(ProcessVariables.CLIENT_APPROVED.getName(), false);

        log.info(new ObjectMapper().writeValueAsString(delegateExecution.getVariables()));
    }
}
