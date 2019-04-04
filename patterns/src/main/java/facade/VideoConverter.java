package facade;

public class VideoConverter {
    public static MPEG4VideoFile convertOggVideoFileToMPEG4VideoFile(OggVideoFile videoFileWithOggCodec) {
        return new MPEG4VideoFile(videoFileWithOggCodec.name, "MPEG4");
    }

    public static OggVideoFile convertMPEG4VideoFileToOggVideoFile(MPEG4VideoFile videoFileWithMPEG4Codec) {
        return new OggVideoFile(videoFileWithMPEG4Codec.name, "ogg");
    }
}
