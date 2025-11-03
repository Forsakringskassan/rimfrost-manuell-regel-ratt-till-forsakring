package se.fk.github.manuellregelratttillforsakring.integration.dto;

import java.util.UUID;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableOulRequest.class)
public interface OulRequest {

    UUID processId();

    String personNummer();
    
    String uppgift();

}
