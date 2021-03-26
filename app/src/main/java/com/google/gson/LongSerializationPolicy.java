package com.google.gson;

public enum LongSerializationPolicy {
    DEFAULT {
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l2) {
            return new JsonPrimitive(l2);
        }
    },
    STRING {
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l2) {
            return new JsonPrimitive(String.valueOf(l2));
        }
    };

    public abstract JsonElement serialize(Long l2);
}
