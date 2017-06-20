package by.onlineStore.service;

import by.onlineStore.dto.CommentDto;
import by.onlineStore.dto.CreateCommentDto;

import java.util.List;

public interface CommentService {

    CommentDto getCommentById(Long commentId);

    List<CommentDto> getAllComments();

    void deleteComment(Long commentId);

    CommentDto saveComment(CreateCommentDto createCommentDto);

    CommentDto updateComment(CommentDto commentDto);
}