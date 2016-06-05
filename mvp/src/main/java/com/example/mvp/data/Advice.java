package com.example.mvp.data;

import org.xutils.http.annotation.HttpResponse;

import java.util.Date;

/* *
* 作者：李赞红 on 2016/06/03 17:31
* 邮箱：lifenote@21cn.com
* 版权所有：韬睿科技 新程IT教育
*/

@HttpResponse(parser = AdviceDataSource.AdviceJSONResponseParser.class)
public class Advice {
    private int id;
    private int uid;
    private String content;
    private String reply;
    private Date createTime;
    private Date replydate;
    private int replyUid;

    public Advice() {
    }

    public Advice(int uid, String content, Date createTime) {
        this.uid = uid;
        this.content = content;
        this.createTime = createTime;
    }

    public Advice(int id, int uid, String content, String reply, Date createTime, Date replydate, int replyUid) {
        this.id = id;
        this.uid = uid;
        this.content = content;
        this.reply = reply;
        this.createTime = createTime;
        this.replydate = replydate;
        this.replyUid = replyUid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getReplydate() {
        return replydate;
    }

    public void setReplydate(Date replydate) {
        this.replydate = replydate;
    }

    public int getReplyUid() {
        return replyUid;
    }

    public void setReplyUid(int replyUid) {
        this.replyUid = replyUid;
    }
}
