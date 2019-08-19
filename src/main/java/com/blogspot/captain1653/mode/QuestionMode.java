package com.blogspot.captain1653.mode;

public enum QuestionMode {

    RU {
        @Override
        public String getMode() {
            return "ru";
        }
    },
    EN {
        @Override
        public String getMode() {
            return "en";
        }
    },
    MIX {
        @Override
        public String getMode() {
            return "mix";
        }
    };

    public abstract String getMode();
}
