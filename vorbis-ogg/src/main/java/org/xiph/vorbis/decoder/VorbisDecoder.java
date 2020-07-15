package org.xiph.vorbis.decoder;

/**
 * The native org.xiph.vorbis decoder to be used in conjunction with JNI
 * User: vincent
 * Date: 3/27/13
 * Time: 9:07 AM
 */
public class VorbisDecoder {

    /**
     * Load our org.xiph.vorbis-jni library and other dependent libraries
     */
    static {
        System.loadLibrary("ogg");
        System.loadLibrary("org/xiph/vorbis");
        System.loadLibrary("org.xiph.vorbis-jni");
    }

    /**
     * Start decoding the data by way of a jni call
     *
     * @param decodeFeed the custom decode feed
     * @return the result code
     */
    public static native int startDecoding(DecodeFeed decodeFeed);
}
