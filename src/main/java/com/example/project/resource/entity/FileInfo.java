package com.example.project.resource.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 文件信息表(FileInfo)表实体类
 *
 * @author clm
 * @since 2023-10-29 12:31:30
 */

@Data
@Accessors(chain = true)
public class FileInfo extends Model<FileInfo> {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 文件的MD5值
     */
    private String fileMd5;

    /**
     * 父级文件ID
     */
    private Long filePid;

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
     * 更新时间
     */
    private Date updateTime;

    /**
     * 逻辑删除，0表示正常，1表示删除，2表示回收站
     */
    private Integer deleted;

}

