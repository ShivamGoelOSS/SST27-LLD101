# Facade (+Adapter optional) — Video Pipeline (Refactoring)

## Narrative (Current Code)
Caller wires 3 subsystems (`Decoder`, `FilterEngine`, `Encoder`) and can't easily use a legacy sharpen filter with an odd API. Too much ordering knowledge leaks to the client.

## Your Task
- Implement `VideoPipelineFacade`:
  ```java
  java.nio.file.Path process(java.nio.file.Path src, java.nio.file.Path out, boolean gray, Double scale, Integer sharpenStrength)
  ```
- Sequence inside: decode → optional grayscale → optional scale → optional sharpen → encode.
- **Adapter (required):** create `SharpenAdapter` that adapts a legacy `LegacySharpen` API to work with real frames.

## Acceptance Criteria
- `App` calls only the facade
- Sharpen step adjustable via `sharpenStrength`
- Legacy API is never used directly by `App`

## Hints
- You can simulate frame handles as strings if needed
- Keep `Frame` as a simple data class

## Build & Run
```bash
cd facade-video/src
javac com/example/video/*.java
java com.example.video.App
```

## Solution
- Problem: Client wired decode/filter/encode and couldn't use a legacy sharpen filter easily.
- Intent: Facade sequences the pipeline; Adapter wraps legacy API.
- Key pieces: `VideoPipelineFacade` (facade), `SharpenAdapter` (adapter), `LegacySharpen`, `Decoder`, `FilterEngine`, `Encoder`.
- Flow: Facade: decode → optional grayscale → optional scale → optional sharpen (via adapter) → encode; `App` uses only the facade.
- Run: `cd facade-video/src && javac com/example/video/*.java && java com.example.video.App`