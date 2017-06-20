package by.onlineStore.mapper;

import by.onlineStore.bean.Comment;
import by.onlineStore.bean.Product;
import by.onlineStore.bean.User;
import by.onlineStore.dto.CommentDto;
import by.onlineStore.dto.CreateCommentDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CommentMapper {

    public Comment convertToComment(CommentDto commentDto) {
        return Optional.of(commentDto).map(localCommentDto -> {
            Comment comment = new Comment();
            comment.setId(localCommentDto.getId());
            comment.setText(localCommentDto.getText());
            comment.setEvaluation(localCommentDto.getEvaluation());
            return comment;
        }).orElse(null);
    }

    public CommentDto convertToCommentDto(Comment comment) {
        return Optional.of(comment).map(localComment -> {
            CommentDto commentDto = new CommentDto();
            commentDto.setId(localComment.getId());
            commentDto.setText(localComment.getText());
            commentDto.setEvaluation(localComment.getEvaluation());
            commentDto.setUserId(localComment.getUser().getId());
            commentDto.setProductId(localComment.getProduct().getId());
            return commentDto;
        }).orElse(null);
    }

    public Comment convertToComment(CreateCommentDto createCommentDto, User user, Product product) {
        return Optional.of(createCommentDto).map(localCreateCommentDto -> {
            Comment comment = new Comment();
            comment.setText(localCreateCommentDto.getText());
            comment.setEvaluation(localCreateCommentDto.getEvaluation());
            comment.setUser(user);
            comment.setProduct(product);
            return comment;
        }).orElse(null);
    }

    public List<CommentDto> convertToListCommentDto(List<Comment> commentList) {

        return Optional.ofNullable(commentList).map(localCommentList ->
                localCommentList.stream()
                        .map(this::convertToCommentDto)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }
}
