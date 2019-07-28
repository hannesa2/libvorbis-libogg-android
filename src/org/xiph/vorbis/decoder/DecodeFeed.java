package org.xiph.vorbis.decoder;

/**
 * A feed interface which raw PCM data will be written to and encoded vorbis data will be read from
 * User: vincent
 * Date: 3/27/13
 * Time: 2:11 PM
 */
public interface DecodeFeed {
    /**
     * Everything was a success
     */
    int SUCCESS = 0;

    /**
     * The bitstream is not ogg
     */
    int INVALID_OGG_BITSTREAM = -21;

    /**
     * Failed to read first page
     */
    int ERROR_READING_FIRST_PAGE = -22;

    /**
     * Failed reading the initial header packet
     */
    int ERROR_READING_INITIAL_HEADER_PACKET = -23;

    /**
     * The data is not a vorbis header
     */
    int NOT_VORBIS_HEADER = -24;

    /**
     * The secondary header is corrupt
     */
    int CORRUPT_SECONDARY_HEADER = -25;

    /**
     * Reached a premature end of file
     */
    int PREMATURE_END_OF_FILE = -26;

    /**
     * Triggered from the native {@link VorbisDecoder} that is requesting to read the next bit of vorbis data
     *
     * @param buffer        the buffer to write to
     * @param amountToWrite the amount of vorbis data to write
     * @return the amount actually written
     */
    int readVorbisData(byte[] buffer, int amountToWrite);

    /**
     * Triggered from the native {@link VorbisDecoder} that is requesting to write the next bit of raw PCM data
     *
     * @param pcmData      the raw pcm data
     * @param amountToRead the amount available to read in the buffer
     */
    void writePCMData(short[] pcmData, int amountToRead);

    /**
     * To be called when decoding has completed
     */
    void stop();

    /**
     * Puts the decode feed in the reading header state
     */
    void startReadingHeader();

    /**
     * To be called when decoding has started
     *
     * @param decodeStreamInfo the stream information of what's about to be played
     */
    void start(DecodeStreamInfo decodeStreamInfo);
}
