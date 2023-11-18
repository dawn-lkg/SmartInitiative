package com.example.project.resource.fileEnum;

import com.example.project.resource.constans.FileInfoConstants;

/**
 * @author chenliming
 * @date 2023/10/31 20:37
 */
public enum FileType {
    mp4(FileInfoConstants.FILE_TYPE_VIDEO),
    avi(FileInfoConstants.FILE_TYPE_VIDEO),
    wmv(FileInfoConstants.FILE_TYPE_VIDEO),
    mpeg(FileInfoConstants.FILE_TYPE_VIDEO),
    mp3(FileInfoConstants.FILE_TYPE_AUDIO),
    flac(FileInfoConstants.FILE_TYPE_AUDIO),
    midi(FileInfoConstants.FILE_TYPE_AUDIO),
    bmp(FileInfoConstants.FILE_TYPE_IMG),
    jpg(FileInfoConstants.FILE_TYPE_IMG),
    png(FileInfoConstants.FILE_TYPE_IMG),
    tif(FileInfoConstants.FILE_TYPE_IMG),
    gif(FileInfoConstants.FILE_TYPE_IMG),
    pcx(FileInfoConstants.FILE_TYPE_IMG),
    svg(FileInfoConstants.FILE_TYPE_IMG),
    psd(FileInfoConstants.FILE_TYPE_IMG),
    webp(FileInfoConstants.FILE_TYPE_IMG),
    pdf(FileInfoConstants.FILE_TYPE_PDF),
    doc(FileInfoConstants.FILE_TYPE_DOC),
    docx(FileInfoConstants.FILE_TYPE_DOC),
    xlsx(FileInfoConstants.FILE_TYPE_EXCEL),
    txt(FileInfoConstants.FILE_TYPE_TXT),
    java(FileInfoConstants.FILE_TYPE_CODE),
    js(FileInfoConstants.FILE_TYPE_CODE),
    c(FileInfoConstants.FILE_TYPE_CODE),
    html(FileInfoConstants.FILE_TYPE_CODE),
    rar(FileInfoConstants.FILE_TYPE_ZIP),
    zip(FileInfoConstants.FILE_TYPE_ZIP),
    other(FileInfoConstants.FILE_TYPE_OTHER);

    private final int value;

    FileType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static int getFileType(String type) {
        try {
            FileType fileType = FileType.valueOf(type);
            int value = fileType.getValue();
            return value;
        } catch (IllegalArgumentException e) {
            return FileType.other.getValue();
        }
    }
}

