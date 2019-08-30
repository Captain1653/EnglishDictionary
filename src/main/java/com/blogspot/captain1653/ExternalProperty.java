package com.blogspot.captain1653;

public enum ExternalProperty {

    PATH_TO_FILE {
        @Override
        public String get() {
            return "file";
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
    };

    public abstract String get();
}
