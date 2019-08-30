package com.blogspot.captain1653;

public enum ExternalProperty {

    FILES {
        @Override
        public String get() {
            return "files";
        }
    },

    MODE {
        @Override
        public String get() {
            return "mode";
        }
    },
    PATH_TO_CONFIG {
        @Override
        public String get() {
            return "config";
        }
    },

    TYPE_WORD {
        @Override
        public String get() {
            return "type-word";
        }
    };

    public abstract String get();
}
