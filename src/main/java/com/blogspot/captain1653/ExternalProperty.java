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
    };

    public abstract String get();
}
