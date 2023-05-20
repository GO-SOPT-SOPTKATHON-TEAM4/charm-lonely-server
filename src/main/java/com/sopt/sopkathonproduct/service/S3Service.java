package com.sopt.sopkathonproduct.service;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.sopt.sopkathonproduct.common.util.S3Util;
import com.sopt.sopkathonproduct.domain.entity.Post;
import com.sopt.sopkathonproduct.dto.request.UploadRequestDTO;
import com.sopt.sopkathonproduct.dto.response.UploadResponseDTO;
import com.sopt.sopkathonproduct.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class S3Service {

    private final S3Util s3Util;

    private final PostRepository postRepository;
    private static final String IMAGE_FOLDER_NAME = "images";

    @Transactional
    public UploadResponseDTO uploadPost(MultipartFile image, UploadRequestDTO requestDTO) {

            try {
                NicknameValidator.validate(requestDTO.getNickname());
                String uploadFilePath = IMAGE_FOLDER_NAME + "/" + getFoldername();
                String uploadFileName = uploadFilePath + "/" + image.getOriginalFilename();


                String uploadImageUrl = s3Util.upload(getInputStream(image), uploadFileName, getObjectMetadata(image));

                Post post = Post.builder()
                        .imageUrl(uploadImageUrl)
                        .nickname(requestDTO.getNickname())
                        .comment(requestDTO.getComment())
                        .point(0L)
                        .build();

                postRepository.save(post);

                return UploadResponseDTO.builder()
                        .postId(post.getId())
                        .build();

            } catch (MethodArgumentNotValidException | IOException e) {
                throw new RuntimeException("이미지 업로드에 실패했습니다.");
            }
        }
        private String getFoldername() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            Date date = new Date();
            return sdf.format(date);
        }

        private ObjectMetadata getObjectMetadata(MultipartFile file) {
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(file.getSize());
            objectMetadata.setContentType(file.getContentType());
            return objectMetadata;
        }

        private InputStream getInputStream(MultipartFile file) throws IOException {
            return file.getInputStream();
        }

        private String extractExtension(MultipartFile file) {
            try {
                return file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            } catch (StringIndexOutOfBoundsException e) {
                throw new RuntimeException("잘못된 형식의 파일입니다.");
            }
        }

}
