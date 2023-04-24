package com.example.project.entity_response;

import com.example.project.entity.Review;

public class ReviewResponse {
    private String status;
    private Review review;

    public ReviewResponse(String status, Review review) {
        this.status = status;
        this.review = review;
    }
    private Review getReview() {
        return review;
    }
    private void setReview(Review review) {
        this.review = review;
    }
    private String getStatus() {
        return status;
    }
    private void setStatus(String status) {
        this.status = status;
    }
}
