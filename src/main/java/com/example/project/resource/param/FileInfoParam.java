package com.example.project.resource.param;

import com.example.project.common.core.web.BaseParam;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenliming
 * @date 2023/10/29 12:59
 */

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileInfoParam extends BaseParam {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 文件的MD5值
     */
    private String fileMd5;

    /**
     * 父级文件ID
     */
    private String filePid;

    /**
     * 文件大小
     */
    private Long fileSize;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件封面
     */
    private String fileCover;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 文件类型，0表示文件，1表示目录
     */
    private Integer folderType;

    /**
     * 文件分类，1表示视频，2表示音频，3表示图片，4表示文档，5表示其他
     */
    private Integer fileCategory;

    /**
     * 文件具体类型，1表示视频，2表示音频，3表示图片，4表示PDF，5表示文档，6表示Excel，7表示文本，8表示代码，9表示压缩文件，10表示其他
     */
    private Integer fileType;

    /**
     * 文件状态，0表示转码中，1表示转码失败，2表示转码成功
     */
    private Integer status;

    /**
     * 进入回收站的时间
     */
    private Date recoverTime;

    /**
     * 逻辑删除，0表示正常，1表示删除，2表示回收站
     */
    private Integer deleted;
}
