public class Player {
    private Frame last;
    private FrameDecoder decoder = new FrameDecoder();
    private FrameCache cache = new FrameCache();
    private PlayerUI ui = new PlayerUI();
    void play(byte[] fileBytes){
        // decode
        // Frame f = new Frame(fileBytes); // pretend decoding
        Frame f = decoder.decode(fileBytes);
        last = f;
        // draw UI
        // System.out.println("\u25B6 Playing " + fileBytes.length + " bytes");
        ui.draw(this, f);
        // cache
        // System.out.println("Cached last frame? " + (last!=null));
        cache.store(f);
    }
}