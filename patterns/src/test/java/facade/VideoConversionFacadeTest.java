package facade;

import org.junit.Test;

import static org.junit.Assert.*;

public class VideoConversionFacadeTest {
    private static final String NAME_OF_VIDEO_FILE_IN_OGG_CODEC = "nameOfVideoFileInOggCodec";
    private static final String FILE_CODEC_OGG = "ogg";
    private static final String NAME_OF_VIDEO_FILE_IN_MPEG4_CODEC = "nameOfVideoFileInMPEG4Codec";
    private static final String FILE_CODEC_MPEG4 = "mpeg4";
    private OggVideoFile oggVideoFile = new OggVideoFile(NAME_OF_VIDEO_FILE_IN_OGG_CODEC, FILE_CODEC_OGG);
    private MPEG4VideoFile mpeg4VideoFile = new MPEG4VideoFile(NAME_OF_VIDEO_FILE_IN_MPEG4_CODEC, FILE_CODEC_MPEG4);

    @Test
    public void videoConversionFromOggVideoFileToMPEG4VideoFileTest() {
        VideoFile videoFileConvertedToMPEG4 = VideoConversionFacade.convertVideoFileToOtherCodec(oggVideoFile);
        assertTrue(videoFileConvertedToMPEG4 instanceof MPEG4VideoFile);
    }

    @Test
    public void videoConversionFromMPEG4VideoFileToOggVideoFileTest() {
        VideoFile videoFileConvertedToOgg = VideoConversionFacade.convertVideoFileToOtherCodec(mpeg4VideoFile);
        assertTrue(videoFileConvertedToOgg instanceof OggVideoFile);
    }

    @Test
    public void videoConversionNonexistentCodecFileTest() {
        VideoFile videoFileConvertedFromNonexistentCodec = VideoConversionFacade.convertVideoFileToOtherCodec(null);
        assertNull(videoFileConvertedFromNonexistentCodec);
    }

    @Test
    public void videoConversionFromOggVideoFileToOggVideoFileIsImpossibleTest() {
        VideoFile videoFileConvertedToOggFromOgg = VideoConversionFacade.convertVideoFileToOtherCodec(oggVideoFile);
        assertFalse(videoFileConvertedToOggFromOgg instanceof OggVideoFile);
    }

    @Test
    public void videoConversionFromMPEG4VideoFileToMPEG4VideoFileIsImpossibleTest() {
        VideoFile videoFileConvertedToMPEG4FromMPEG4 = VideoConversionFacade.convertVideoFileToOtherCodec(mpeg4VideoFile);
        assertFalse(videoFileConvertedToMPEG4FromMPEG4 instanceof MPEG4VideoFile);
    }

    @Test
    public void videoConversionFromMPEG4VideoFileToOggVideoFileWithNullArgumentMPEG4VideoFile() {
        VideoFile videoFileConvertedToOgg = VideoConversionFacade.convertVideoFileToOtherCodec(new MPEG4VideoFile(null, null));
        assertTrue(videoFileConvertedToOgg instanceof OggVideoFile);
    }

    @Test
    public void videoConversionFromOggVideoFileToMPEG4VideoFileWithNullArgumentOggVideoFile() {
        VideoFile videoFileConvertedToOgg = VideoConversionFacade.convertVideoFileToOtherCodec(new OggVideoFile(null, null));
        assertTrue(videoFileConvertedToOgg instanceof MPEG4VideoFile);
    }

    @Test
    public void videoConversionObjectNotNullTest() {
        VideoFile videoFileConvertedToOgg = VideoConversionFacade.convertVideoFileToOtherCodec(new MPEG4VideoFile(null, null));
        assertNotNull(videoFileConvertedToOgg);
    }

}