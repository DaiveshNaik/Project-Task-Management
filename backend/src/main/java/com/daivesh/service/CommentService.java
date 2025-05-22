package com.daivesh.service;

import com.daivesh.exception.IssueException;
import com.daivesh.exception.UserException;
import com.daivesh.model.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Long issueId, Long userId, String comment) throws UserException, IssueException;

    void deleteComment(Long commentId, Long userId) throws UserException, IssueException;

    List<Comment> findCommentByIssueId(Long issueId);

}
