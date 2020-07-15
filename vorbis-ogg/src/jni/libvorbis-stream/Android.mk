LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := org.xiph.vorbis-stream
LOCAL_CFLAGS += -I$(LOCAL_PATH)/../include -ffast-math -fsigned-char
ifeq ($(TARGET_ARCH),arm)
	LOCAL_CFLAGS += -march=armv6 -marm -mfloat-abi=softfp -mfpu=vfp
endif


LOCAL_SHARED_LIBRARIES := libogg libvorbis

LOCAL_SRC_FILES := \
	org.xiph.vorbis-fileoutputstream.c \
	org.xiph.vorbis-fileinputstream.c \
	jni-util.c

include $(BUILD_SHARED_LIBRARY)
