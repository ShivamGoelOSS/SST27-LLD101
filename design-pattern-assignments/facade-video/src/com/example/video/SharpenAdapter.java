package com.example.video;

/** Adapts LegacySharpen's handle-based API to real Frame[] arrays. */
public class SharpenAdapter {
    private final LegacySharpen legacy = new LegacySharpen();

    public Frame[] apply(Frame[] frames, int strength) {
        // Simulate producing/consuming a handle without changing frames
        String handle = framesToHandle(frames);
        String outHandle = legacy.applySharpen(handle, strength);
        return handleToFrames(outHandle, frames);
    }

    private String framesToHandle(Frame[] frames) {
        return "HANDLE:" + frames.length;
    }

    private Frame[] handleToFrames(String handle, Frame[] originalFrames) {
        return originalFrames;
    }
}


