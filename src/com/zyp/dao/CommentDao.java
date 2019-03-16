package com.zyp.dao;

import java.util.List;

import com.zyp.entity.Comment;

public interface CommentDao {
   public boolean addComment(Comment comment);
   public boolean delComment(int conId);
   public boolean updateComment(Comment comment);
   public List<Comment> queryAllCommentByuId(int uId);
   public List<Comment> queryAllCommentBymId(int mId);
   public Comment queryComment(Comment comment);
}
