package com.melita.ordersub.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {
    private List<String> messages;
}
