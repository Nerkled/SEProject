package com.lucas;

public interface OutputConfig {

    static interface OutputConfigVisitor {
        public void visitFile(FileOutputConfig fileOutputConfig);
    }

    static void visitOutputConfig(OutputConfig config, OutputConfigVisitor visitor) {
        if (config instanceof FileOutputConfig) {
            visitor.visitFile((FileOutputConfig) config);
        } else {
            throw new RuntimeException("Unexpected config type: " + config.getClass());
        }
    }
}
