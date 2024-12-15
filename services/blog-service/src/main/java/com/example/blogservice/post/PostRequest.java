package com.example.blogservice.post;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

/**
 * Example JSON body for creating a new post using the PostRequest structure.
 * <p>
 * This example demonstrates the expected structure and values for adding a new post.
 * <p>
 * JSON Example:
 * <pre>
 * {
 *   "id": 1,
 *   "title": "A Comprehensive Guide to Testing in Java",
 *   "content": "This article explores the best practices for testing in Java...",
 *   "author": "John Doe",
 *   "photo": "https://example.com/images/post-thumbnail.jpg"
 * }
 * </pre>
 * <p>
 * Notes:
 * - The `id` field is required and must be unique.
 * - The `photo` field is optional and may be null.
 *
 * @since 1.0
 */

@Builder
@Validated
public record PostRequest(

        String title,
        String content,
        @NotNull(message = "author should be present")
        @NotEmpty(message = "author should be present")
        @NotBlank(message = "author should be present")
        String author,
        String photo


) {
}
