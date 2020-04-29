package com.diakogiannis.metropolitan.paper.entities;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@RegisterForReflection
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaceDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String pace;

}
