package com.worker.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.community.rest.client.api.ProcessDefinitionApi;
import org.camunda.community.rest.client.dto.StartProcessInstanceDto;
import org.camunda.community.rest.client.dto.VariableValueDto;
import org.camunda.community.rest.client.invoker.ApiException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationRequestsListener {

    private final ProcessDefinitionApi processDefinitionApi;

    @RabbitListener(queues = "${app.rabbitmq.queue-name}")
    void receiveMessage(final HashMap<String, String> payload) {
        log.info("Received message {}", payload);
        try {
            processDefinitionApi.startProcessInstanceByKey(
                    "my-project-process",
                    new StartProcessInstanceDto().variables(makeVariables(payload))
            );
        } catch (ApiException ex) {
            log.error("Error start process");
            throw new RuntimeException(ex);
        }
    }

    Map<String, VariableValueDto> makeVariables(HashMap<String, String> payload) {
        return payload.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> new VariableValueDto().type("string").value(entry.getValue())
                ));
    }
}
