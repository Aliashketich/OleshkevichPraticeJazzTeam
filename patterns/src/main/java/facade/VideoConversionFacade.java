package facade;

public class VideoConversionFacade {
    public static VideoFile convertVideoFileToOtherCodec(VideoFile videoFileWithSetCodec) {
        VideoFile convertedVideoFile = null;

        if (videoFileWithSetCodec instanceof OggVideoFile) {
            convertedVideoFile = VideoConverter.convertOggVideoFileToMPEG4VideoFile((OggVideoFile) videoFileWithSetCodec);
        } else if (videoFileWithSetCodec instanceof MPEG4VideoFile) {
            convertedVideoFile = VideoConverter.convertMPEG4VideoFileToOggVideoFile((MPEG4VideoFile) videoFileWithSetCodec);
        }

        return convertedVideoFile;
    }
}
