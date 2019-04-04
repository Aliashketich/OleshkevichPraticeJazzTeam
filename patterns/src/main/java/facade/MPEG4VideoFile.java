package facade;

public class MPEG4VideoFile extends VideoFile {
    public MPEG4VideoFile(String videoFileName, String videoCodecType) {
        this.codecType = videoCodecType;
        this.name = videoFileName;
    }
}

