package facade;

public class OggVideoFile extends VideoFile {
    public OggVideoFile(String videoFileName, String videoCodecType) {
        this.codecType = videoCodecType;
        this.name = videoFileName;
    }
}
