package com.intellicx.onghub.shared.generics;


public record GenericResponse<Data>(int status, Data data) {
}
