package by.onlineStore.service.impl;

import by.onlineStore.dto.CommentDto;
import by.onlineStore.dto.CreateCommentDto;
import by.onlineStore.exception.NotFoundException;
import by.onlineStore.mapper.CommentMapper;
import by.onlineStore.repository.CommentRepository;
import by.onlineStore.repository.ProductRepository;
import by.onlineStore.repository.UserRepository;
import by.onlineStore.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public CommentDto getCommentById(Long commentId) {

        return commentMapper.convertToCommentDto(commentRepository.findOneById(commentId)
                .orElseThrow(() -> new NotFoundException("Comment not found")));
    }

    @Override
    public List<CommentDto> getAllComments() {

        return commentMapper.convertToListCommentDto(commentRepository.findAll());
    }

    @Override
    public void deleteComment(Long commentId) {

        commentRepository.delete(commentId);
    }

    @Override
    public CommentDto saveComment(CreateCommentDto createCommentDto) {

        return commentMapper.convertToCommentDto(commentRepository.saveAndFlush(
                commentMapper.convertToComment(createCommentDto, userRepository.findOneById(
                        createCommentDto.getUserId()).orElseThrow(() -> new NotFoundException("User  not found")),
                        productRepository.findOneById(createCommentDto.getProductId())
                                .orElseThrow(() -> new NotFoundException("Product not found")))));
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto) {

        return commentMapper.convertToCommentDto(commentRepository.saveAndFlush(
                commentMapper.convertToComment(commentDto)));
    }
}
