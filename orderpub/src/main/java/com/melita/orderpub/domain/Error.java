package com.melita.orderpub.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {
    private List<String> messages;
}
