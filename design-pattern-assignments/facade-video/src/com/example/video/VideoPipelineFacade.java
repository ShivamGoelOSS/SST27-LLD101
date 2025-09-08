package com.example.video;
import java.nio.file.Path;
import java.util.Objects;

public class VideoPipelineFacade {
    public Path process(Path src, Path out, boolean gray, Double scale, Integer sharpenStrength) {
        Objects.requireNonNull(src, "src");
        Objects.requireNonNull(out, "out");

        Decoder dec = new Decoder();
        FilterEngine fe = new FilterEngine();
        Encoder enc = new Encoder();
        SharpenAdapter sharpen = new SharpenAdapter();

        Frame[] frames = dec.decode(src);
        if (gray) {
            frames = fe.grayscale(frames);
        }
        if (scale != null) {
            frames = fe.scale(frames, scale.doubleValue());
        }
        if (sharpenStrength != null) {
            frames = sharpen.apply(frames, sharpenStrength.intValue());
        }
        return enc.encode(frames, out);
    }
}


